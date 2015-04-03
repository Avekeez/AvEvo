package com.Avekeez.AvEvo;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class AvItem extends Item {
	public AvItem(String itemName) {
		setUnlocalizedName(AvEvo.MODID + "_" + itemName);
		setTextureName(AvEvo.MODID + ":" + itemName);
		setCreativeTab(CreativeTabs.tabFood);
	}
}
