package itemtestagain.block;


import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import itemtestagain.block.BlockTest;

public class TestTileEntity extends TileEntity{

    public FluidTank tank = new FluidTank(10000);
    //private int counter = 0;
    private final EnumFacing front = world.getBlockState(pos).getValue(BlockTest.FACING);

    /*public int decrement() {
        counter--;
        markDirty();//marks something to save to disk
        return counter;
    }

    public int increment() {
        counter++;
        markDirty();
        return counter;
    }
    */

    /*
    @Override
    public void update() {
        if(!world.isRemote)
        {
            TileEntity te = world.getTileEntity(pos.offset(front));
            if(te != null && te)
        }
    }
*/
    @Override//                                             v the face trying to be accessed
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY && facing == front.getOpposite()) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY && facing == front.getOpposite()) {
            return CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.cast(tank);
        }
        return super.getCapability(capability, facing);
    }




    @Override
    public void readFromNBT(NBTTagCompound compound) {//reads from the blocks nbt to get the value
        super.readFromNBT(compound);
        //counter = compound.getInteger("counter");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {//sets the specific value
        super.writeToNBT(compound);
        //compound.setInteger("counter", counter);
        return compound;
    }
}
