package com.Avekeez.AvEvo;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class spongiteHelmet extends ItemArmor {
	public spongiteHelmet(ArmorMaterial material, int type, String itemName) {
		super(material, 0, type);
		setUnlocalizedName(AvEvo.MODID+"_"+itemName);
		setTextureName(AvEvo.MODID+":"+itemName);
	}
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (itemStack.getItem() == AvEvo.spongiteHelmet) {
			if (player.isInWater()) {
				player.setAir(20);
			}
		}
	}
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String Type) {
		return AvEvo.MODID+":models/armor/spongiteHelmet";
	}
}
