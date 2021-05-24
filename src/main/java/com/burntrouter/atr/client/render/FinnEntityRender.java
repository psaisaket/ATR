package com.burntrouter.atr.client.render;

import com.burntrouter.atr.ATR;
import com.burntrouter.atr.client.model.FinnEntityModel;
import com.burntrouter.atr.entity.FinnEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class FinnEntityRender extends MobEntityRenderer<FinnEntity, FinnEntityModel> {
    public static final Identifier TEXTURE = new Identifier(ATR.modId, "textures/entity/finn.png");
    public FinnEntityRender(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new FinnEntityModel(), 0.3F);
    }

    @Override
    public FinnEntityModel getModel() {
        return super.getModel();
    }

    @Override
    public Identifier getTexture(FinnEntity entity) {
        return TEXTURE;
    }
}
