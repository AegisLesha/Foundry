package exter.foundry.integration;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import exter.foundry.api.recipe.FoundryRecipes;
import exter.foundry.config.FoundryConfig;
import exter.foundry.item.FoundryItems;
import exter.foundry.item.ItemMold;
import exter.foundry.recipes.manager.CastingRecipeManager;
import exter.foundry.recipes.manager.MeltingRecipeManager;
import exter.foundry.registry.LiquidMetalRegistry;
import exter.foundry.util.FoundryMiscUtils;
import forestry.api.core.ItemInterface;

public class ModIntegrationForestry extends ModIntegration
{
  static public final int ITEM_COPPER_GEAR = 0;
  static public final int ITEM_TIN_GEAR = 1;
  static public final int ITEM_BRONZE_GEAR = 2;
  
  public ModIntegrationForestry(String mod_name)
  {
    super(mod_name);
  }

  @Override
  public void OnPreInit(Configuration config)
  {
    
  }

  @Override
  public void OnInit()
  {
    items = new ItemStack[3];
    items[ITEM_COPPER_GEAR] = ItemStack.copyItemStack(ItemInterface.getItem("gearCopper"));
    items[ITEM_TIN_GEAR] = ItemStack.copyItemStack(ItemInterface.getItem("gearTin"));
    items[ITEM_BRONZE_GEAR] = ItemStack.copyItemStack(ItemInterface.getItem("gearBronze"));
    VerifyItems();

    if(is_loaded)
    {
      FoundryMiscUtils.RegisterInOreDictionary("gearCopper",items[ITEM_COPPER_GEAR]);
      FoundryMiscUtils.RegisterInOreDictionary("gearTin",items[ITEM_TIN_GEAR]);
      FoundryMiscUtils.RegisterInOreDictionary("gearBronze",items[ITEM_BRONZE_GEAR]);
      if(!FoundryConfig.recipe_gear_useoredict)
      {
        Fluid liquid_copper = LiquidMetalRegistry.instance.GetFluid("Copper");
        Fluid liquid_tin = LiquidMetalRegistry.instance.GetFluid("Tin");
        Fluid liquid_bronze = LiquidMetalRegistry.instance.GetFluid("Bronze");

        ItemStack mold_gear = new ItemStack(FoundryItems.item_mold,1,ItemMold.MOLD_GEAR);
        MeltingRecipeManager.instance.AddRecipe(items[ITEM_COPPER_GEAR], new FluidStack(liquid_copper,FoundryRecipes.FLUID_AMOUNT_INGOT * 4));
        MeltingRecipeManager.instance.AddRecipe(items[ITEM_TIN_GEAR], new FluidStack(liquid_tin,FoundryRecipes.FLUID_AMOUNT_INGOT * 4));
        MeltingRecipeManager.instance.AddRecipe(items[ITEM_BRONZE_GEAR], new FluidStack(liquid_bronze,FoundryRecipes.FLUID_AMOUNT_INGOT * 4));

        CastingRecipeManager.instance.AddRecipe(items[ITEM_COPPER_GEAR], new FluidStack(liquid_copper,FoundryRecipes.FLUID_AMOUNT_INGOT * 4),mold_gear,null);
        CastingRecipeManager.instance.AddRecipe(items[ITEM_TIN_GEAR], new FluidStack(liquid_tin,FoundryRecipes.FLUID_AMOUNT_INGOT * 4),mold_gear,null);
        CastingRecipeManager.instance.AddRecipe(items[ITEM_BRONZE_GEAR], new FluidStack(liquid_bronze,FoundryRecipes.FLUID_AMOUNT_INGOT * 4),mold_gear,null);
      }
    }
  }

  @Override
  public void OnPostInit()
  {

  }
}
