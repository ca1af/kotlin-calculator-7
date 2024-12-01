package calculator.delimiter

interface Delimiter {
    fun extractContents(input: String): List<Int>
    fun applicable(input: String): Boolean
    fun getInstance(input: String): Delimiter
}
