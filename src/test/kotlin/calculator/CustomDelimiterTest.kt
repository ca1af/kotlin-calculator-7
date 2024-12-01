package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CustomDelimiterTest {
    @DisplayName("커스텀 구분자로 문자열을 분리 가능하다")
    @Test
    fun customDelimiterShouldCalculateResult() {
        val customDelimiter = CustomDelimiter()
        val result = customDelimiter.split("//;\\n1;2;3")
        Assertions.assertThat(result).containsExactly("1", "2", "3")
    }
}
