package com.burntrouter.atr.registry;

import com.burntrouter.atr.ATR;
import com.burntrouter.atr.items.ScarletToolMaterial;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ATRItems {
    public static final String modid = ATR.modid;

    //Basic Items
    public static final Item ICE_SHARD = new Item(new Item.Settings().group(ATR.ITEM_GROUP));
    public static final Item JUICE_BUCKET = register("juice_bucket", new BucketItem(ATRFluids.JUICE_STILL, (new Item.Settings()).recipeRemainder(Items.BUCKET).maxCount(1).group(ATR.ITEM_GROUP)));

    //Food Items
    public static final Item APPLE_PIE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(2.0F).build()).group(ATR.ITEM_GROUP));

    //Weapon Items
    public static final ToolItem SCARLET = new SwordItem(ScarletToolMaterial.INSTANCE, 0, 1.2F, new Item.Settings().group(ATR.ITEM_GROUP));

    public static void registerItems(){
        //Register Basic Items
        Registry.register(Registry.ITEM, new Identifier(modid, "ice_shard"), ICE_SHARD);

        //Register Food Items
        Registry.register(Registry.ITEM, new Identifier(modid, "apple_pie"), APPLE_PIE);

        //Register Weapons
        Registry.register(Registry.ITEM, new Identifier(modid, "scarlet"), SCARLET);
    }

    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registry.ITEM, new Identifier(modid, name), item);
    }
}
