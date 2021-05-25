package com.burntrouter.atr.client.model;

import com.burntrouter.atr.entity.JakeEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class JakeEntityModel extends EntityModel<JakeEntity> {
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart leftleg;
	private final ModelPart rightleg;
	private final ModelPart leftarm;
	private final ModelPart rightarm;

	public JakeEntityModel() {
		textureWidth = 64;
		textureHeight = 64;
		head = new ModelPart(this);
		head.setPivot(4.0F, 9.0F, -4.0F);
		head.setTextureOffset(0, 0).addCuboid(-8.0F, -10.0F, 0.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(20, 30).addCuboid(-5.0F, -6.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(16, 32).addCuboid(-6.0F, -5.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(26, 32).addCuboid(-3.0F, -5.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(33, 29).addCuboid(-9.0F, -8.0F, 3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(33, 38).addCuboid(0.0F, -8.0F, 3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		body = new ModelPart(this);
		body.setPivot(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(32, 0).addCuboid(-4.0F, -17.0F, -4.0F, 8.0F, 10.0F, 8.0F, 0.0F, false);

		leftleg = new ModelPart(this);
		leftleg.setPivot(0.0F, 24.0F, 0.0F);
		leftleg.setTextureOffset(0, 23).addCuboid(-4.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		rightleg = new ModelPart(this);
		rightleg.setPivot(0.0F, 24.0F, 0.0F);
		rightleg.setTextureOffset(0, 23).addCuboid(2.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		leftarm = new ModelPart(this);
		leftarm.setPivot(-2.0F, 13.0F, 0.0F);
		leftarm.setTextureOffset(40, 23).addCuboid(-4.0F, -6.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		rightarm = new ModelPart(this);
		rightarm.setPivot(-2.0F, 13.0F, 0.0F);
		rightarm.setTextureOffset(40, 33).addCuboid(6.0F, -6.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setAngles(JakeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
		rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
	}
}