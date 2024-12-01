package calculator.delimiter

import calculator.GlobalException

abstract class AbstractDelimiter :Delimiter {
    private fun validate(input: String){
        require(input.isNotBlank()) { GlobalException.BLANK_NOT_ALLOWED.message()}
    }

    internal abstract fun split(input: String) : List<String>

    private fun validate(contents: List<String>) {
        require(contents.all { it.toIntOrNull() != null }) {
            GlobalException.INTEGER_VALUE_NEEDED.message()
        }

        require(contents.all { it.toInt() > 0 }) {
            GlobalException.NEGATIVE_INTEGER_NOT_ALLOWED.message()
        }
    }

    override fun extractContents(input: String): List<Int> {
        validate(input)
        val contentString = split(input)
        validate(contentString)
        return contentString.map { it.toInt() }
    }

    override fun getInstance(input: String): Delimiter {
        if (applicable(input)){
            return this
        }

        throw IllegalArgumentException(GlobalException.INVALID_DELIMITER_TYPE.message())
    }
}
