package calculator.delimiter

class DefaultDelimiter : AbstractDelimiter(){
    companion object {
        val DELIMITER = "[,;]".toRegex()
    }

    override fun split(given: String): List<String> {
        return given.split(DELIMITER)
    }
}
