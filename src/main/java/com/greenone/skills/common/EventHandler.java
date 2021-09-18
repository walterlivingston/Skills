package com.greenone.skills.common;

import com.greenone.skills.Skills;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Skills.MODID)
public class EventHandler {
    public static final EventHandler INSTANCE = new EventHandler();
}
