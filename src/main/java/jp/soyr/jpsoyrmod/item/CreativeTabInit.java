package jp.soyr.jpsoyrmod.item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import jp.soyr.jpsoyrmod.Jpsoyrmod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author Jp_ryos
 */
@Mod.EventBusSubscriber(
    modid = Jpsoyrmod.MODID,
    bus = Mod.EventBusSubscriber.Bus.MOD,
    value = Dist.CLIENT)
public class CreativeTabInit {
  public static final DeferredRegister<CreativeModeTab> TABS =
      DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Jpsoyrmod.MODID);

  public static final List<Supplier<? extends ItemLike>> EXAMPLE_TAB_ITEMS = new ArrayList<>();

  public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB =
      TABS.register(
          "amedata_tab",
          () ->
              CreativeModeTab.builder()
                  .title(Component.translatable("itemGroup.amedata_tab"))
                  .icon(ItemInit.EXAMPLE_ITEM.get()::getDefaultInstance)
                  .displayItems(
                      (displayParams, output) -> {
                        EXAMPLE_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get()));
                      })
                  .build());

  public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike) {
    EXAMPLE_TAB_ITEMS.add(itemLike);
    return itemLike;
  }

  @SubscribeEvent
  public static void buildContents(BuildCreativeModeTabContentsEvent event) {
    if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
      event
          .getEntries()
          .putAfter(
              Items.APPLE.getDefaultInstance(),
              ItemInit.EXAMPLE_ITEM.get().getDefaultInstance(),
              CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    if (event.getTab() == EXAMPLE_TAB.get()) {
      event.accept(Items.CROSSBOW);
    }
  }
}
