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
        glPushMatrix();
        glTranslatef(100f, 100f, 0f);
        glRotatef(Minecraft.getSystemTime()*.125f, 0f, 0f, 1f);
        glTranslatef(-64f/resolution.getScaleFactor(), -64f/resolution.getScaleFactor(), 0f);
        Renderer.drawTransparentSprite(resolution);
        glPopMatrix();

        glPushMatrix();
        glRotatef(-45f, 1f, 0f, 0f);
        glRotatef(-45f, 0f, 1f, 0f);
        Renderer.drawModel(resolution);
        glPopMatrix();

        glPushMatrix();
        glTranslatef(100f, 0f, 0f); // juste pour écarter du logo
        // inversion !
        glRotatef(-45f, 0f, 1f, 0f);
        glRotatef(-45f, 1f, 0f, 0f);
        Renderer.drawModel(resolution);
        glPopMatrix();
    }
}
