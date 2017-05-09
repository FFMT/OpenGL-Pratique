package fr.minecraftforgefrance.tutorial;

import fr.minecraftforgefrance.tutorial.client.ClientEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = OpenGLPratique.MODID, version = OpenGLPratique.VERSION)
public class OpenGLPratique
{
    public static final String MODID = "openglpratique";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
    }
}
