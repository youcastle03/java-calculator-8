package calculator;

public class Parser {
    private final Validator validator;

    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\\\n";

    public Parser(Validator validator) {
        this.validator = validator;
    }
}
