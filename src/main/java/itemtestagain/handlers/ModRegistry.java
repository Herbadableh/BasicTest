package itemtestagain.handlers;

//import net.minecraft.init.PotionTypes;
//import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
//import net.minecraft.item.ItemArmor;
//import net.minecraft.potion.PotionEffect;
//import net.minecraft.potion.PotionHelper;
//import net.minecraft.potion.PotionType;
        import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import itemtestagain.BasicTest;
import itemtestagain.item.ItemExample;

@Mod.EventBusSubscriber(modid = BasicTest.MODID)
public class ModRegistry {

        //public static ItemArmor.ArmorMaterial EXAMPLE_ARMOR = EnumHelper.addArmorMaterial("example_armor", BasicTest.MODID + ":example_armor", 26, new int[]{2,4,6,2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
/*
        public static Item exampleHelmet = new ItemExample("example_helmet");
        public static Item exampleChestplate = new ItemExample("example_chestplate");
        public static Item exampleLeggings = new ItemExample("example_leggings");
        public static Item exampleBoots = new ItemExample("example_boots");
*/
        public static Item exampleItem = new ItemExample("soup");

        //public static PotionType examplePotion = new PotionType("example", new PotionEffect(PotionExample.INSTANCE)).setRegistryName(new ResourceLocation(BasicTest.MODID, "example"));

        public static void init() {

        }

        @SubscribeEvent
        public static void registerItemEvent(RegistryEvent.Register<Item> event) {
                event.getRegistry().registerAll(
                        /*
                        exampleHelmet,
                        exampleChestplate,
                        exampleLeggings,
                        exampleBoots
                         */
                        exampleItem
                );
        }
/*
        @SubscribeEvent
        public static void registerRecipeEvent(RegistryEvent.Register<IRecipe> event) {
                event.getRegistry().register(new RecipeExample().setRegistryName(new ResourceLocation(BasicTest.MODID, "example")));
        }
*/
        /*
        @SubscribeEvent
        public static void registerPotionEvent(RegistryEvent.Register<Potion> event) {
                event.getRegistry().register(PotionExample.INSTANCE);
        }
 */
/*
        @SubscribeEvent
        public static void registerPotionTypeEvent(RegistryEvent.Register<PotionType> event) {
                event.getRegistry().register(examplePotion);
                PotionHelper.addMix(PotionTypes.THICK, Items.DIAMOND, ModRegistry.examplePotion);
        }
 */
}