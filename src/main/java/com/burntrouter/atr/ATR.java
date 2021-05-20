package com.burntrouter.atr;

import com.burntrouter.atr.blocks.ATRBlocks;
import com.burntrouter.atr.items.ATRItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ATR implements ModInitializer {
	public static final String modid = "atr";

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(modid, "main"),
			() -> new ItemStack(ATRItems.testItem));

	@Override
	public void onInitialize() {
		ATRItems.registerItems();
		ATRBlocks.registerBlocks();
	}

}
