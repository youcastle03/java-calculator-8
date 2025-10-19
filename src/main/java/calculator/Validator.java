package calculator;

import java.util.regex.Pattern;

public class Validator {

    private static final Pattern digits = Pattern.compile("[0-9]+");


    public void isNum(String str) {
        if(!digits.matcher(str).matches()) {
            throw new IllegalArgumentException("양수만 입력해 주세요");
        }
    }

    public void isPositive(int n) {
        if(n<=0){
            throw new IllegalArgumentException("양수만 입력해 주세요");
        }
    }

    public void isSingleChar(String custom) {
        if (custom == null || custom.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자가 비어 있습니다.");
        }
        if (custom.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 1문자여야 합니다: " + custom);
        }
    }
}
