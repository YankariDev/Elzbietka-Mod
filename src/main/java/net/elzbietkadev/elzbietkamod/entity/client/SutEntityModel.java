package net.elzbietkadev.elzbietkamod.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elzbietkadev.elzbietkamod.entity.animations.SutEntityAnimations;
import net.elzbietkadev.elzbietkamod.entity.custom.SutEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class SutEntityModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("mod_id", "sut_entity"), "main");
	private final ModelPart sut;
	private final ModelPart body;
	private final ModelPart torso;
	private final ModelPart left_leg;
	private final ModelPart right_leg;

	public SutEntityModel(ModelPart root) {
		this.sut = root.getChild("sut");
		this.body = sut.getChild("body");
		this.torso = body.getChild("torso");
		this.left_leg = body.getChild("left_leg");
		this.right_leg = body.getChild("right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition sut = partdefinition.addOrReplaceChild("sut", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = sut.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body_r1 = torso.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(12, 39).addBox(-4.0F, -3.0F, -2.0F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(12, 33).addBox(-5.0F, -4.0F, -2.0F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(1, 33).addBox(-6.0F, -12.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(34, 17).addBox(-5.0F, -14.0F, -2.0F, 1.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(28, 9).addBox(-2.0F, -17.0F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(28, 0).addBox(7.0F, -13.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(23, 17).addBox(6.0F, -15.0F, -2.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(12, 17).addBox(5.0F, -15.0F, -2.0F, 1.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(1, 0).addBox(-4.0F, -16.0F, -2.0F, 9.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(43, 2).addBox(-1.0F, -14.0F, 2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(43, 5).addBox(-2.0F, -13.0F, 2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(43, 8).addBox(-3.0F, -12.0F, 2.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 2).addBox(-1.0F, -7.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(43, 11).addBox(-2.0F, -8.0F, 2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(43, 14).addBox(-3.0F, -9.0F, 2.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(43, 17).addBox(-4.0F, -11.0F, 2.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition left_leg = body.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(2, 25).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -5.0F, 0.0F, 0.0F, -0.0436F, 0.0F));

		PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(2, 18).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -3.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		sut.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return sut;
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateWalk(SutEntityAnimations.walk, limbSwing, limbSwingAmount, 1, 1);
		this.animate(((SutEntity) entity).idleAnimationState, SutEntityAnimations.idle, ageInTicks, 1);
	}
}