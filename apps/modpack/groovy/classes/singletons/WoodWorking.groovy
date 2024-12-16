package classes.singletons

import com.cleanroommc.groovyscript.api.IIngredient

/**
 * Registers the recipes to create stairs out of the given wood variant.
 */
class WoodWorking {
  /**
   * Initializes the singleton.
   */
  void initialize() {
    // Oak
    registerWoodVariant(
      item("minecraft:log:0"),
      item("minecraft:log:0"),
      item("minecraft:log:0"),
      item("minecraft:planks:0")
    );
  }

  /**
   * Registers a new wood variant.
   */
  void registerWoodVariant(
    IIngredient log,
    IIngredient debarked,
    IIngredient board,
    IIngredient planks
  ) {
    // Remove all current recipes

    // Add oredicts

    // Create debarking recipe

    // Create chopping block recipe
    registerPlanksRecipes(board);
    registerSlabRecipes(board);
  }

  /**
   * Registers the recipes that create `planks` out of the given wood variant.
   */
  void registerPlanksRecipes(
    IIngredient board
  ) {
    // TODO
  }

  /**
   * Registers the recipes that create `slab` out of the given wood variant.
   */
  void registerSlabRecipes(
    IIngredient board
  ) {
    // TODO
  }

  /**
   * Registers the recipes that create `stairs` out of the given wood variant.
   */
  void registerStairRecipes(
    IIngredient board
  ) {
    // TODO
  }

  /**
   * Registers the recipes that create `fence` out of the given wood variant.
   */
  void registerFenceRecipes(
    IIngredient board
  ) {
    // TODO
  }

  /**
   * Registers the recipes that create `fence gate` out of the given wood variant.
   */
  void registerFenceGateRecipes(
    IIngredient board
  ) {
    // TODO
  }

  /**
   * Registers the recipes that create `door` out of the given wood variant.
   */
  void registerDoorRecipes(
    IIngredient board
  ) {
    // TODO
  }

  /**
   * Registers the recipes that create `boat` out of the given wood variant.
   */
  void registerBoatRecipes(
    IIngredient board
  ) {
    // TODO
  }

  /**
   * Registers the recipes that create `chair` out of the given wood variant.
   */
  void registerChairRecipes(
    IIngredient board
  ) {
    // TODO
  }

  /**
   * Registers the recipes that create `table` out of the given wood variant.
   */
  void registerTableRecipes(
    IIngredient board
  ) {
    // TODO
  }

}
