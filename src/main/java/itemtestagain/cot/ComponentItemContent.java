package itemtestagain.cot;

import com.teamacronymcoders.contenttweaker.modules.vanilla.items.ItemContent;
import lumaceon.mods.clockworkphase.item.component.generic.IBaseComponent;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;


public class ComponentItemContent extends ItemContent implements IBaseComponent {

    private final int GearQuality;
    private final int GearSpeed;
    private final int GearMemory;

    public ComponentItemContent(ComponentItemRepresentation itemRepresentation) {
        super(itemRepresentation);
        this.GearQuality = itemRepresentation.gearQuality;
        this.GearSpeed = itemRepresentation.gearSpeed;
        this.GearMemory = itemRepresentation.gearMemory;
        //maxStackSize = 1;
    }

    @Override
    public int getGearSpeed(ItemStack is){
        if(GearSpeed != 0) {
            return GearSpeed;
        }else return 0;
    }
    @Override
    public int getGearQuality(ItemStack is){
        if(GearQuality != 0) {
            return GearQuality;
        }else return 0;
    }
    @Override
    public int getMemoryValue(ItemStack is){
        if(GearMemory != 0) {
            return GearMemory;
        }else return 0;
    }

    @Override
    public boolean isComponentSpeedy(ItemStack is){
        return false;
    }
    @Override
    public boolean isComponentQuality(ItemStack is){
        return false;
    }
    @Override
    public boolean isComponentMemory(ItemStack is){
        return false;
    }

    @Override //tooltip to look identical to base mod items
    public void addInformation(ItemStack item, @Nullable World w, List<String> tooltip, ITooltipFlag ugh) {
        if(GearQuality != 0) {
            tooltip.add("Quality: " + "§e" + GearQuality);
        }
        if(GearSpeed != 0) {
        tooltip.add("Speed: " + "§e" + GearSpeed);
        }
        if(GearMemory != 0) {
            tooltip.add("Memory: " + "§e" + GearMemory);
        }
        super.addInformation(item, w, tooltip, ugh);
    }

}
