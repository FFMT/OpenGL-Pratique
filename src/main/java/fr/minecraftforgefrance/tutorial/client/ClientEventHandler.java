package fr.minecraftforgefrance.tutorial.client;

import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
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
        // exemple 1
        glPushMatrix();
        glTranslatef(0f, 100f, 0f); // juste pour tout rentrer sur l'écran
        glScalef(10f, 1f, 1f);
        Renderer.drawOpaqueSprite(resolution);
        glPopMatrix();

        // exemple 2
        glPushMatrix();
        glTranslatef(100f, 200f, 0f);
        glScalef(2f, 1f, 1f); // On applique l'homothétie **après** la translation
        Renderer.drawOpaqueSprite(resolution);
        glPopMatrix();

        // exemple 3
        glPushMatrix();
        glTranslatef(0f, 200f, 0f);
        glScalef(2f, 1f, 1f); // On applique l'homothéthie **avant** la translation
        glTranslatef(100f, 0f, 0f);
        Renderer.drawOpaqueSprite(resolution);
        glPopMatrix();

        // exemple 4
        GlStateManager.disableCull(); // necessaire pour que ce rendu ('draw opaque sprite') fonctionne, plus d'infos plus loin
        glPushMatrix();

        // l'homothétie se fait depuis le point (0,0) et on décale l'image pour qu'elle apparaisse à l'écran
        // N'hésitez pas à mettre 10f sur l'axe Y pour que mieux comprendre
        glTranslatef(100f, 128f/resolution.getScaleFactor(), 0f);
        glScalef(1f, -1f, 1f); // On applique l'homothéthie **avant** la translation
        Renderer.drawOpaqueSprite(resolution);
        glPopMatrix();
        GlStateManager.enableCull(); // necessaire pour que ce rendu ('draw opaque sprite') fonctionne, plus d'infos plus loin
    }
}
