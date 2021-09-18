package com.greenone.skills.common;

import com.greenone.skills.Skills;
import com.greenone.skills.common.capabilities.SkillsCap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Skills.MODID)
public class EventHandler {
    public static final EventHandler INSTANCE = new EventHandler();

    @SubscribeEvent
    public void attachCapabilities(final AttachCapabilitiesEvent event) {
        if (!((event.getObject()) instanceof Player)) return;
        event.addCapability(new ResourceLocation(Skills.MODID, "player_cap"), new SkillsCap());
    }

}
