package jp.soyr.jpsoyrmod.item;

import static jp.soyr.jpsoyrmod.item.CreativeTabInit.addToTab;

import jp.soyr.jpsoyrmod.Jpsoyrmod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
  public static final DeferredRegister<Item> ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, Jpsoyrmod.MODID);
  public static final RegistryObject<Item> EXAMPLE_ITEM =
      ITEMS.register(
          "amedama",
          () ->
              new Item(
                  new Item.Properties()
                      .stacksTo(64)
                      .food(
                          new FoodProperties.Builder()
                              .nutrition(10)
                              .saturationMod(2)
                              .effect(
                                  () -> new MobEffectInstance(MobEffects.ABSORPTION, 200, 2), 0.12f)
                              .build())
                      .rarity(Rarity.COMMON)));

  public static final RegistryObject<BlockItem> EXAMPLE_ORE_ITEM =
      addToTab(
          ITEMS.register(
              "iou_ore", () -> new BlockItem(BlockInit.EXAMPLE_ORE.get(), new Item.Properties())));

  public static final RegistryObject<BlockItem> DEEPSLATE_EXAMPLE_ORE_ITEM =
      addToTab(
          ITEMS.register(
              "deepslate_ore",
              () -> new BlockItem(BlockInit.DEEPSLATE_EXAMPLE_ORE.get(), new Item.Properties())));

  public static final RegistryObject<BlockItem> NETHER_EXAMPLE_ORE_ITEM =
      addToTab(
          ITEMS.register(
              "nether_example_ore",
              () -> new BlockItem(BlockInit.NETHER_EXAMPLE_ORE.get(), new Item.Properties())));

  public static final RegistryObject<BlockItem> END_EXAMPLE_ORE_ITEM =
      addToTab(
          ITEMS.register(
              "end_example_ore", () -> new BlockItem(BlockInit.END_EXAMPLE_ORE.get(), new Item.Properties())));

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
