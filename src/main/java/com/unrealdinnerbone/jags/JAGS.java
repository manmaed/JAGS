package com.unrealdinnerbone.jags;

import com.unrealdinnerbone.jags.data.LootModifierGenerator;
import com.unrealdinnerbone.jags.data.SimpleItemModifier;
import com.unrealdinnerbone.jags.item.GrassSeed;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(JAGS.MOD_ID)
public class JAGS {
    public static final String MOD_ID = "jags";

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, JAGS.MOD_ID);
    public static final RegistryObject<SimpleItemModifier.Serializer> SIMPLE_LOOT_MODIFIER  = LOOT_MODIFIERS.register("simple", SimpleItemModifier.Serializer::new);
    public static final RegistryObject<GrassSeed> ITEM = ITEMS.register(MOD_ID, GrassSeed::new);

    public JAGS() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(JAGS::onData);
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        LOOT_MODIFIERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static void onData(GatherDataEvent event) {
        event.getGenerator().addProvider(new LootModifierGenerator(event.getGenerator()));
    }
}
