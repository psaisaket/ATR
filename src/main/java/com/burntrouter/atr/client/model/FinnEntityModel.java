package com.burntrouter.atr.client.model;

import com.burntrouter.atr.entity.FinnEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class FinnEntityModel extends EntityModel<FinnEntity> {
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart rightleg;
	private final ModelPart leftleg;
	private final ModelPart rightarm;
	private final ModelPart leftarm;
	private final ModelPart backpack;

	public FinnEntityModel() {
		textureWidth = 128;
		textureHeight = 128;
		head = new ModelPart(this);
		head.setPivot(0.0F, 24.0F, 0.0F);
		head.setTextureOffset(0, 0).addCuboid(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		body = new ModelPart(this);
		body.setPivot(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(16, 16).addCuboid(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		rightleg = new ModelPart(this);
		rightleg.setPivot(-3.0F, 12.0F, 0.0F);
		rightleg.setTextureOffset(0, 16).addCuboid(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		leftleg = new ModelPart(this);
		leftleg.setPivot(3.0F, 12.0F, 0.0F);
		leftleg.setTextureOffset(0, 16).addCuboid(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		rightarm = new ModelPart(this);
		rightarm.setPivot(-5.0F, 1.0F, 0.0F);
		rightarm.setTextureOffset(40, 16).addCuboid(-1.0F, -1.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		leftarm = new ModelPart(this);
		leftarm.setPivot(5.0F, 1.0F, 0.0F);
		leftarm.setTextureOffset(40, 16).addCuboid(-1.0F, -1.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		backpack = new ModelPart(this);
		backpack.setPivot(0.0F, 24.0F, 0.0F);
		backpack.setTextureOffset(48, 0).addCuboid(-4.0F, -23.0F, 2.0F, 8.0F, 8.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setAngles(FinnEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		rightleg.pitch = MathHelper.cos(limbSwing * 0.6662F) * 1.0F * limbSwingAmount;
		leftleg.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.0F * limbSwingAmount;
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
		leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
		backpack.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
	}
}