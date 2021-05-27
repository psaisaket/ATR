package com.burntrouter.atr.registry;

import com.burntrouter.atr.ATR;
import com.burntrouter.atr.item.ScarletToolMaterial;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.lwjgl.system.CallbackI;

public class ATRItems {
    public static final String modid = ATR.modId;

    //Basic Items
    public static final Item ICE_SHARD = new Item(new Item.Settings().group(ATR.atrGroup));
    public static final Item JUICE_BUCKET = register("juice_bucket", new BucketItem(ATRFluids.JUICE_STILL, (new Item.Settings()).recipeRemainder(Items.BUCKET).maxCount(1).group(ATR.atrGroup)));
    public static final Item STEEL_INGOT = new Item(new Item.Settings().group(ATR.atrGroup));

    //Food Items
    public static final Item APPLE_PIE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(2.0F).build()).group(ATR.atrGroup));
    public static final Item BACON = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(2.0F).build()).group(ATR.atrGroup));
    public static final Item BUBBLE_GUM = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(2.0F).build()).group(ATR.atrGroup));

    //Weapon Items
    public static final ToolItem SCARLET = new SwordItem(ScarletToolMaterial.INSTANCE, 0, 1.2F, new Item.Settings().group(ATR.atrGroup));

    // Spawn Egg Items
    public static final SpawnEggItem FINN_SPAWN_EGG = new SpawnEggItem(ATREntities.FINN, 5457209, 8811878, new Item.Settings().group(ATR.atrGroup));
    public static final SpawnEggItem JAKE_SPAWN_EGG = new SpawnEggItem(ATREntities.JAKE, 5457209, 8811878, new Item.Settings().group(ATR.atrGroup));

    public static void registerItems(){
        //Register Basic Items
        Registry.register(Registry.ITEM, new Identifier(modid, "ice_shard"), ICE_SHARD);
        Registry.register(Registry.ITEM, new Identifier(modid, "steel_ingot"), STEEL_INGOT);

        //Register Food Items
        Registry.register(Registry.ITEM, new Identifier(modid, "apple_pie"), APPLE_PIE);
        Registry.register(Registry.ITEM, new Identifier(modid, "bacon"), BACON);
        Registry.register(Registry.ITEM, new Identifier(modid, "bubblegum"), BUBBLE_GUM);

        //Register Weapons
        Registry.register(Registry.ITEM, new Identifier(modid, "scarlet"), SCARLET);

        //Register Spawn Egg Items
        Registry.register(Registry.ITEM, new Identifier(modid, "jake_spawn_egg"), JAKE_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(modid, "finn_spawn_egg"), FINN_SPAWN_EGG);
    }

    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registry.ITEM, new Identifier(modid, name), item);
    }
}
