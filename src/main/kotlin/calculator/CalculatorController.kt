package calculator

import calculator.delimiter.DelimiterFactory

class CalculatorController {
    fun calculate(input: String): Int {
        val calculator = Calculator()
        val delimiterFactory = DelimiterFactory()
        val delimiter = delimiterFactory.getInstance(input)
        return calculator.calculate(input, delimiter)
    }
}
