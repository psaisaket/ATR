package com.burntrouter.atr.registry;

import com.burntrouter.atr.ATR;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;

import java.util.function.Function;

public class ATRBlocks {
    public static final String modid = ATR.modId;

    public static final Block BANANA_YELLOW = register("banana_yellow", new Block(FabricBlockSettings.copy(Blocks.YELLOW_GLAZED_TERRACOTTA)));
    public static final Block BERRY_BLUE = register("berry_blue", new Block(FabricBlockSettings.copy(Blocks.BLUE_GLAZED_TERRACOTTA)));
    public static final Block CANDY_DIRT = register("candy_dirt", new Block(FabricBlockSettings.copy(Blocks.DIRT)));
    public static final Block CANDY_GRASS = register("candy_grass", new Block(FabricBlockSettings.copy(Blocks.GRASS_BLOCK)));
    public static final Block CANDY_LEAVES = register("candy_leaves", new Block(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));
    public static final Block CANDY_LOG = register("candy_log", createLogBlock(MaterialColor.WOOD, MaterialColor.PURPLE));
    public static final Block CANDY_SAPLING = register("candy_sapling", new Block(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)));
    public static final Block CANDY_STONE = register("candy_stone", new Block(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block CHERRY_RED = register("cherry_red" , new Block(FabricBlockSettings.copy(Blocks.RED_GLAZED_TERRACOTTA)));
    public static final Block CHOCOLATE_BROWN = register("chocolate_brown", new Block(FabricBlockSettings.copy(Blocks.BROWN_GLAZED_TERRACOTTA)));
    public static final Block CREAM_WHITE = register("cream_white", new Block(FabricBlockSettings.copy(Blocks.WHITE_GLAZED_TERRACOTTA)));
    public static final Block CRYSTAL_BLOCK = register("crystal_block", new Block(FabricBlockSettings.copy(Blocks.LAPIS_BLOCK)));
    public static final Block CRYSTAL_ORE = register("crystal_ore", new Block(FabricBlockSettings.copy(Blocks.LAPIS_ORE)));
    public static final Block FROSTED_CANDY = register("frosted_candy", new Block(FabricBlockSettings.copy(Blocks.STONE)));
    public static final Block GRAPE_PURPLE = register("grape_purple", new Block(FabricBlockSettings.copy(Blocks.PURPLE_GLAZED_TERRACOTTA)));
    public static final Block JUICE = register("juice", new FluidBlock(ATRFluids.JUICE_STILL, AbstractBlock.Settings.of(Material.WATER).noCollision().strength(100.0F).dropsNothing()){});
    public static final Block WATERMELON_PINK = register("watermelon_pink", new Block(FabricBlockSettings.copy(Blocks.PINK_GLAZED_TERRACOTTA)));

    public static void init() {

    }

    private static PillarBlock createLogBlock(MaterialColor topMaterialColor, MaterialColor sideMaterialColor) {
        return new PillarBlock(AbstractBlock.Settings.of(Material.WOOD, (blockState) -> {
            return blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMaterialColor : sideMaterialColor;
        }).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    }

    static <T extends Block> T register(String name, T block, Item.Settings settings) {
        return register(name, block, new BlockItem(block, settings));
    }

    static <T extends Block> T register(String name, T block) {
        return register(name, block, new Item.Settings().group(ATR.atrGroup));
    }

    static <T extends Block> T register(String name, T block, Function<T, BlockItem> itemFactory) {
        return register(name, block, itemFactory.apply(block));
    }

    static <T extends Block> T register(String name, T block, BlockItem item) {
        T b = Registry.register(Registry.BLOCK, new Identifier(modid, name), block);
        if (item != null) {
            ATRItems.register(name, item);
        }
        return b;
    }
}
