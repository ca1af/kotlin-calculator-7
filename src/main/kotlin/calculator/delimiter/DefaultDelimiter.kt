package calculator.delimiter

class DefaultDelimiter : AbstractDelimiter(){
    companion object {
        val DELIMITER = "[,;]".toRegex()
    }

    override fun split(input: String): List<String> {
        return input.split(DELIMITER)
    }

    override fun applicable(input: String): Boolean {
        return input.contains(DELIMITER)
    }
}
