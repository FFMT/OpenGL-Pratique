package fr.minecraftforgefrance.tutorial.client;

import fr.minecraftforgefrance.tutorial.OpenGLPratique;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

import static org.lwjgl.opengl.GL11.*;

/**
 * Ceci est une classe utilisée pour l'exemple et n'est probablement pas utilisable en pratique sans faire des gros changements.
 *
 * Permet de dessiner le logo de MinecraftForgeFrance et le modèle du joueur.
 */
public class Renderer {

    private static final ResourceLocation opaqueLogo = new ResourceLocation(OpenGLPratique.MODID, "logo_mff128x128.png");
    private static final ResourceLocation transparentLogo = new ResourceLocation(OpenGLPratique.MODID, "transparentlogo_mff128x128.png");
    private static final int WIDTH = 128;
    private static final int HEIGHT = 128;

    public static void drawOpaqueSprite(ScaledResolution resolution) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(opaqueLogo);
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer buffer = tessellator.getBuffer();
        buffer.begin(GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        float w = WIDTH / ((float)resolution.getScaleFactor());
        float h = HEIGHT / ((float)resolution.getScaleFactor());
        buffer.pos(0,0,0).tex(0, 0).endVertex();
        buffer.pos(0,h,0).tex(0, 1f).endVertex();
        buffer.pos(w, h,0).tex(1f, 1f).endVertex();
        buffer.pos(w,0,0).tex(1f, 0).endVertex();
        tessellator.draw();
    }

    public static void drawTransparentSprite(ScaledResolution resolution) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(transparentLogo);
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer buffer = tessellator.getBuffer();
        buffer.begin(GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        float w = WIDTH / ((float)resolution.getScaleFactor());
        float h = HEIGHT / ((float)resolution.getScaleFactor());
        buffer.pos(0,0,0).tex(0, 0).endVertex();
        buffer.pos(0,h,0).tex(0, 1f).endVertex();
        buffer.pos(w, h,0).tex(1f, 1f).endVertex();
        buffer.pos(w,0,0).tex(1f, 0).endVertex();
        tessellator.draw();
    }

    public static void drawModel(ScaledResolution resolution) {
        Minecraft mc = Minecraft.getMinecraft();
        GuiInventory.drawEntityOnScreen(100,100,resolution.getScaleFactor()*10, 0f, 0f, mc.player);
    }
}
