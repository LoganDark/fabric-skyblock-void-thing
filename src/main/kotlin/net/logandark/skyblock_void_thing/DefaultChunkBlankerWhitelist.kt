package net.logandark.skyblock_void_thing

import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.entity.MobSpawnerBlockEntity
import net.minecraft.entity.mob.SilverfishEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView

object DefaultChunkBlankerWhitelist : ChunkBlankerWhitelist {
	override fun isBlockWhitelisted(
		view: BlockView,
		pos: BlockPos,
		blanker: ChunkBlanker
	): Boolean {
		val blockState: BlockState = view.getBlockState(pos)

		return when (blockState.block) {
			Blocks.END_PORTAL_FRAME,
			Blocks.END_PORTAL -> true
			Blocks.SPAWNER    ->
				(view.getBlockEntity(pos) as? MobSpawnerBlockEntity)
					?.logic?.renderedEntity is SilverfishEntity
			else              -> false
		}
	}

	override fun isBlockBlacklisted(
		view: BlockView,
		pos: BlockPos,
		blanker: ChunkBlanker
	) = false
}