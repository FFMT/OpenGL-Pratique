package fr.minecraftforgefrance.tutorial.client;

import fr.minecraftforgefrance.tutorial.OpenGLPratique;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

import static org.lwjgl.opengl.GL11.GL_QUADS;

/**
 * Ceci est une classe utilisée pour l'exemple et n'est probablement pas utilisable en pratique sans faire des gros changements.
 *
 * Permet de dessiner le logo de MinecraftForgeFrance.
 */
public class Sprite {

    private static final ResourceLocation logo = new ResourceLocation(OpenGLPratique.MODID, "logo_mff64x64.png");
    private static final int WIDTH = 64;
    private static final int HEIGHT = 64;

    public static void draw() {
        Minecraft.getMinecraft().getTextureManager().bindTexture(logo);
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer buffer = tessellator.getBuffer();
        buffer.begin(GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        buffer.pos(0,0,0).tex(0, 0).endVertex();
        buffer.pos(WIDTH,0,0).tex(1f, 0).endVertex();
        buffer.pos(WIDTH,HEIGHT,0).tex(1f, 1f).endVertex();
        buffer.pos(0,HEIGHT,0).tex(0, 1f).endVertex();
        tessellator.draw();
    }
}
