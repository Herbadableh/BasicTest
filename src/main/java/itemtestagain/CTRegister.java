package itemtestagain;


import crafttweaker.CraftTweakerAPI;
import itemtestagain.cot.ComponentItemRepresentation;
import itemtestagain.cot.ComponentVanillaFactoryExpansion;

public class CTRegister {

    public static final String CT_PACKAGE = "mods.itemtestagain.";

    public static void preInit() {
        CraftTweakerAPI.registerClass(ComponentItemRepresentation.class);
        CraftTweakerAPI.registerClass(ComponentVanillaFactoryExpansion.class);
    }



}
