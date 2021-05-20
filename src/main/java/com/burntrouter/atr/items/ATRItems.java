package com.burntrouter.atr.items;

import com.burntrouter.atr.ATR;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ATRItems {
    public static final String modid = ATR.modid;

    //Basic Items
    public static final Item testItem = new Item(new FabricItemSettings().group(ATR.ITEM_GROUP));

    //Weapon Items
    public static final Item SCARLET = new Item((new SwordItem(ToolMaterials.NETHERITE, 9, 1.0F, new Item.Settings().group(ATR.ITEM_GROUP))));

    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier(modid, "testItem"), testItem);
    }
}
