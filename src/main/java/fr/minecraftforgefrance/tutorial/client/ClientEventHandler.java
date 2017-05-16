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
    private static final ResourceLocation transparentLogo = new ResourceLocation(OpenGLPratique.MODID, "transparentlogo_mff128x128.png");

    /**
     * C'est la méthode que l'on va modifier dans ce tutoriel
     */
    private void draw(ScaledResolution resolution) {
        glPushMatrix();
        Minecraft.getMinecraft().getTextureManager().bindTexture(transparentLogo); // on attache la 1ère texture
        drawRect(128, 128, resolution); // on dessine un 1er rectangle avec la texture transparente

        glTranslatef(100f, 100f, 0f);
        Minecraft.getMinecraft().getTextureManager().bindTexture(opaqueLogo); // on attache la 2ème texture
        drawRect(128, 128, resolution); // on dessine un 2nd rectangle avec la texture opaque
        glPopMatrix();
    }

    // Ne faites pas trop attention à ça, sert à dessiner un rectangle à l'écran; cette méthode sera expliquée plus tard dans le tutoriel
    private void drawRect(int width, int height, ScaledResolution resolution) {
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer buffer = tessellator.getBuffer();
        buffer.begin(GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        float w = width / ((float)resolution.getScaleFactor());
        float h = height / ((float)resolution.getScaleFactor());
        buffer.pos(0,0,0).tex(0, 0).endVertex();
        buffer.pos(0,h,0).tex(0, 1f).endVertex();
        buffer.pos(w, h,0).tex(1f, 1f).endVertex();
        buffer.pos(w,0,0).tex(1f, 0).endVertex();
        tessellator.draw();
    }
}
