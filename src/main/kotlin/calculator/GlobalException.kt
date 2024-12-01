package calculator

enum class GlobalException(val message: String) {
    BLANK_NOT_ALLOWED("문자열은 공백이 되어서는 안됩니다."),
    INTEGER_VALUE_NEEDED("정수를 입력하라"),
    NEGATIVE_INTEGER_NOT_ALLOWED("음의 정수는 허용하지 않는다."),

}
