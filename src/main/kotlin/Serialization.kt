@file:UseSerializers(
    TelephoneSerializer::class
)

import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor

@Serializable
data class Data(val telephone: Telephone)

private object TelephoneSerializer : KSerializer<Telephone> {
    override val descriptor: SerialDescriptor
        get() = StringDescriptor.withName("Telephone")

    override fun deserialize(decoder: Decoder): Telephone {
        val decoded = decoder.decodeString().toUpperCase()
        return Telephone.valueOf(decoded)
    }

    override fun serialize(encoder: Encoder, obj: Telephone) {
        TODO()
    }

}