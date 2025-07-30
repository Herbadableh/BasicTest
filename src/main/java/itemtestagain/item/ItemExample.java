package itemtestagain.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import itemtestagain.BasicTest;


public class ItemExample extends Item {

    public ItemExample(String name) {
        setRegistryName(BasicTest.MODID, name);
        setTranslationKey(name);
        setCreativeTab(CreativeTabs.COMBAT);
    }
}