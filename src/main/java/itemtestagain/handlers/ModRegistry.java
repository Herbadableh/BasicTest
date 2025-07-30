package itemtestagain.handlers;


import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import itemtestagain.BasicTest;
import itemtestagain.item.ItemExample;

@Mod.EventBusSubscriber(modid = BasicTest.MODID)
public class ModRegistry {

        public static Item exampleItem = new ItemExample("soup");

        public static void init() {

        }

        @SubscribeEvent
        public static void registerItemEvent(RegistryEvent.Register<Item> event) {
                event.getRegistry().registerAll(
                        exampleItem
                );
        }
/*
        @SubscribeEvent
        public static void registerRecipeEvent(RegistryEvent.Register<IRecipe> event) {
                event.getRegistry().register(new RecipeExample().setRegistryName(new ResourceLocation(BasicTest.MODID, "example")));
        }
*/
}