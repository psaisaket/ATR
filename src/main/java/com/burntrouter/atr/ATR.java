package com.burntrouter.atr;

import com.burntrouter.atr.registry.ATRBlocks;
import com.burntrouter.atr.registry.ATRFluids;
import com.burntrouter.atr.registry.ATRItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ATR implements ModInitializer {
	public static final String modid = "atr";

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(modid, "main"),
			() -> new ItemStack(ATRItems.SCARLET));

	@Override
	public void onInitialize() {
		ATRItems.registerItems();
		ATRBlocks.init();
		ATRFluids.init();

	}

}
