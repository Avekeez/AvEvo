package com.Avekeez.AvEvo;

import net.minecraft.item.ItemFood;

public class AvFood extends ItemFood{
	public AvFood(String itemName, int food, float saturation, boolean wolf) {
		super(food, saturation, wolf);
		setUnlocalizedName(AvEvo.MODID + "_" + itemName);
		setTextureName(AvEvo.MODID + ":" + itemName);
	}
}