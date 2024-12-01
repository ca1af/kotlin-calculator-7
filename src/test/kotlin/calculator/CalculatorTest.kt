package calculator

import calculator.delimiter.CustomDelimiter
import calculator.delimiter.DefaultDelimiter
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CalculatorTest {
    @DisplayName("기본 구분자를 통한 계산에 성공한다")
    @Test
    fun calculateByDefaultDelimiter() {
        val defaultDelimiter = DefaultDelimiter()
        val calculator = Calculator()

        val result = calculator.calculate("1;2,3", defaultDelimiter)
        assertThat(result).isEqualTo(6)
    }

    @DisplayName("커스텀 구분자를 통한 계산에 성공한다")
    @Test
    fun calculateByCustomDelimiter() {
        val defaultDelimiter = CustomDelimiter()
        val calculator = Calculator()

        val result = calculator.calculate("//j\\n1j2j3", defaultDelimiter)
        assertThat(result).isEqualTo(6)
    }
}
