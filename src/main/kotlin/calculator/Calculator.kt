package calculator

import calculator.delimiter.Delimiter

class Calculator {
    fun calculate(given: String, delimiter: Delimiter): Int {
        return delimiter.extractContents(given).sum()
    }
}
