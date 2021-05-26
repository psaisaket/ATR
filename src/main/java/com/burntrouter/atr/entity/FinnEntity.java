package com.burntrouter.atr.entity;

import com.burntrouter.atr.registry.ATREntities;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FinnEntity extends PathAwareEntity {

    public static final TrackedData<Byte> FINN = DataTracker.registerData(FinnEntity.class, TrackedDataHandlerRegistry.BYTE);
    public FinnEntity(World world) {
        super(ATREntities.FINN, world);
    }

    public static DefaultAttributeContainer.Builder initAttributes() {
        return ATREntities.getDefaultAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0D)
                .add(EntityAttributes.GENERIC_ARMOR, 5.0D)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0D);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 0.5D, true));
        this.goalSelector.add(2, new WanderAroundGoal(this, 0.3F, 15));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 12.0F));
        this.targetSelector.add(4, new FollowTargetGoal(this, MobEntity.class, 5, false, false, (livingEntity) -> {
            return livingEntity instanceof Monster;
        }));
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(FINN, (byte) 0);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean shouldRender(double par1) {
        return true;
    }

    @Override
    public void tick() {
        super.tick();

        if(random.nextFloat() <= 0.03F) {
            this.playSound(SoundEvents.ENTITY_VILLAGER_AMBIENT, 0.5F, 1.2F);
        }
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
    }

    @Override
    public void move(MovementType type, Vec3d movement) {
        super.move(type, isOnGround() ? movement : movement.multiply(1.0, 1.0F, 1.0));
    }
}
