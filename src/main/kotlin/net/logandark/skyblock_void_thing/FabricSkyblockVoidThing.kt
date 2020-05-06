package net.logandark.skyblock_void_thing

import net.fabricmc.api.ModInitializer
import net.logandark.skyblock_void_thing.config.FabricSkyblockVoidThingConfig
import net.minecraft.util.Identifier

// For support join https://discord.gg/v6v4pMv

@Suppress("unused")
object FabricSkyblockVoidThing : ModInitializer {
	const val modid = "fabric-skyblock-void-thing"

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		println("Hello Fabric world!")

		// Cycle config to ensure the latest values are read & any errors are
		// fixed and written to file.
		FabricSkyblockVoidThingConfig.load()
		FabricSkyblockVoidThingConfig.save()
	}

	/**
	 * Creates an [Identifier] with [modid] as its namespace and [path] as its
	 * path.
	 */
	fun identifier(path: String) = Identifier(modid, path)
}