package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CalculatorControllerTest {
    @DisplayName("기본 구분자 계산")
    @Test
    fun calculateDefault() {
        val calculatorController = CalculatorController()
        val result = calculatorController.calculate("1,2,3")
        Assertions.assertThat(result).isEqualTo(6)
    }

    @DisplayName("커스텀 구분자 계산")
    @Test
    fun calculateCustom() {
        val calculatorController = CalculatorController()
        val result = calculatorController.calculate("//j\\n1j2j3")
        Assertions.assertThat(result).isEqualTo(6)
    }
}
