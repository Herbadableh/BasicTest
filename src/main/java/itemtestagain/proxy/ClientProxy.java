package itemtestagain.proxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import itemtestagain.ModItems;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import itemtestagain.handlers.ModRegistry;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
/*
    private static final ModelExampleArmor exampleArmor = new ModelExampleArmor(1.0F);
    private static final ModelExampleArmor exampleArmorLegs = new ModelExampleArmor(0.5F);

    private static final Map<Item, ModelBiped> exampleArmorModels = new HashMap<Item, ModelBiped>();
*/
    @Override
    public void preInit() {
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        //ModBlocks.initModels();
        ModItems.initModels();
    }
}