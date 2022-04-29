package net.ryankent.practicemod.block.custom;

import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.ryankent.practicemod.PracticeMod;
import net.ryankent.practicemod.item.CustomUI;
import net.ryankent.practicemod.screenhandler.screen.BoxScreenHandler;
import net.ryankent.practicemod.block.ModBlocks;

public class BoxBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, CustomUI {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);

    public BoxBlockEntity(BlockPos pos, BlockState state) {
        super(PracticeMod.BOX_BLOCK_ENTITY, pos, state);
    }

    //From the ImplementedInventory Interface
    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }


    //These Methods are from the NamedScreenHandlerFactory Interface
    //createMenu creates the ScreenHandler itself
    //getDisplayName will Provide its name which is normally shown at the top
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new BoxScreenHandler(syncId, playerInventory, this);
    }
    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, this.inventory);
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, this.inventory);
        return nbt;
    }
}


