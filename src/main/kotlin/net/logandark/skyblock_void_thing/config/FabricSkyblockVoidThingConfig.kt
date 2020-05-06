package net.logandark.skyblock_void_thing.config

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import io.github.prospector.modmenu.api.ModMenuApi
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder
import net.logandark.config.Config
import net.logandark.skyblock_void_thing.FabricSkyblockVoidThing

object FabricSkyblockVoidThingConfig : Config("fabric-skyblock-void-thing.json", 1), ModMenuApi {
	override fun getModId() = FabricSkyblockVoidThing.modid
	//override fun getModConfigScreenFactory() = ConfigScreenFactory(::createConfigScreen)

	val example = add(
		object : ConfigOption<Boolean>(
			FabricSkyblockVoidThing.identifier("example"),
			"example",
			false,
			null
		) {
			override fun makeEntry(entryBuilder: ConfigEntryBuilder) =
				entryBuilder
					.startBooleanToggle(translationKey, get())
					.setDefaultValue(defaultValue)
					.setSaveConsumer(this::set)
					.build()

			override fun serialize() = JsonPrimitive(get())

			override fun deserialize(jsonElement: JsonElement) =
				if (jsonElement is JsonPrimitive && jsonElement.isBoolean)
					jsonElement.asBoolean
				else
					error("Invalid JsonElement to deserialize")
		}
	)
}