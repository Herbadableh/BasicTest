package itemtestagain;


import itemtestagain.block.BlockTest;
import itemtestagain.item.ItemSpectralGear;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    @GameRegistry.ObjectHolder(BasicTest.MODID + ":testblock")
    public static BlockTest testBlock; //acts as a reference for other classes

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        testBlock.initModel();
    }

}
