package com.burntrouter.atr.fluid;

import com.burntrouter.atr.registry.ATRBlocks;
import com.burntrouter.atr.registry.ATRFluids;
import com.burntrouter.atr.registry.ATRItems;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.world.WorldView;

public class JuiceFluid extends BaseFluid {
    @Override
    public Fluid getFlowing() {
        return ATRFluids.JUICE_FLOWING;
    }

    @Override
    public Fluid getStill() {
        return ATRFluids.JUICE_STILL;
    }

    @Override
    public Item getBucketItem() {
        return ATRItems.JUICE_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return ATRBlocks.JUICE.getDefaultState().with(Properties.LEVEL_15, method_15741(state));
    }

    @Override
    public boolean isStill(FluidState state) {
        return false;
    }

    @Override
    public int getLevel(FluidState state) {
        return state.get(LEVEL);
    }

    public static class Flowing extends JuiceFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends JuiceFluid {
        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}
