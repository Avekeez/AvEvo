package com.Avekeez.AvEvo;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = AvEvo.MODID, version = AvEvo.MODID)
public class AvEvo {
	public static final String MODID = "avevo";
	public static final String VERSION = "0";
	
	@SidedProxy(clientSide = "com.Avekeez.AvEvo.ClientProxyAv", serverSide = "com.Avekeez.CommonProxyAv")
	public static CommonProxyAv proxy;
	
	public static Item rock;
	public static Item superRock;
	public static Item tastyRockHarvester;
	public static Item spongiteHelmet;
	public static Item jetpack;
	
	public static Block tastyRockOre;
	public static Block evolvedGrass;
	
	public static ToolMaterial rockium;
	public static ArmorMaterial spongite;
	public static ArmorMaterial jetPack;
	
	static int startEntityId = 300;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.registerRendering();
		
		AvEventHandler handler = new AvEventHandler();
		GameRegistry.registerWorldGenerator(handler, 0);
		
		rockium = EnumHelper.addToolMaterial("Rockium", 2, 2000, 10, 2, 1);
		spongite = EnumHelper.addArmorMaterial("Spongite", 20, new int[] {2,1,1,1}, 0);
		jetPack = EnumHelper.addArmorMaterial("Jetpack", 1000, new int[] {1,5,1,1}, 0);
		
		tastyRockOre = new AvBlock("tastyRockOre", CreativeTabs.tabBlock, "pickaxe", 2);
		evolvedGrass = new AvPlant("evGrass");
		
		tastyRockHarvester = new tastyRockHarvester(rockium, "tastyRockCollector");
		
		rock = new AvFood("tastyRock", 1, 0.1f, false);
		superRock = new AvFood("extraTastyRock", 2, 0.1f, false);
		
		spongiteHelmet = new spongiteHelmet(spongite, 0, "spongiteHelmet");
		jetpack = new Jetpack(jetPack, 1, "jetpack");
		
		GameRegistry.registerBlock(evolvedGrass, "EvolvedGrass");
		GameRegistry.registerBlock(tastyRockOre, "TastyRockOre");
		GameRegistry.registerItem(tastyRockHarvester, "TastyRockCollector");
		GameRegistry.registerItem(rock, "TastyRock");
		GameRegistry.registerItem(superRock, "ExtraTastyRock");
		GameRegistry.registerItem(spongiteHelmet, "SpongiteHelmet");
		GameRegistry.registerItem(jetpack, "Jetpack");
		
		EntityRegistry.registerModEntity(EntitySteverino.class, "Steverino", 0, this, 80, 3, true);
		registerEntityEgg(EntitySteverino.class, 0xd8bb9d, 0xa63c1a);
		OreDictionary.registerOre("oreTastyRock", new ItemStack(AvEvo.tastyRockOre));
		Recipes.init();
	}
	@EventHandler
	public void init(FMLInitializationEvent event) {
	}
	@SuppressWarnings("unchecked")
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) {
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, primaryColor, secondaryColor));
	}
	public static int getUniqueEntityId() {
		do {
			startEntityId++;
	    }
	    while (EntityList.getStringFromID(startEntityId) != null);
	    return startEntityId;
	}
}
