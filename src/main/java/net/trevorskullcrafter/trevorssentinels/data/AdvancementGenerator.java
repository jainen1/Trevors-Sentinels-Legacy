package net.trevorskullcrafter.trevorssentinels.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.item.BetaItems;
import net.trevorskullcrafter.trevorssentinels.item.ModArmory;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;

import java.util.function.Consumer;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class AdvancementGenerator extends FabricAdvancementProvider {
    public AdvancementGenerator(FabricDataOutput output) { super(output); }

    @Override public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement trevorssentinels = Advancement.Builder.create()
            .display(ModItems.GALINITE_SHARD, Text.translatable("advancements.trevorssentinels.trevorssentinels.title"),
            Text.translatable("advancements.trevorssentinels.trevorssentinels.desc"), new Identifier("trevorssentinels:textures/block/steel_block.png"),
            AdvancementFrame.TASK, true, true, false)
                .criterion("got_sentinum_shard", InventoryChangedCriterion.Conditions.items(ModItems.GALINITE_SHARD))
                .rewards(AdvancementRewards.Builder.loot(new Identifier(MOD_ID, "grant_database")))
                .build(consumer, MOD_ID + ":trevorssentinels");

        Advancement spf = Advancement.Builder.create().parent(trevorssentinels)
                .display(ModItems.BANANA_BOAT, Text.translatable("advancements.trevorssentinels.spf.title"),
                        Text.translatable("advancements.trevorssentinels.spf.desc"), null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("got_banana_boat", InventoryChangedCriterion.Conditions.items(ModItems.BANANA_BOAT, ModItems.BANANA_CHEST_BOAT))
                .build(consumer, MOD_ID + ":spf");

        Advancement bacon_and_eggs = Advancement.Builder.create().parent(trevorssentinels)
                .display(ModItems.FRIED_EGG, Text.translatable("advancements.trevorssentinels.bacon_and_eggs.title"),
                        Text.translatable("advancements.trevorssentinels.bacon_and_eggs.desc"), null,
                        AdvancementFrame.GOAL, true, true, false)
                .criterion("eaten_egg", ConsumeItemCriterion.Conditions.item(ModItems.FRIED_EGG))
                .criterion("eaten_bacon", ConsumeItemCriterion.Conditions.item(ModItems.DUBIOUS_BACON))
                .build(consumer, MOD_ID + ":bacon_and_eggs");

        Advancement brownie = Advancement.Builder.create().parent(trevorssentinels)
                .display(ModItems.BROWNIE, Text.translatable("advancements.trevorssentinels.brownie.title"),
                        Text.translatable("advancements.trevorssentinels.brownie.desc"), null,
                        AdvancementFrame.GOAL, true, true, false)
                .criterion("consumed_brownie", ConsumeItemCriterion.Conditions.item(ModItems.BROWNIE))
                .rewards(AdvancementRewards.Builder.experience(420))
                .build(consumer, MOD_ID + ":brownie");

        Advancement chainsaw_man = Advancement.Builder.create().parent(trevorssentinels)
                .display(ModArmory.GALINITE_CHAINSAW, Text.translatable("advancements.trevorssentinels.chainsaw_man.title"),
                        Text.translatable("advancements.trevorssentinels.chainsaw_man.desc"), null,
                        AdvancementFrame.GOAL, true, true, false)
                .criterion("got_chainsaw", InventoryChangedCriterion.Conditions.items(ModArmory.GALINITE_CHAINSAW))
                .build(consumer, MOD_ID + ":chainsaw_man");

        Advancement forge = Advancement.Builder.create().parent(trevorssentinels)
                .display(ModBlocks.FORGE, Text.translatable("advancements.trevorssentinels.forge.title"),
                        Text.translatable("advancements.trevorssentinels.forge.desc"), null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("got_forge", InventoryChangedCriterion.Conditions.items(ModBlocks.FORGE))
                .build(consumer, MOD_ID + ":forge");

        Advancement ferraurium = Advancement.Builder.create().parent(forge)
                .display(ModItems.IRON_GOLD_INGOT, Text.translatable("advancements.trevorssentinels.ferraurium.title"),
                        Text.translatable("advancements.trevorssentinels.ferraurium.desc"), null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("got_ferraurium", InventoryChangedCriterion.Conditions.items(ModItems.IRON_GOLD_INGOT, ModBlocks.IRON_GOLD_BLOCK))
                .build(consumer, MOD_ID + ":ferraurium");

        Advancement trimetal = Advancement.Builder.create().parent(forge)
                .display(ModItems.COPPER_IRON_INGOT, Text.translatable("advancements.trevorssentinels.trimetal.title"),
                        Text.translatable("advancements.trevorssentinels.trimetal.desc"), null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("got_something", InventoryChangedCriterion.Conditions.items(ModArmory.TRIMETAL_SWORD, ModArmory.TRIMETAL_PICKAXE,
                        ModArmory.TRIMETAL_AXE, ModArmory.TRIMETAL_SHOVEL, ModArmory.TRIMETAL_HOE, ModArmory.TRIMETAL_HELMET, ModArmory.TRIMETAL_CHESTPLATE,
                        ModArmory.TRIMETAL_LEGGINGS, ModArmory.TRIMETAL_BOOTS))
                .build(consumer, MOD_ID + ":trimetal");

        Advancement rose_gold = Advancement.Builder.create().parent(forge)
                .display(ModItems.ROSE_GOLD_INGOT, Text.translatable("advancements.trevorssentinels.rose_gold.title"),
                        Text.translatable("advancements.trevorssentinels.rose_gold.desc"), null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("got_ingot", InventoryChangedCriterion.Conditions.items(ModItems.ROSE_GOLD_INGOT))
                .build(consumer, MOD_ID + ":rose_gold");

        Advancement rose_gold_2 = Advancement.Builder.create().parent(rose_gold)
                .display(ModItems.ROSE_GOLD_INGOT, Text.translatable("advancements.trevorssentinels.rose_gold_2.title"),
                        Text.translatable("advancements.trevorssentinels.rose_gold_2.desc"), null,
                        AdvancementFrame.GOAL, true, true, false)
                .criterion("got_something", InventoryChangedCriterion.Conditions.items(ModArmory.ROSE_GOLD_DAGGER, ModArmory.ROSE_GOLD_PICKAXE,
                        ModArmory.ROSE_GOLD_AXE, ModArmory.ROSE_GOLD_SHOVEL, ModArmory.ROSE_GOLD_HOE, ModArmory.ROSE_GOLD_HELMET, ModArmory.ROSE_GOLD_CHESTPLATE,
                        ModArmory.ROSE_GOLD_LEGGINGS, ModArmory.ROSE_GOLD_BOOTS))
                .build(consumer, MOD_ID + ":rose_gold_2");

        Advancement thanatu = Advancement.Builder.create().parent(rose_gold_2)
                .display(ModArmory.THANATU_SKULL, Text.translatable("advancements.trevorssentinels.thanatu.title"),
                        Text.translatable("advancements.trevorssentinels.thanatu.desc"), null,
                        AdvancementFrame.CHALLENGE, true, true, false)
                .criterion("got_sword", InventoryChangedCriterion.Conditions.items(BetaItems.THANATU_BLADE))
                .criterion("got_skull", InventoryChangedCriterion.Conditions.items(ModArmory.THANATU_SKULL))
                .criterion("got_armory", InventoryChangedCriterion.Conditions.items(ModArmory.THANATU_SHOULDERPADS))
                .build(consumer, MOD_ID + ":thanatu");

        Advancement netherite = Advancement.Builder.create().parent(ferraurium)
                .display(Items.NETHERITE_INGOT, Text.translatable("advancements.trevorssentinels.netherite.title"),
                        Text.translatable("advancements.trevorssentinels.netherite.desc"), null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("got_chainsaw", InventoryChangedCriterion.Conditions.items(Items.NETHERITE_INGOT, Blocks.NETHERITE_BLOCK))
                .build(consumer, MOD_ID + ":netherite");

        Advancement uranium = Advancement.Builder.create().parent(netherite)
                .display(ModItems.TORBERNITE_CUBE, Text.translatable("advancements.trevorssentinels.uranium.title"),
                        Text.translatable("advancements.trevorssentinels.uranium.desc"), null,
                        AdvancementFrame.GOAL, true, true, false)
                .criterion("got_cube", InventoryChangedCriterion.Conditions.items(ModItems.TORBERNITE_CUBE))
                .build(consumer, MOD_ID + ":uranium");

        Advancement superforge = Advancement.Builder.create().parent(uranium)
                .display(ModBlocks.SUPERFORGE, Text.translatable("advancements.trevorssentinels.superforge.title"),
                        Text.translatable("advancements.trevorssentinels.superforge.desc"), null,
                        AdvancementFrame.GOAL, true, true, false)
                .criterion("got_superforge", InventoryChangedCriterion.Conditions.items(ModBlocks.SUPERFORGE))
                .build(consumer, MOD_ID + ":superforge");

        Advancement zenithium = Advancement.Builder.create().parent(superforge)
                .display(ModItems.ZENITHIUM_CLUSTER, Text.translatable("advancements.trevorssentinels.zenithium.title"),
                        Text.translatable("advancements.trevorssentinels.zenithium.desc"), null,
                        AdvancementFrame.CHALLENGE, true, true, false)
                .criterion("got_cluster", InventoryChangedCriterion.Conditions.items(ModItems.ZENITHIUM_CLUSTER))
                .build(consumer, MOD_ID + ":zenithium");
    }
}