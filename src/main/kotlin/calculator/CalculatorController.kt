package calculator

import calculator.delimiter.DelimiterFactory
import camp.nextstep.edu.missionutils.Console

class CalculatorController {
    fun calculate() {
        println("덧셈할 문자열을 입력해 주세요.")
        val input = Console.readLine()
        val calculator = Calculator()
        val delimiterFactory = DelimiterFactory()
        val delimiter = delimiterFactory.getInstance(input)
        val result = calculator.calculate(input, delimiter)
        println("결과 : $result")
    }
}
