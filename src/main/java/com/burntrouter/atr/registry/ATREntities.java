package com.burntrouter.atr.registry;

import com.burntrouter.atr.ATR;
import com.burntrouter.atr.entity.FinnEntity;
import com.burntrouter.atr.entity.JakeEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ATREntities {
    public static final EntityType<FinnEntity> FINN;
    public static final EntityType<JakeEntity> JAKE;

    static {
        FINN = register("finn", SpawnGroup.AMBIENT, EntityDimensions.changing(1.0F, 1.0F), (entityType, world) -> new FinnEntity(world));
        JAKE = register("jake", SpawnGroup.AMBIENT, EntityDimensions.changing(1.0F, 1.0F), (entityType, world) -> new JakeEntity(world));
    }

    public static void init() {
        FabricDefaultAttributeRegistry.register(FINN, FinnEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(JAKE, JakeEntity.createMobAttributes());
    }

    public static DefaultAttributeContainer.Builder getDefaultAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 6);
    }

    public static <X extends Entity> EntityType<X> register(String name, int trackingDistance, int updateIntervalTicks, boolean alwaysUpdateVelocity, EntityDimensions size, EntityType.EntityFactory<X> factory) {
        return Registry.register(Registry.ENTITY_TYPE, new Identifier(ATR.modId, name), FabricEntityTypeBuilder.create(SpawnGroup.MISC, factory).trackRangeBlocks(trackingDistance).trackedUpdateRate(updateIntervalTicks).forceTrackedVelocityUpdates(alwaysUpdateVelocity).dimensions(size).disableSaving().build());
    }

    public static <X extends Entity> EntityType<X> register(String name, SpawnGroup category, EntityDimensions size, EntityType.EntityFactory<X> factory) {
        return Registry.register(Registry.ENTITY_TYPE, new Identifier(ATR.modId, name), FabricEntityTypeBuilder.create(category, factory).dimensions(size).build());
    }
}
