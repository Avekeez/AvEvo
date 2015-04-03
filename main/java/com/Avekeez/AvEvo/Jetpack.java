package com.Avekeez.AvEvo;

import org.lwjgl.input.Keyboard;

import scala.swing.event.Key;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Jetpack extends ItemArmor {
	public Jetpack(ArmorMaterial material, int type, String itemName) {
		super(material, 0, type);
		setUnlocalizedName(AvEvo.MODID+"_"+itemName);
		setTextureName(AvEvo.MODID+":"+itemName);		
	}
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (itemStack.getItem() == AvEvo.jetpack) {
			if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
				System.out.println("SPAAAAAAAAAAAAAAAAAAAAAACE");
				player.setPosition(player.posX, player.posY + 1, player.posZ);
			}
		}
	}
}