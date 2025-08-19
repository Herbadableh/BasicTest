package itemtestagain;

import itemtestagain.item.ItemSpectralGear;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ModItems {

    @GameRegistry.ObjectHolder(BasicTest.MODID + ":specgear")
    public static ItemSpectralGear testItem; //acts as a reference for other classes

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        testItem.initModel();
    }

}
