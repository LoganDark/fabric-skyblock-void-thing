package net.logandark.skyblock_void_thing

import net.minecraft.block.Blocks
import net.minecraft.util.math.BlockPos
import net.minecraft.world.chunk.Chunk

object DefaultChunkBlanker : ChunkBlanker {
	override val whitelist = DefaultChunkBlankerWhitelist

	override fun blankChunk(chunk: Chunk) {
		for (y in 0..255)
			for (z in 0..15)
				for (x in 0..15) {
					val blockPos = BlockPos(x, y, z)
					val whitelisted = whitelist.isBlockWhitelisted(chunk, blockPos, this)
					val blacklisted = whitelist.isBlockBlacklisted(chunk, blockPos, this)

					if (whitelisted && blacklisted)
						error("Block can't be whitelisted and blacklisted at the same time...")

					if (!whitelisted) {
						chunk.setBlockState(blockPos, Blocks.AIR.defaultState, false)
					}
				}
	}
}