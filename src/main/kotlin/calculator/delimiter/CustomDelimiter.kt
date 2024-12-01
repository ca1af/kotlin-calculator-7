package calculator.delimiter

class CustomDelimiter : AbstractDelimiter() {
    companion object {
        const val STARTING_POINT = "//"
        const val ENDING_POINT = "\\n"
    }

    override fun applicable(input: String): Boolean {
        return input.startsWith(STARTING_POINT) && input.contains(ENDING_POINT)
    }

    override fun split(input: String): List<String> {
        val delimiter = extractDelimiter(input)
        val content = extractContent(input)
        return content.split(delimiter)
    }

    private fun extractContent(input: String): String {
        val content = input.substringAfter(ENDING_POINT)
        return content
    }

    private fun extractDelimiter(input: String): String {
        val delimiter = input.substringAfter(STARTING_POINT).substringBefore(ENDING_POINT)
        return delimiter
    }
}
