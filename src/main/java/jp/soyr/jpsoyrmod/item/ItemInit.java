package jp.soyr.jpsoyrmod.item;

import jp.soyr.jpsoyrmod.Jpsoyrmod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
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

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
