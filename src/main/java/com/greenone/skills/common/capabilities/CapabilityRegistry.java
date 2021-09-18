package com.greenone.skills.common.capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilityRegistry {
    @CapabilityInject(ISkillsCap.class)
    public static Capability<ISkillsCap> SKILLSCAP = null;

    @SuppressWarnings("deprecation")
    public static void registerCapabilities() {
        CapabilityManager.INSTANCE.register(ISkillsCap.class);
    }
}
