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
        glPushMatrix();
        // transformations: translations, rotations, homothéties

        // point important: dans un Gui, la coordonnée sur Z n'influence pas la taille
        // (mais permet d'afficher du contenu devant ou derrière quelque chose, selon la valeur choisie)
        glTranslatef(100f, 0f, 0f);
        glTranslatef(0f, 30f, 0f);
        glTranslatef(0f, 0f, -1f);
        Renderer.drawModel(resolution);
        glPopMatrix();
    }
}
