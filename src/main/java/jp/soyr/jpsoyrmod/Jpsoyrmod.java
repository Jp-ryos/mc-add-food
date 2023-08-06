package jp.soyr.jpsoyrmod;

import jp.soyr.jpsoyrmod.item.BlockInit;
import jp.soyr.jpsoyrmod.item.CreativeTabInit;
import jp.soyr.jpsoyrmod.item.ItemInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Jpsoyrmod.MODID)
public class Jpsoyrmod {

  public static final String MODID = "jpsoyrmod";

  public Jpsoyrmod() {
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    ItemInit.ITEMS.register(bus);
    BlockInit.BLOCKS.register(bus);
    CreativeTabInit.TABS.register(bus);
  }
}
