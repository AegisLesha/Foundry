package exter.foundry.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import exter.foundry.recipes.InfuserRecipe;
import exter.foundry.recipes.SubstanceGuiTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientFoundryProxy extends CommonFoundryProxy
{
  static private ResourceLocation SUBSTANCES_TEXTURE = new ResourceLocation("foundry:textures/gui/infuser_substances.png");
  
  @Override
  public void Init()
  {
    InfuserRecipe.RegisterSubstanceTexture("carbon", new SubstanceGuiTexture(SUBSTANCES_TEXTURE,0,0));
  }
}
