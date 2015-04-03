package com.Avekeez.AvEvo;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	public static void init() {
		GameRegistry.addRecipe(new ItemStack(AvEvo.superRock), new Object[] {
			"ooo",
			"ogo",
			"ooo",
			'o', AvEvo.rock, 'g', Blocks.gold_ore
		});
	}
}
