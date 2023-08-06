package jp.soyr.jpsoyrmod.item;

import jp.soyr.jpsoyrmod.Jpsoyrmod;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
  public static final DeferredRegister<Block> BLOCKS =
      DeferredRegister.create(ForgeRegistries.BLOCKS, Jpsoyrmod.MODID);

  public static final RegistryObject<DropExperienceBlock> EXAMPLE_ORE =
      BLOCKS.register(
          "iou_ore",
          () ->
              new DropExperienceBlock(
                  BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE), UniformInt.of(4, 7)));

  public static final RegistryObject<DropExperienceBlock> DEEPSLATE_EXAMPLE_ORE =
      BLOCKS.register(
          "deepslate_ore",
          () ->
              new DropExperienceBlock(
                  BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE),
                  UniformInt.of(4, 7)));

  public static final RegistryObject<DropExperienceBlock> NETHER_EXAMPLE_ORE =
      BLOCKS.register(
          "nether_example_ore",
          () ->
              new DropExperienceBlock(
                  BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE), UniformInt.of(4, 7)));

  public static final RegistryObject<DropExperienceBlock> END_EXAMPLE_ORE =
      BLOCKS.register(
          "end_example_ore",
          () ->
              new DropExperienceBlock(
                  BlockBehaviour.Properties.copy(Blocks.END_STONE), UniformInt.of(4, 7)));
}
