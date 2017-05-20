package fr.minecraftforgefrance.tutorial.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import static org.lwjgl.opengl.GL11.*;

public class ClientEventHandler {

    @SubscribeEvent
    public void onGuiDrawing(RenderGameOverlayEvent.Pre event) {
        if(event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
            draw(event.getResolution());
        }
    }

    /**
     * C'est la méthode que l'on va modifier dans ce tutoriel
     */
    private void draw(ScaledResolution resolution) {
        glEnable(GL_SCISSOR_TEST);
        glScissor(32,Minecraft.getMinecraft().displayHeight-128, 64,64); // attention! Pour l'axe Y, le 0 est en **bas** de l'écran!
        Renderer.drawOpaqueSprite(resolution);
        glDisable(GL_SCISSOR_TEST);
    }
}
