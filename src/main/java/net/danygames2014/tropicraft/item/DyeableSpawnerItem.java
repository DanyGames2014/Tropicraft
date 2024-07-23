package net.danygames2014.tropicraft.item;

import net.danygames2014.tropicraft.entity.Dyeable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class DyeableSpawnerItem extends TemplateItem {
    public Class<? extends Entity> spawnedEntity;

    public DyeableSpawnerItem(Identifier identifier, Class<? extends Entity> spawnedEntity) {
        super(identifier);
        this.spawnedEntity = spawnedEntity;
    }

    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int xPos, int yPos, int zPos, int side) {
        if (world.isRemote) {
            return true;
        }

        double x = xPos;
        double y = yPos;
        double z = zPos;


        try {
            // Create Entity
            Entity entity = spawnedEntity.getDeclaredConstructor(World.class).newInstance(world);

            System.out.println(entity.height);

            // Determine coordinates according to block side
            switch (side) {
                case 0: // BOTTOM (Y--)
                    y -= entity.height;
                    break;
                case 1: // TOP (Y++)
                    y += (Math.max(entity.height, 0.5F) + 1F);
                    x += 0.5;
                    z += 0.5;
                    break;
                case 2: // SIDE (Z--)
                    z -= 0.5;
                    x += 0.5;
                    break;
                case 3: // SIDE (Z++)
                    z += 1.5;
                    x += 0.5;
                    break;
                case 4: // SIDE (X--)
                    x -= 0.5;
                    z += 0.5;
                    break;
                case 5: // SIDE (X++)
                    x += 1.5;
                    z += 0.5;
                    break;
                default:
                    y++;
                    break;
            }

            // Set the Entity position
            entity.setPos(x, y, z);

            // Spawn the Entity
            world.spawnEntity(entity);

            // Dye the entity
            dyeEntity(stack, entity);

            stack.count--;
            return true;

        } catch (Exception ignored) {
            return false;
        }
    }

    public void dyeEntity(ItemStack stack, Entity entity) {
        if (entity instanceof Dyeable dyeable) {
            dyeable.setColor(DyeItem.colors[stack.getDamage()]);
        }
    }

}
