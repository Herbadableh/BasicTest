package itemtestagain;

import itemtestagain.item.ItemGeneric;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ModItems {

    @GameRegistry.ObjectHolder(BasicTest.MODID + ":testitem")
    public static ItemGeneric testItem; //acts as a reference for other classes

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        testItem.initModel();
    }

}
