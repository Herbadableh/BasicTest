package itemtestagain.cot;


import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ZenRegister
@ZenExpansion("mods.contenttweaker.VanillaFactory")
public class ComponentVanillaFactoryExpansion {
    @ZenMethodStatic
    public static ComponentItemRepresentation createComponentItem(String unlocalizedName, int gearQuality, int gearSpeed, int gearMemory) {
        return new ComponentItemRepresentation(unlocalizedName, gearQuality, gearSpeed, gearMemory);
    }
}
