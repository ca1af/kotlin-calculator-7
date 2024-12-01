package calculator.delimiter

import calculator.GlobalException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DefaultDelimiterTest {
    @DisplayName("',' 나 ';' 를 이용한 문자열 계산에 성공한다")
    @Test
    fun calculate() {
        val input = "1,2"
        val calculator = DefaultDelimiter()
        val result = calculator.extractContents(input)
        assertThat(result).containsExactly(1, 2)
    }

    @DisplayName("공백인 문자열이 제공되면 예외가 발생한다.")
    @Test
    fun validateEmpty() {
        val calculator = DefaultDelimiter()
        assertThatThrownBy { calculator.extractContents("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(GlobalException.BLANK_NOT_ALLOWED.message())
    }

    @DisplayName("요소 중 정수가 아닌 값이 있으면 예외이다")
    @ParameterizedTest
    @ValueSource(strings = ["바보", "null", "1.5"])
    fun validateIsInteger(invalidInput: String){
        val calculator = DefaultDelimiter()
        assertThatThrownBy { calculator.extractContents("1;$invalidInput") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(GlobalException.INTEGER_VALUE_NEEDED.message())
    }

    @DisplayName("요소 중 양의 정수가 아닌 값이 있으면 예외이다")
    @ParameterizedTest
    @ValueSource(strings = ["-1", "-5", "-2"])
    fun validateIsPositiveInteger(invalidInput: String){
        val calculator = DefaultDelimiter()
        assertThatThrownBy { calculator.extractContents("1;$invalidInput") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(GlobalException.NEGATIVE_INTEGER_NOT_ALLOWED.message())
    }
}
