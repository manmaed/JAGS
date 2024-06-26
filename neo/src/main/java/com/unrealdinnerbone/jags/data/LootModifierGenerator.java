package com.unrealdinnerbone.jags.data;

import com.unrealdinnerbone.jags.JAGS;
import com.unrealdinnerbone.jags.JAGSRegistry;
import com.unrealdinnerbone.trenzalore.events.AddItemModifier;
import com.unrealdinnerbone.trenzalore.lib.RLUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class LootModifierGenerator extends GlobalLootModifierProvider {

    public LootModifierGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, registries, JAGS.MOD_ID);
    }

    @Override
    protected void start() {
        add("grass_seed", new AddItemModifier(
                createChanceCondition(0.1f, RLUtils.rl("minecraft", "blocks/grass")), new ItemStack(JAGSRegistry.GRASS_SEED.get())));
    }

    public static LootItemCondition[] createChanceCondition(float chance, ResourceLocation table) {
        return new LootItemCondition[] { LootItemRandomChanceCondition.randomChance(chance).build(), LootTableIdCondition.builder(table).build() };
    }
}
