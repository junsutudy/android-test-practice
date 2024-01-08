package app.junsu.test

import org.junit.Test

class ExampleUnitTest {

    @Test
    fun `Test addition of String and Double`() {
        assert(AdditionManager.calculateToDouble("24", 2) == 26.0)
    }

    @Test
    fun `Test addition of Double and Int`() {
        assert(AdditionManager.calculateToDouble(2.0, 6) == 8.0)
    }
}

object AdditionManager {
    fun calculateToDouble(a: Any, b: Any): Double {

        val aInNumber = try {
            a.toString().toDouble()
        } catch (_: Exception) {
            throw NumberFormatException()
        }

        val bInNumber = try {
            b.toString().toDouble()
        } catch (_: Exception) {
            throw NumberFormatException()
        }

        return aInNumber + bInNumber
    }
}
