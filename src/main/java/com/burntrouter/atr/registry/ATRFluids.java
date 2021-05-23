package com.burntrouter.atr.registry;

import com.burntrouter.atr.ATR;
import com.burntrouter.atr.fluid.JuiceFluid;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ATRFluids {
    public static final String modid = ATR.modId;

    public static final FlowableFluid JUICE_STILL = register("juice_still", new JuiceFluid.Still());
    public static final FlowableFluid JUICE_FLOWING = register("juice_flowing", new JuiceFluid.Flowing());

    public static void init(){

    }

    static <T extends Fluid> T register(String name, T fluid) {
        T b = Registry.register(Registry.FLUID, new Identifier(modid, name), fluid);
        return b;
    }
}
