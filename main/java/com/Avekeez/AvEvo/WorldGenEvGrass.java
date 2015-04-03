package com.Avekeez.AvEvo;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenEvGrass extends WorldGenerator{
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		for (int i = 0; i < 64; i ++) {
			int x1 = x + random.nextInt(8) - random.nextInt(8);
	        int y1 = y + random.nextInt(4) - random.nextInt(4);
	        int z1 = z + random.nextInt(8) - random.nextInt(8);
	        if (AvEvo.evolvedGrass.canPlaceBlockAt(world, x1, y1, z1) && 
	        		world.getBlock(x1, y1-1, z1) == Blocks.grass) {
	        	world.setBlock(x1, y1, z1, AvEvo.evolvedGrass, random.nextInt(3), 2);
	        }
		}
		return true;
	}
}
