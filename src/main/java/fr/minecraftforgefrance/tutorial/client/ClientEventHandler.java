package fr.minecraftforgefrance.tutorial.client;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientEventHandler {

    @SubscribeEvent
    public void onGuiDrawing(RenderGameOverlayEvent.Pre event) {
        if(event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
            Renderer.drawTransparentSprite(event.getResolution());
            Renderer.drawModel(event.getResolution());
        }
    }
}
