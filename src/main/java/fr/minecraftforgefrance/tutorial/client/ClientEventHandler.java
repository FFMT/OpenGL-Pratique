package fr.minecraftforgefrance.tutorial.client;

import fr.minecraftforgefrance.tutorial.OpenGLPratique;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
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

    private static final ResourceLocation opaqueLogo = new ResourceLocation(OpenGLPratique.MODID, "logo_mff128x128.png");
    private static final int WIDTH = 128;
    private static final int HEIGHT = 128;

    /**
     * C'est la méthode que l'on va modifier dans ce tutoriel
     */
    private void draw(ScaledResolution resolution) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(opaqueLogo);

        // on récupère le buffer
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer buffer = tessellator.getBuffer();

        // on commence à dessiner des quadrilatères où on donne la position et les coordonnées de textures
        buffer.begin(GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        float w = WIDTH / ((float)resolution.getScaleFactor());
        float h = HEIGHT / ((float)resolution.getScaleFactor());

        // on ajoute un sommet à (0,0) avec la coordonnée (0,0) sur la texture
        buffer.pos(0,0,0).tex(0, 0).endVertex();
        buffer.pos(0,h,0).tex(0, 1f).endVertex();
        buffer.pos(w, h,0).tex(1f, 1f).endVertex();
        buffer.pos(w,0,0).tex(1f, 0).endVertex();

        // on dessine le contenu
        tessellator.draw();


        glPushMatrix();
        glTranslatef(100f, 0f, 0f);
        // on commence à dessiner des quadrilatères où on donne la position, les coordonnées de textures et la couleur
        buffer.begin(GL_QUADS, DefaultVertexFormats.POSITION_TEX_COLOR);
      //  float w = WIDTH / ((float)resolution.getScaleFactor());
      //  float h = HEIGHT / ((float)resolution.getScaleFactor());

        // on demande de ne garder que le vert de la couleur
        buffer.pos(0,0,0).tex(0, 0).color(0f, 1f, 0f, 1f).endVertex();
        buffer.pos(0,h,0).tex(0, 1f).color(0f, 1f, 0f, 1f).endVertex();
        buffer.pos(w, h,0).tex(1f, 1f).color(0f, 1f, 0f, 1f).endVertex();
        buffer.pos(w,0,0).tex(1f, 0).color(0f, 1f, 0f, 1f).endVertex();

        // on demande de ne garder que le rouge de la texture mais n'a aucun effet!
        glColor4f(1f, 0f, 0f, 1f);
        // on dessine le contenu
        tessellator.draw();

        glColor4f(1f, 1f, 1f, 1f);

        glPopMatrix();
    }
}
