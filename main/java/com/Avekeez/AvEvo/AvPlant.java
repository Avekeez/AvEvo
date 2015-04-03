package com.Avekeez.AvEvo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class AvPlant extends BlockBush {
	private String name;
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	public AvPlant(String itemName) {
		super(Material.plants);
		name = itemName;
		setBlockName(AvEvo.MODID+"_"+itemName);
		setCreativeTab(CreativeTabs.tabDecorations);
		setHardness(0);
		setBlockBounds(0f, 0.0f, 0f, 1f, 0.25f, 1f);
		setStepSound(Block.soundTypeGrass);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		icons = new IIcon[3];
		for (int i = 0; i < icons.length; i ++) {
			icons[i] = par1IconRegister.registerIcon(AvEvo.MODID+":"+name+(i+1));
		}
	}
	public IIcon getIcon(int par1) {
		return icons[par1];
	}
	@Override
	public int getRenderType() {
		return 6;
	}
}
