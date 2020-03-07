package client.mods;

import java.awt.Color;
import net.minecraft.client.gui.Gui;
import client.gui.hud.ScreenPosition;
import client.mods.ModDraggable;

public class ModPing extends ModDraggable {
	
	private ScreenPosition pos;
	

	@Override
	public int getWidth() {
		int ping = mc.getMinecraft().getNetHandler().getPlayerInfo(mc.getMinecraft().thePlayer.getUniqueID()).getResponseTime();
		return font.getStringWidth("Ping" + ping);
		
	}
	# This is used to get the length of ping alone, without "Ping;"
	public int getWidth2() {
		int ping = mc.getMinecraft().getNetHandler().getPlayerInfo(mc.getMinecraft().thePlayer.getUniqueID()).getResponseTime();
		return font.getStringWidth("" + ping);
		
	}

	@Override
	public int getHeight() {
		
		return font.FONT_HEIGHT;
		
	}

	@Override
	public void render(ScreenPosition pos) {
		int ping = mc.getMinecraft().getNetHandler().getPlayerInfo(mc.getMinecraft().thePlayer.getUniqueID()).getResponseTime();
		if(ping <= 10) {
			font.drawStringWithShadow("§b  " + ping + " ms", pos.getAbsoluteX() + getWidth2() + 3, pos.getAbsoluteY() + 4, -1);
			return;
		} else if (ping <= 50) {
			font.drawStringWithShadow("§a  " + ping + " ms", pos.getAbsoluteX() + getWidth2(), pos.getAbsoluteY() + 4, -1);
			return;
		} else if (ping <= 100) {
			font.drawStringWithShadow("§2  " + ping + " ms", pos.getAbsoluteX() + getWidth2() - 3, pos.getAbsoluteY() + 4, -1);
			return;
		} else if (ping <= 150) {
			font.drawStringWithShadow("§e  " + ping + " ms" , pos.getAbsoluteX() + getWidth2() - 3, pos.getAbsoluteY() + 4, -1);
			return;
		} else if (ping <= 180) {
			font.drawStringWithShadow("§c  " + ping + " ms", pos.getAbsoluteX() + getWidth2() - 3, pos.getAbsoluteY() + 4, -1);
			return;
		} else {
			font.drawStringWithShadow("§4  " + ping + " ms", pos.getAbsoluteX() + getWidth2() - 3, pos.getAbsoluteY() + 4, -1);
			return;
		}
		
	}
	

}
