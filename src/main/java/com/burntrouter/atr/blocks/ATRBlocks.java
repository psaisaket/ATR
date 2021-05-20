package com.burntrouter.atr.blocks;

import com.burntrouter.atr.ATR;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ATRBlocks {
    public static final String modid = ATR.modid;

    public static final Block testBlock = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0F));

    public static void registerBlocks(){
        //Register Basic Blocks
        Registry.register(Registry.BLOCK, new Identifier(modid, "testBlock"), testBlock);

        //Register BlockItems
        Registry.register(Registry.ITEM, new Identifier(modid, "testBlock"), new BlockItem(testBlock, new FabricItemSettings().group(ATR.ITEM_GROUP)));
    }
}
