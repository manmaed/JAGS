package com.unrealdinnerbone.jags;

import com.unrealdinnerbone.jags.item.GrassSeed;
import com.unrealdinnerbone.trenzalore.api.platform.services.IRegistry;
import com.unrealdinnerbone.trenzalore.api.registry.Regeneration;
import com.unrealdinnerbone.trenzalore.api.registry.RegistryEntry;
import com.unrealdinnerbone.trenzalore.api.registry.RegistryObjects;
import com.unrealdinnerbone.trenzalore.lib.CreativeTabs;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

import java.util.Arrays;
import java.util.List;

public class JAGSRegistry implements IRegistry {

    private static final RegistryObjects<Item> ITEMS = Regeneration.create(Registries.ITEM);

    public static final RegistryEntry<GrassSeed> GRASS_SEED = ITEMS.register("grass_seed", GrassSeed::new);

    @Override
    public void afterRegistered() {
        Regeneration.addItemsToCreateTab(CreativeTabs.TOOLS_AND_UTILITIES, List.of(GRASS_SEED));
    }

    @Override
    public List<RegistryObjects<?>> getRegistryObjects() {
        return Arrays.asList(ITEMS);
    }

    @Override
    public String getModID() {
        return JAGS.MOD_ID;
    }
}
