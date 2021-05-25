package com.burntrouter.atr;

import com.burntrouter.atr.client.render.ATEntityRenderer;
import com.burntrouter.atr.registry.ATRFluids;
import com.burntrouter.atr.client.render.ATFluidRender;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.GeckoLib;

@Environment(EnvType.CLIENT)
public class ATRClient implements ClientModInitializer {

    public static void init() {
        new ATRClient().onInitializeClient();
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void onInitializeClient() {
        GeckoLib.initialize();
        ATFluidRender.setupFluidRendering(ATRFluids.JUICE_STILL, ATRFluids.JUICE_FLOWING,  new Identifier("atr", "juice"));
        ATFluidRender.markTranslucent(ATRFluids.JUICE_STILL, ATRFluids.JUICE_FLOWING);
        ATEntityRenderer.init();
    }
}
