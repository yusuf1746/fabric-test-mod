package testmodu;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class SinirsizSuBlocku extends Block{

	public SinirsizSuBlocku(Settings settings) {
		super(Settings.of(Material.STONE).resistance(15.0f).hardness(1.0f));
		
	}
	
	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		
		if(!world.isClient()) {
			if(player.getStackInHand(hand).getItem() == Items.BUCKET) {
				if(player.getStackInHand(hand).getCount() == 1 ) {
					player.setStackInHand(hand, new ItemStack(Items.WATER_BUCKET));
					world.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.MASTER, 1f, 1f);
					return ActionResult.SUCCESS;
				}
				else {
					player.getStackInHand(hand).decrement(1);
					if(!player.giveItemStack(new ItemStack(Items.WATER_BUCKET))) {
						player.dropItem(new ItemStack(Items.WATER_BUCKET), false, true);
					}
					world.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.MASTER, 1f, 1f);
					return ActionResult.SUCCESS;
				}
			}
		}
		
		return ActionResult.success(false);
	}
}
