package calculator.delimiter

interface Delimiter {
    fun split(given: String): List<String>
    fun extractContents(given: String): List<Int>
}
