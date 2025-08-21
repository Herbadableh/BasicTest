package itemtestagain.item;

import lumaceon.mods.clockworkphase.item.component.generic.IBaseComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import itemtestagain.BasicTest;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import javax.annotation.Nullable;
import java.util.List;

//you might ask "hey, why not use the ItemBaseComponentGeneric class instead of making your own item class?
//because the base item class is sloppy. like, why set a max damage to EVERY ITEM IN YOUR MOD?
//anyway, I'll probably scrap this at some point and redo it. Again.
public class ItemSpectralGear extends Item implements IBaseComponent {
/*
    //allows creating alot of generic named items, but idk how to add models or textures to them.
    public ItemGeneric(String name) {
        setRegistryName(BasicTest.MODID, name);
        setTranslationKey(name);
        setCreativeTab(CreativeTabs.COMBAT);
    }
*/


public ItemSpectralGear() {
    setRegistryName(BasicTest.MODID, "specgear");
    setTranslationKey(BasicTest.MODID + ".specgear");
    setCreativeTab(CreativeTabs.MISC);
}
    @Override
    public boolean isComponentSpeedy(ItemStack is)
    {
        return true;
    }
    @Override
    public boolean isComponentQuality(ItemStack is)
    {
        return true;
    }
    @Override
    public boolean isComponentMemory(ItemStack is)
    {
        return true;
    }
    @Override
    public int getGearQuality(ItemStack is)
    {
        return 60;
    }
    @Override
    public int getGearSpeed(ItemStack is)
    {
        return 20;
        //return ForgeConfigHandler.server.specSpeed //as reference if I want config values
    }
    @Override
    public int getMemoryValue(ItemStack is)//pet peeve, but why isn't it "getGearMemory"? it's shorter!
    {
        return 100;
    }

    @Override //tooltip to look identical to base mod items
    public void addInformation(ItemStack item, @Nullable World w, List<String> tooltip, ITooltipFlag ugh) {
        IBaseComponent component = (IBaseComponent)item.getItem();
        tooltip.add("Quality: " + "§e" + component.getGearQuality(item));
        tooltip.add("Speed: " + "§e" + component.getGearSpeed(item));
        tooltip.add("Memory: " + "§e" + component.getMemoryValue(item));
        super.addInformation(item, w, tooltip, ugh);
    }//all variable so I can just copy paste this and not worry about rewriting the values.

    //there HAS to be a better way to just add a texture to a flat item, right?
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}