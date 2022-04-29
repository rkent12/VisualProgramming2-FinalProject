package net.ryankent.practicemod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FirstBlock extends QuestBlocks {

    private int returnedVal;

    public FirstBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient()) {
            if (hand == Hand.MAIN_HAND) {
                returnedVal = checkBlockProgression("First Block");
                if(returnedVal == 1) {
                    player.sendMessage(new LiteralText("You have begun the quest, the next block is the Second block"), false);
                }
                else if(returnedVal == 2) {
                    player.sendMessage(new LiteralText("You have already interacted with this block"), false);
                }
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

}

