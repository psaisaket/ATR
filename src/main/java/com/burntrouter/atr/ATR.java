package com.burntrouter.atr;

import com.burntrouter.atr.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;

import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ATR implements ModInitializer {
	public static final String modId = "atr";
	public static final String modName = "Adventure Time Reborn";

	public static final Logger LOGGER = LogManager.getLogger(modName);

	public static final ItemGroup atrGroup = FabricItemGroupBuilder.build(
			new Identifier(modId, "main"),
			() -> new ItemStack(ATRItems.SCARLET));




	@Override
	public void onInitialize() {
		log(Level.INFO, "Adventure Time Reborn starting up!");
		ATRItems.registerItems();
		ATRBlocks.init();
		ATRFluids.init();
		ATREntities.init();
		ATRClient.init();
	}

	public static void log(Level level, String message) {
		//LOGGER.log(level, message);
	}

}
