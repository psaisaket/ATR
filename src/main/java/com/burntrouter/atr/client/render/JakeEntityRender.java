package com.burntrouter.atr.client.render;

import com.burntrouter.atr.ATR;
import com.burntrouter.atr.entity.JakeEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import com.burntrouter.atr.client.model.JakeEntityModel;
import net.minecraft.util.Identifier;

public class JakeEntityRender extends MobEntityRenderer<JakeEntity, JakeEntityModel> {
    public static final Identifier TEXTURE = new Identifier(ATR.modId, "textures/entity/jake.png");
    public JakeEntityRender(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new JakeEntityModel(), 1F);
    }

    @Override
    public JakeEntityModel getModel() {
        return super.getModel();
    }

    @Override
    public Identifier getTexture(JakeEntity entity) {
        return TEXTURE;
    }
}
