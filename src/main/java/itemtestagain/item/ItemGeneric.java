package itemtestagain.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import itemtestagain.BasicTest;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;


public class ItemGeneric extends Item {
/*
    //allows creating alot of generic named items, but idk how to add models or textures to them.
    public ItemGeneric(String name) {
        setRegistryName(BasicTest.MODID, name);
        setTranslationKey(name);
        setCreativeTab(CreativeTabs.COMBAT);
    }
*/
public ItemGeneric() {
    setRegistryName(BasicTest.MODID, "testitem");
    setTranslationKey("testitem");
    setCreativeTab(CreativeTabs.MISC);
}


    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}