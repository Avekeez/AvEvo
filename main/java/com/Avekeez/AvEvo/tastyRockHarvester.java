package com.Avekeez.AvEvo;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class tastyRockHarvester extends ItemTool {
	private static Set blocks = Sets.newHashSet(new Block[] {
			AvEvo.tastyRockOre
	});
	public tastyRockHarvester(ToolMaterial material, String itemName) {
		super(1, material, blocks);
		setUnlocalizedName(AvEvo.MODID+"_"+itemName);
		setTextureName(AvEvo.MODID+":"+itemName);
	}
	public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase) {
		if (!world.isRemote) {
			if (block.getItem(world, x, y, z) == AvEvo.tastyRockOre.getItem(world, x, y, z)) {
				world.spawnEntityInWorld(new EntityItem(world, x + 0.5f, y + 0.5f, z + 0.5f, new ItemStack(AvEvo.rock, 4, 0)));
			}
		}
		return true;
	}
}
