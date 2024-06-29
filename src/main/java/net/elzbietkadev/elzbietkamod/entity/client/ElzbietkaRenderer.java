package net.elzbietkadev.elzbietkamod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.entity.custom.ElzbietkaEntity;
import net.elzbietkadev.elzbietkamod.entity.custom.SutEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ElzbietkaRenderer extends MobRenderer<ElzbietkaEntity, ElzbietkaModel<ElzbietkaEntity>> {
    public ElzbietkaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ElzbietkaModel<>(pContext.bakeLayer(ModModelLayers.ELZBIETKA_ENTITY_LAYER)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(ElzbietkaEntity pEntity) {
        return new ResourceLocation(ElzbietkaMod.MOD_ID, "textures/entity/elzbietka.png");
    }

    @Override
    public void render(ElzbietkaEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}