package net.logandark.skyblock_void_thing.mixin;

import net.logandark.skyblock_void_thing.DefaultChunkBlanker;
import net.minecraft.server.world.ServerChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerChunkManager.class)
public abstract class MixinServerChunkManager {
	@Inject(
		at = @At("HEAD"),
		method = "method_21738"
	)
	private void onChunkCreated(long chunkPosLong, Chunk chunk, ChunkStatus chunkStatus, CallbackInfo ci) {
		if (chunk != null) {
			DefaultChunkBlanker.INSTANCE.blankChunk(chunk);
		}
	}
}
