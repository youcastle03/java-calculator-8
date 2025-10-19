package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Parser {
    private final Validator validator;

    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public Parser(Validator validator) {
        this.validator = validator;
    }

    public List<Integer> parseNum(String data){
        if(data == null || data.isBlank()){
            return List.of(0);
        }
        String delimitersRegex = DEFAULT_DELIMITERS;
        String numberExpression = data;

        if (data.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            String[] splitString = data.split(CUSTOM_DELIMITER_SUFFIX);
            if(splitString.length < 2){
                throw new IllegalArgumentException("올바르지 않은 구분자를 입력하셨습니다.");
            }
            String customDelimiter = splitString[0].substring(CUSTOM_DELIMITER_PREFIX.length());
            numberExpression = splitString[1];
            delimitersRegex = DEFAULT_DELIMITERS + "|" + Pattern.quote(customDelimiter);
        }

        String[] numbers = numberExpression.split(delimitersRegex);

        return Arrays.stream(numbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
