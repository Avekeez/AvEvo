package com.Avekeez.AvEvo;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyAv extends CommonProxyAv{
	@Override
	public void registerRendering() {
		RenderingRegistry.registerEntityRenderingHandler(EntitySteverino.class, new RenderSteverino(new ModelSteverino(),0.5f));
	}
}
