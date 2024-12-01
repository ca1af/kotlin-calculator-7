package calculator

import calculator.delimiter.Delimiter

class Calculator {
    fun calculate(input: String, delimiter: Delimiter): Int {
        return delimiter.extractContents(input).sum()
    }
}
