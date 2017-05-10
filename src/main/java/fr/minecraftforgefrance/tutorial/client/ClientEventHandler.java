package fr.minecraftforgefrance.tutorial.client;

import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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
        Renderer.drawTransparentSprite(resolution);
        Renderer.drawModel(resolution);
    }
}
