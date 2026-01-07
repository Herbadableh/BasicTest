package itemtestagain.block;


import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import itemtestagain.block.BlockTest;
import lumaceon.mods.clockworkphase.block.tileentity.ITimeSandTile;
import static lumaceon.mods.clockworkphase.init.ModFluids.timeSand;
/*implements ITickable*/
public class TestTileEntity extends TileEntity implements ITickable{

    public FluidTank tank = new FluidTank(10000);
    private int wait = 20;

    //private final EnumFacing front = world.getBlockState(pos).getValue(BlockTest.FACING);
    //ends up becoming null when first placed in world, cannot load
    //you have to put it in individual functions, not as a single variable

    @Override
    public void update() {

        if(!world.isRemote)
        {
            wait--;
            if(wait <= 0)
            {wait = 20;//timer reset
                markDirty();
                EnumFacing front = world.getBlockState(pos).getValue(BlockTest.FACING);
                    TileEntity te = world.getTileEntity(pos.offset(front));//tile entity directly infront of the machine
                    if (te instanceof ITimeSandTile) {//if the tile has timesand
                        if (tank.getFluid() == null || tank.getFluid().getFluid() == timeSand) {//if empty or has time sand
                            if (world.isBlockPowered(pos)) { //if this machine has a redstone signal
                                int sandPileR = Math.min((((ITimeSandTile) te).getMaxTimeSandCapacity() - ((ITimeSandTile) te).getTimeSand()), tank.getFluidAmount());
                                if(sandPileR > 0){//if there is sand to move and (attached)machine isn't full:
                                    tank.drainInternal(sandPileR, true);
                                    ((ITimeSandTile) te).addTimeSand(sandPileR);
                                }
                            } else {
                                //either the amount of space left in the tank, or how much sand is in the machine, whichever is smaller.
                                int sandPile = Math.min((tank.getCapacity() - tank.getFluidAmount()), ((ITimeSandTile) te).getTimeSand());
                                if (sandPile > 0)//if there is sand to move and the tank isn't full:
                                {
                                    int sandIn = ((ITimeSandTile) te).removeTimeSand(sandPile);//checked the code, time sand IS equal to mB.
                                    FluidStack sand = new FluidStack(timeSand, sandIn);
                                    tank.fillInternal(sand, true);
                                }
                            }
                        }
                    }
            }
        }

    }


    @Override//                                             v the face trying to be accessed
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY && facing == world.getBlockState(pos).getValue(BlockTest.FACING).getOpposite()) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY && facing == world.getBlockState(pos).getValue(BlockTest.FACING).getOpposite()) {
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
