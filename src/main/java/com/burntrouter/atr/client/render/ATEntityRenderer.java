package com.burntrouter.atr.client.render;

import com.burntrouter.atr.registry.ATREntities;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;

@Environment(EnvType.CLIENT)
public class ATEntityRenderer {
    public static void init() {
        register(ATREntities.FINN, (entityRenderDispatcher, context) -> new FinnEntityRender(entityRenderDispatcher));
        register(ATREntities.JAKE, (entityRenderDispatcher, context) -> new JakeEntityRender(entityRenderDispatcher));
    }

    private static void register(EntityType<? extends Entity> clazz, EntityRendererRegistry.Factory factory) {
        EntityRendererRegistry.INSTANCE.register(clazz, factory);
    }
}
