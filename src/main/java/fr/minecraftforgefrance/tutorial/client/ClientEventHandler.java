package fr.minecraftforgefrance.tutorial.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.shader.Framebuffer;
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
        // Etape importante, permet de vérifier si le stencil buffer est activé et l'activer si ce n'est le cas
        Framebuffer framebuffer = Minecraft.getMinecraft().getFramebuffer();
        if( ! framebuffer.isStencilEnabled()) {
            framebuffer.enableStencil();
        }

        glEnable(GL_STENCIL_TEST);

        glStencilFunc(GL_ALWAYS, 1, 0xFF); // Tous les pixels affichés vont avoir la valeur 1 dans le stencil buffer
        glStencilOp(GL_KEEP, GL_KEEP, GL_REPLACE);
        glStencilMask(0xFF); // On va écrire dans le stencil buffer
        glDepthMask(false); // On n'écrit plus dans le depth buffer
        glColorMask(false, false, false, false); // on désactive le rendu des couleurs
        glClear(GL_STENCIL_BUFFER_BIT); // On vide le buffer

        // rendu du modèle
        glPushMatrix();
        glTranslatef(-80f, -40f, 0f); // on déplace le modèle en haut à gauche
        Renderer.drawModel(resolution); // On dessine le modèle du joueur
        glPopMatrix();

        // rendu du logo
        // On ne dessine les pixels que si le pixel que l'on va dessiner est à une position où le stencil buffer a une valeur égale (GL_EQUAL) à 1
        glStencilFunc(GL_EQUAL, 1, 0xFF);

        glStencilMask(0x00); // On n'écrit plus rien au stencil buffer
        glDepthMask(true); // On réactive l'écriture vers le depth buffer
        glColorMask(true, true, true, true); // On réactive le rendu des couleurs

        glPushMatrix();
        glScalef(1.5f, 1.5f, 1f); // on agrandit un peu le logo pour que le modèle rentre entièremen dedans
        Renderer.drawOpaqueSprite(resolution); // On dessine notre logo
        glPopMatrix();

        glDisable(GL_STENCIL_TEST);
    }
}
