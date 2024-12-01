package calculator

class Calculator {
    companion object {
        val DELIMITER = "[,;]".toRegex()
    }

    fun calculate(given: String): Int {
        validate(given)
        val split = given.split(DELIMITER)
        validate(split)
        return split.sumOf { it.toInt() }
    }

    private fun validate(split: List<String>) {
        require(split.all { it.toIntOrNull() != null }) {
            GlobalException.INTEGER_VALUE_NEEDED.message
        }

        require(split.all { it.toInt() > 0 }) {
            GlobalException.NEGATIVE_INTEGER_NOT_ALLOWED.message
        }
    }

    private fun validate(given: String) {
        require(given.isNotBlank()) {GlobalException.BLANK_NOT_ALLOWED.message}
    }
}
