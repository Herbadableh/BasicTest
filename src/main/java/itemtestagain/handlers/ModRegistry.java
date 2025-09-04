package itemtestagain.handlers;


import itemtestagain.ModBlocks;
import itemtestagain.block.BlockTest;
import itemtestagain.block.TestTileEntity;
import net.minecraft.block.Block;
import itemtestagain.item.ItemSpectralGear;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import itemtestagain.BasicTest;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber(modid = BasicTest.MODID)
public class ModRegistry {

        public static Item exampleItem = new ItemSpectralGear();

        public static void init() {

        }

        @SubscribeEvent
        public static void registerItemEvent(RegistryEvent.Register<Item> event) {
                event.getRegistry().registerAll(
                        exampleItem
                );
        }
        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
                event.getRegistry().register(new BlockTest());
                GameRegistry.registerTileEntity(TestTileEntity.class, BasicTest.MODID + "_testblock");
        }
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
                event.getRegistry().register(new ItemBlock(ModBlocks.testBlock).setRegistryName(ModBlocks.testBlock.getRegistryName()));
        }
/*
        @SubscribeEvent
        public static void registerRecipeEvent(RegistryEvent.Register<IRecipe> event) {
                event.getRegistry().register(new RecipeExample().setRegistryName(new ResourceLocation(BasicTest.MODID, "example")));
        }
*/
}