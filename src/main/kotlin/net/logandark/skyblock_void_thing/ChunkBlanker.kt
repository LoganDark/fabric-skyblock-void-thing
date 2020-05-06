package net.logandark.skyblock_void_thing

import net.minecraft.world.chunk.Chunk

interface ChunkBlanker {
	val whitelist: ChunkBlankerWhitelist
	fun blankChunk(chunk: Chunk)
}