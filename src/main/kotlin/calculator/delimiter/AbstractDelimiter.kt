package calculator.delimiter

import calculator.GlobalException

abstract class AbstractDelimiter :Delimiter {
    private fun validate(input: String){
        require(input.isNotBlank()) { GlobalException.BLANK_NOT_ALLOWED.message}
    }

    private fun validate(contents: List<String>) {
        require(contents.all { it.toIntOrNull() != null }) {
            GlobalException.INTEGER_VALUE_NEEDED.message
        }

        require(contents.all { it.toInt() > 0 }) {
            GlobalException.NEGATIVE_INTEGER_NOT_ALLOWED.message
        }
    }

    override fun extractContents(given: String): List<Int> {
        validate(given)
        val contentString = split(given)
        validate(contentString)
        return contentString.map { it.toInt() }
    }
}
