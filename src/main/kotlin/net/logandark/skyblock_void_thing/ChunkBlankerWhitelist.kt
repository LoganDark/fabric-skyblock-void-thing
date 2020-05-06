package net.logandark.skyblock_void_thing

import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView

interface ChunkBlankerWhitelist {
	/**
	 * Return `true` if the block should absolutely be kept.
	 */
	fun isBlockWhitelisted(
		view: BlockView,
		pos: BlockPos,
		blanker: ChunkBlanker
	): Boolean

	/**
	 * Return `true` is the block should absolutely be deleted.
	 */
	fun isBlockBlacklisted(
		view: BlockView,
		pos: BlockPos,
		blanker: ChunkBlanker
	): Boolean
}