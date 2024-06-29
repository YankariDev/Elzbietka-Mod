package net.elzbietkadev.elzbietkamod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elzbietkadev.elzbietkamod.entity.animations.ElzbietkaEntityAnimations;
import net.elzbietkadev.elzbietkamod.entity.animations.SutEntityAnimations;
import net.elzbietkadev.elzbietkamod.entity.custom.ElzbietkaEntity;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.CowRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Cow;

public class ElzbietkaModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("mod_id", "elzbietka_entity"), "main");
	private final ModelPart elzbietka;
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;

	public ElzbietkaModel(ModelPart root) {
		this.elzbietka = root.getChild("elzbietka");
		this.head = elzbietka.getChild("head");
		this.body = elzbietka.getChild("body");
		this.leg1 = elzbietka.getChild("leg1");
		this.leg2 = elzbietka.getChild("leg2");
		this.leg3 = elzbietka.getChild("leg3");
		this.leg4 = elzbietka.getChild("leg4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition elzbietka = partdefinition.addOrReplaceChild("elzbietka", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = elzbietka.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(22, 0).addBox(4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(22, 0).addBox(-5.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -20.0F, -8.0F));

		PartDefinition body = elzbietka.addOrReplaceChild("body", CubeListBuilder.create().texOffs(18, 4).addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(52, 0).addBox(-2.0F, 2.0F, -8.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -19.0F, 2.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition leg1 = elzbietka.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 30).addBox(-2.0F, 10.0F, -3.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(14, 32).addBox(-0.5F, 10.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -12.0F, 7.0F));

		PartDefinition leg2 = elzbietka.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 30).addBox(-2.0F, 10.0F, -3.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(14, 32).addBox(-0.5F, 10.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -12.0F, 7.0F));

		PartDefinition leg3 = elzbietka.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 30).addBox(-2.0F, 10.0F, -3.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(14, 32).addBox(-0.5F, 10.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -12.0F, -5.0F));

		PartDefinition leg4 = elzbietka.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 30).addBox(-2.0F, 10.0F, -3.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(14, 32).addBox(-0.5F, 10.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -12.0F, -5.0F));

		return LayerDefinition.create(meshdefinition, 64, 42);
	}

	@Override
	public ModelPart root() {
		return elzbietka;
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ElzbietkaEntityAnimations.walk, limbSwing, limbSwingAmount, 1, 1);
		this.animate(((ElzbietkaEntity) entity).idleAnimationState, ElzbietkaEntityAnimations.idle, ageInTicks, 1);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		elzbietka.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}