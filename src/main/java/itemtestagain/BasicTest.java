package itemtestagain;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import itemtestagain.handlers.ModRegistry;
import itemtestagain.proxy.CommonProxy;

@Mod(modid = BasicTest.MODID, version = BasicTest.VERSION, name = BasicTest.NAME, dependencies = "required-after:clockworkphase")
public class BasicTest {
    public static final String MODID = "itemtestagain";
    public static final String VERSION = "0.0.3";
    public static final String NAME = "BasicTest";

    public static final Logger LOGGER = LogManager.getLogger();
	
    @SidedProxy(clientSide = "itemtestagain.proxy.ClientProxy", serverSide = "itemtestagain.proxy.CommonProxy")
    public static CommonProxy PROXY;
	
	@Instance(MODID)
	public static BasicTest instance;
	
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModRegistry.init();
        BasicTest.PROXY.preInit();
    }
}