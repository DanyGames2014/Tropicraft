package net.danygames2014.tropicraft.mixin;

import net.fabricmc.loader.api.FabricLoader;
import net.glasslauncher.mods.gcapi3.impl.GlassYamlFile;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class TropicraftMixinPlugin implements IMixinConfigPlugin {
    //public static GlassYamlFile other_config;

    @Override
    public void onLoad(String mixinPackage) {
//        File file = new File(FabricLoader.getInstance().getConfigDir().toFile(), "tropicraft/other.yml");
//
//        other_config = new GlassYamlFile();
//        try {
//            other_config.load(file);
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//            //noinspection CallToPrintStackTrace
//            e.printStackTrace();
//        }
    }

    @Override
    public String getRefMapperConfig() {
        return null; // null = default behaviour
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return null; // null = I don't wish to append any mixin
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @SuppressWarnings("RedundantIfStatement")
    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.equals("net.danygames2014.tropicraft.mixin.records.MusicDiscItemMixin")) {
            return !FabricLoader.getInstance().isModLoaded("musicdiscs");
        }

        return true;
    }

    public static boolean isDisabled(String mixinClassName, String mixinName, GlassYamlFile config, String configBool) {
        if (config.contains(configBool)) {
            return mixinClassName.equals("net.danygames2014.unitweaks.mixin." + mixinName) && !config.getBoolean(configBool);
        }
        return false;
    }
}
