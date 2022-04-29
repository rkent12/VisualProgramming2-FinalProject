package net.ryankent.practicemod.world.dimension;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.ryankent.practicemod.PracticeMod;

public class ModDimensions {
    private static final RegistryKey<DimensionOptions> DIMENSION_KEY = RegistryKey.of(Registry.DIMENSION_KEY,
            new Identifier(PracticeMod.MOD_ID, "kjdim"));
    public static RegistryKey<World> KJDIM_KEY = RegistryKey.of(Registry.WORLD_KEY, DIMENSION_KEY.getValue());
    private static final RegistryKey<DimensionType> DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            new Identifier(PracticeMod.MOD_ID, "kjdim_type"));

    public static void register() {
        System.out.println("Registering ModDimensions for " + PracticeMod.MOD_ID);
    }
}
