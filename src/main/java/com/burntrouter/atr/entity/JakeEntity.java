package com.burntrouter.atr.entity;

import com.burntrouter.atr.registry.ATREntities;
import com.burntrouter.atr.registry.ATRItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class JakeEntity extends PathAwareEntity {

    public static final TrackedData<Byte> JAKE = DataTracker.registerData(JakeEntity.class, TrackedDataHandlerRegistry.BYTE);
    public JakeEntity(World world) {
        super(ATREntities.JAKE, world);
    }

    public static DefaultAttributeContainer.Builder initAttributes() {
        return ATREntities.getDefaultAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0D);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new WanderAroundGoal(this, 1.0, 15));
        this.goalSelector.add(2, new TemptGoal(this, 1.0, Ingredient.ofItems(ATRItems.APPLE_PIE), false));
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(JAKE, (byte) 0);
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
            this.playSound(SoundEvents.ENTITY_VILLAGER_AMBIENT, 1.0F, 0.5F);
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
