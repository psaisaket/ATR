package com.burntrouter.atr.registry;

import com.burntrouter.atr.entity.FinnEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;

public class ATREntities {
    public static final EntityType<FinnEntity> FINN = null;
    public static void init() {
        FabricDefaultAttributeRegistry.register(FINN, FinnEntity.createMobAttributes());
    }
}
