package calculator.delimiter

import calculator.GlobalException

class DelimiterFactory {
    private val delimiters: List<Delimiter> = listOf(
        CustomDelimiter(),
        DefaultDelimiter()
    )

    fun getInstance(input: String): Delimiter {
        return delimiters.find { it.applicable(input) }
            ?: throw IllegalArgumentException(GlobalException.INVALID_DELIMITER_TYPE.message)
    }
}
