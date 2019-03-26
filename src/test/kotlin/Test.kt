import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestMain {
    @Test
    fun `Decoding without matching case`() {
        // language=JSON
        val source = """
            {
                "telephone": "xiaomi"
            }
            """.trimIndent()

        assertEquals(
            Json.nonstrict.parse(Data.serializer(), source),
            Data(
                telephone = Telephone.XIAOMI
            )
        )
    }

    @Test
    fun `Decoding with matching case`() {
        // language=JSON
        val source = """
            {
                "telephone": "SAMSUNG"
            }
            """.trimIndent()

        assertEquals(
            Json.nonstrict.parse(Data.serializer(), source),
            Data(
                telephone = Telephone.SAMSUNG
            )
        )
    }
}