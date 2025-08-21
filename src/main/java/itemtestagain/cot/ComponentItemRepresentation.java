package itemtestagain.cot;

import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import com.teamacronymcoders.contenttweaker.modules.vanilla.items.ItemRepresentation;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;
import itemtestagain.CTRegister;

@ZenClass(CTRegister.CT_PACKAGE + "cot.ComponentItem")
public class ComponentItemRepresentation extends ItemRepresentation{

    final int gearQuality;
    final int gearSpeed;
    final int gearMemory;

    public ComponentItemRepresentation(String unlocalizedName, int gearQuality, int gearSpeed, int gearMemory) {
        this.unlocalizedName = unlocalizedName;
        this.gearQuality = gearQuality;
        this.gearSpeed = gearSpeed;
        this.gearMemory = gearMemory;
    }


    @Override
    public void register() {
        ContentTweaker.instance.getRegistry(ItemRegistry.class, "ITEM").register(new ComponentItemContent(this));
    }
}
