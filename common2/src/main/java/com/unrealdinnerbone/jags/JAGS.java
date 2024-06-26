package com.unrealdinnerbone.jags;

import com.unrealdinnerbone.trenzalore.lib.RLUtils;
import net.minecraft.resources.ResourceLocation;

public class JAGS {

    public static final String MOD_ID = "jags";

    public static void init() {

    }

    public static ResourceLocation rl(String path) {
        return RLUtils.rl(MOD_ID, path);
    }
}