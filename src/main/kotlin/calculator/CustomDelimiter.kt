package calculator

class CustomDelimiter {
    companion object {
        const val STARTING_POINT = "//"
        const val ENDING_POINT = "\\n"
    }

    fun split(given: String): List<String> {
        require(given.startsWith(STARTING_POINT) && given.contains(ENDING_POINT)) {
            GlobalException.INVALID_CUSTOM_DELIMITER.message
        }
        val delimiter = extractDelimiter(given)
        val content = extractContent(given)
        return content.split(delimiter)
    }

    private fun extractContent(given: String): String {
        val content = given.substringAfter(ENDING_POINT)
        return content
    }

    private fun extractDelimiter(given: String): String {
        val delimiter = given.substringAfter(STARTING_POINT).substringBefore(ENDING_POINT)
        return delimiter
    }
}
