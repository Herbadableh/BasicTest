package itemtestagain.block;


import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;

public class TestTileEntity extends TileEntity{

    //public FluidTank tank = new FluidTank(10000);
    private int counter = 0;

    public int decrement() {
        counter--;
        markDirty();//marks something to save to disk
        return counter;
    }

    public int increment() {
        counter++;
        markDirty();
        return counter;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {//reads from the blocks nbt to get the value
        super.readFromNBT(compound);
        counter = compound.getInteger("counter");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {//sets the specific value
        super.writeToNBT(compound);
        compound.setInteger("counter", counter);
        return compound;
    }
}
