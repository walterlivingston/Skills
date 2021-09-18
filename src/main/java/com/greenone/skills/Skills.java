package com.greenone.skills;

import com.greenone.skills.common.IProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Skills.MODID)
public class Skills
{
    public static final String MODID = "skills";
    public static final Logger LOGGER = LogManager.getLogger();
    public static IProxy PROXY;

    public Skills() {
        PROXY = DistExecutor.safeRunForDist(() -> SideProxy.Client::new, () -> SideProxy.Client::new);
    }
}
