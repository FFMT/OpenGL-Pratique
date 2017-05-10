package fr.minecraftforgefrance.tutorial.client;

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
        glColor3f(0f, 0f, 1f);
        Renderer.drawTransparentSprite(resolution); // rendu du logo du site avec uniquement le bleu

        glPushMatrix();
        glTranslatef(100f, 0f, 0f); // juste pour tout voir sur l'écran en même temps

        glColor4f(0.5f, 0.5f, 0f, 0.25f);
        Renderer.drawTransparentSprite(resolution); // rendu du logo du site à 25% d'opacité, pas de bleu, et division par 2 du rouge et du bleu

        glTranslatef(100f, 0f, 0f); // juste pour tout voir sur l'écran en même temps

        glColor3f(0f, 0f, 0f);
        glColor4f(1f, 1f, 1f, 1f);
        Renderer.drawTransparentSprite(resolution); // rendu du logo du site à 25% d'opacité, pas de bleu, et division par 2 du rouge et du bleu
        glPopMatrix();
    }
}
