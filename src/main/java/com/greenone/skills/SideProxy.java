package com.greenone.skills;

import com.greenone.skills.common.EventHandler;
import com.greenone.skills.common.IProxy;
import com.greenone.skills.common.capabilities.CapabilityRegistry;
import com.greenone.skills.common.init.Registration;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;
import net.minecraftforge.fmlserverevents.FMLServerStoppingEvent;

import javax.annotation.Nullable;

public class SideProxy implements IProxy {
    private static MinecraftServer server;

    SideProxy(){
        MinecraftForge.EVENT_BUS.register(EventHandler.INSTANCE);
        Registration.register();
    }

    public static void commonSetup(final FMLCommonSetupEvent event){
        CapabilityRegistry.registerCapabilities();
    }

    private static void serverStarted(final FMLServerStartingEvent event){
        Skills.LOGGER.info("Server Started");
        server = event.getServer();
    }

    private static void serverStopping(final FMLServerStoppingEvent event){
        Skills.LOGGER.info("Server Stopping");
        server = null;
    }

    @Nullable
    @Override
    public Player getClientPlayer() {
        return null;
    }

    @Nullable
    @Override
    public MinecraftServer getServer() {
        return server;
    }

    public static class Client extends SideProxy{
        public Client(){
            FMLJavaModLoadingContext.get().getModEventBus().addListener(Client::clientSetup);
        }

        private static void clientSetup(FMLClientSetupEvent event){

        }

        @Nullable
        @Override
        public Player getClientPlayer() {
            return Minecraft.getInstance().player;
        }
    }

    public static class Common extends SideProxy {
        public Common(){
            FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
        }

        private void serverSetup(FMLDedicatedServerSetupEvent event) {}
    }
}
