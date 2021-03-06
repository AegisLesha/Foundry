package exter.foundry.recipes;

import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exter.foundry.api.recipe.ISubstanceGuiTexture;

/**
 * Contains the Substance's texture to use in the Metal Infuser's GUI.
 */
@SideOnly(Side.CLIENT)
public class SubstanceGuiTexture implements ISubstanceGuiTexture
{
  static public final int TEXTURE_WIDTH = 8;
  
  
  /**
   * Location of the texture
   */
  public final ResourceLocation texture;

  /**
   * X coordinate in the texture
   */
  public final int x;

  /**
   * Y coordinate in the texture
   */
  public final int y;
  
  @Override
  public ResourceLocation GetLocation()
  {
    return texture;
  }
  
  @Override
  public int GetX()
  {
    return x;
  }
  
  @Override
  public int GetY()
  {
    return y;
  }
  
  /**
   * @param texture_path Location of the texture
   * @param pos_x X coordinate in the texture
   * @param pos_y Y coordinate in the texture
   */
  public SubstanceGuiTexture(ResourceLocation texture_path,int pos_x,int pos_y)
  {
    texture = texture_path;
    x = pos_x;
    y = pos_y;
  }
}
