package net.danygames2014.tropicraft.world.dimension;

import net.danygames2014.tropicraft.util.MathHelper;
import net.danygames2014.tropicraft.util.Spline;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.LoadingDisplay;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkSource;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.block.States;
import net.modificationstation.stationapi.impl.world.chunk.ChunkSection;
import net.modificationstation.stationapi.impl.world.chunk.FlattenedChunk;

import java.lang.annotation.ElementType;
import java.util.Random;

public class ChunkProviderTropics implements ChunkSource {
    private final World world;
    public Random random;

    public Spline heightSpline = new Spline();
    public Spline squashSpline = new Spline();
    public Spline erosionSpline = new Spline();
    public Spline pvSpline = new Spline();

    public TropiNoiseSampler2D continentalNoise;
    public TropiNoiseSampler2D erosionNoise;
    public TropiNoiseSampler2D peaksValleysNoise;
    public TropiNoiseSampler2D riverNoise;
    public TropiNoiseSampler2D biomeNoise;

    public TropiNoiseSampler3D terrainNoise;

    public ChunkProviderTropics(World world, long seed, TropicsDimension tropicsDimension) {
        this.world = world;
        this.random = new Random(seed);

        this.continentalNoise = tropicsDimension.continentalNoise;
        this.erosionNoise = tropicsDimension.erosionNoise;
        this.peaksValleysNoise = tropicsDimension.peakValleyNoise;
        this.riverNoise = tropicsDimension.riverNoise;
        this.biomeNoise = tropicsDimension.biomeNoise;

        this.terrainNoise = tropicsDimension.terrainNoise;

        initSplines();
    }

    public void initSplines() {
        // Height Spline
        // Sea Level is 64

        // 1.0 to 0.0: Landmass
        heightSpline.addPoint(1.0f, 100.0f);
        heightSpline.addPoint(0.8f, 85.0f);
        heightSpline.addPoint(0.5f, 71.0f);
        heightSpline.addPoint(0.3f, 67.0f);
        heightSpline.addPoint(0.1f, 66.0f);

        // -0.05 to 0.0: Beach
        heightSpline.addPoint(0.0f, 65.0f);
        heightSpline.addPoint(-0.09f, 64.0f);

        // 0.0 to -0.8: THE OPEN SEA
        heightSpline.addPoint(-0.35f, 55.0f);
        heightSpline.addPoint(-0.75f, 50.0f);

        // -0.8 to -1.0: Tropical Islands
        heightSpline.addPoint(-0.80f, 64.0f);
        heightSpline.addPoint(-0.94f, 70.0f);
        heightSpline.addPoint(-1.0f, 85.0f);

        for (float i = 1.0F; i > -1.0F; i -= 0.01F) {
            System.out.println(i + ": " + heightSpline.sample(i));
        }

        // Squash Spline
        squashSpline.addPoint(1.0f, 1.2f);   // Extreme 3D verticality for mainland
        squashSpline.addPoint(0.1f, 10.0f);  // Flatten the mainland beaches
        squashSpline.addPoint(-0.4f, 4.0f);  // Standard sea floor
        squashSpline.addPoint(-1.0f, 2.5f);  // Rugged enough for atolls

        // Erosion Spline
        erosionSpline.addPoint(-0.5f, 7.0f);
        erosionSpline.addPoint(0.0f, 3.0f);
        erosionSpline.addPoint(0.2f, 0.0f);
        erosionSpline.addPoint(0.4f, -2.0f);
        erosionSpline.addPoint(0.8f, -8.0f);
        erosionSpline.addPoint(1.0f, -12.0f);

        // Peaks & Valleys Spline
        pvSpline.addPoint(-1.0f, -10.0f);
        pvSpline.addPoint(-0.3f, -2.0f);
        pvSpline.addPoint(0.0f, 0.0f);
        pvSpline.addPoint(0.4f, 7.0f);
        pvSpline.addPoint(0.8f, 10.0f);
        pvSpline.addPoint(1.0f, 25.0f);
    }

    public double calculateDensity(int x, int y, int z, double c, double e, double riv) {
        // Base Terrain Height
        float finalHeight = heightSpline.sample((float) c);

        // Erosion
        float erosionOffset = erosionSpline.sample((float) e);
        
        // Rivers
        if (riv < 0.06f) {
            float intensity = (1.0f - ((float) riv / 0.06f));

            erosionOffset *= (1.0f - intensity);
            
            // Target height for the river bed (60.0f is 4 blocks below your y=64 water)
            float riverFloor = 60.0f;

            // Blend finalHeight down to riverFloor based on intensity
            // This carves a path through the cliff without adding "depth" to the bottom of the world
            finalHeight += erosionOffset;
            finalHeight = finalHeight + (riverFloor - finalHeight) * intensity;
        } else {
            finalHeight += erosionOffset;
        }

        return (finalHeight - y) / 4.0;
    }

    public BlockState resolveBlock(int x, int y, int z, double c, double e, double riv, double density) {
        // --- AIR AND WATER ---
        if (density <= 0) {
            // Anything below sea level that isn't solid ground becomes water
            return (y <= 64) ? States.AIR.get() : States.AIR.get();
        }

        // --- SOLID TERRAIN ---
        // Check if there is air or water above to determine if this is the "Surface"
        boolean surface = (y >= 127 || calculateDensity(x, y + 1, z, c, e, riv) <= 0);

        if (surface) {
            float erosionOffset = erosionSpline.sample((float) e);
            
            // RIVER BED (If surface is underwater)
            if (y <= 63) {
                if (riv < 0.06f) {
                    return Block.BRICKS.getDefaultState();
                } else {
                    if (c < -0.4) {
                        return Block.LAPIS_BLOCK.getDefaultState();
                    }
                    return Block.DIAMOND_BLOCK.getDefaultState();
                }
            }

            float beachLimit = 65.0f + erosionOffset;
            
            // MAINLAND BEACH / SHALLOWS (0.1 to 0.0)
            if (c < 0.0f && c > -0.5f && y <= beachLimit) {
                return Block.SAND.getDefaultState();
            }
            
            // MAINLAND (1.0 to 0.0)
            if (c > 0.0f) {
                if (y > 90) {
                    return Block.STONE.getDefaultState();
                } else {
                    return Block.GRASS_BLOCK.getDefaultState();
                }
            }

            // TROPICAL ISLAND (-0.8 to -1.0)
            if (c < -0.8f) {
                return Block.GOLD_BLOCK.getDefaultState();
            }
        }

        // --- UNDERGROUND ---
        return (y < 50) ? Block.STONE.getDefaultState() : Block.DIRT.getDefaultState();
    }

    @Override
    public Chunk getChunk(int chunkX, int chunkZ) {
        FlattenedChunk chunk = new FlattenedChunk(world, chunkX, chunkZ);

        // Place Bedrock Layer
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                chunk.setBlockState(x, 0, z, Block.BEDROCK.getDefaultState());
            }
        }

        // Place Other Layers
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                int worldX = (chunkX * 16) + x;
                int worldZ = (chunkZ * 16) + z;

                double c = continentalNoise.samplePoint(worldX, worldZ, 0.001, 0.001) * 1.9D;
                double e = erosionNoise.samplePoint(worldX, worldZ, 0.005, 0.005);
                double riv = Math.abs(riverNoise.samplePoint(worldX, worldZ, 0.0025, 0.0025));

                float erosionOffset = erosionSpline.sample((float) e);
                double seaThreshold = -0.09D - (Math.max(0, erosionOffset) * 0.02D);
                
                // Widen rivers approaching sea
                if (c > seaThreshold && c < 0.0f) {
                    riv -= MathHelper.clamp((Math.abs(c) * 0.25D), -0.02D, 0.00D);
                }

                // Reduce the effect of rivers as they blend into sea
                if (c <= seaThreshold) {
                    double erosionMuffler = MathHelper.clamp(1.0D - (erosionOffset / 10.0D), 0.0D, 1.0D);
                    riv += (Math.abs(c) + seaThreshold) * erosionMuffler;
                }

                for (int y = 0; y < 127; y++) {
                    double dens = calculateDensity(worldX, y, worldZ, c, e, riv);
                    BlockState state = resolveBlock(worldX, y, worldZ, c, e, riv, dens);
                    setChunkState(chunk, x, y, z, state);
                }
            }
        }

        chunk.populateHeightMap();
        chunk.populateBlockLight();

        return chunk;
    }

    @Override
    public void decorate(ChunkSource source, int x, int z) {

    }

    @Override
    public boolean isChunkLoaded(int x, int z) {
        return true;
    }

    @Override
    public Chunk loadChunk(int chunkX, int chunkZ) {
        return this.getChunk(chunkX, chunkZ);
    }

    private void setChunkState(FlattenedChunk chunk, int x, int y, int z, BlockState state) {
        ChunkSection section = chunk.getOrCreateSection(y, true);
        if (section == null) {
            return;
        }

        section.setBlockState(x, y & 15, z, state);
        chunk.dirty = true;
    }

    @Override
    public boolean save(boolean flag, LoadingDisplay loadingDisplay) {
        return false;
    }

    @Override
    public boolean tick() {
        return false;
    }

    @Override
    public boolean canSave() {
        return false;
    }

    @Override
    public String getDebugInfo() {
        return "TropicsChunkSource";
    }
}
