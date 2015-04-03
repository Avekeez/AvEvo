package com.Avekeez.AvEvo;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class AvBlock extends Block {
	public AvBlock(String itemName, CreativeTabs creativeTab, String toolType, int harvest) {
		super(Material.rock);
		setBlockName(AvEvo.MODID+"_"+itemName);
		setBlockTextureName(AvEvo.MODID+":"+itemName);
		setCreativeTab(creativeTab);
		setHardness(1.8f);
		setResistance(7f);
		setStepSound(Block.soundTypeStone);
		setHarvestLevel(toolType, harvest);
	}
}
