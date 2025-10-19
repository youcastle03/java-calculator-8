package calculator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    @DisplayName("숫자만 허용 테스트")
    void isNumTest() {
        assertThrows(IllegalArgumentException.class, () -> validator.isNum("12a3"));
    }

    @Test
    @DisplayName("양수만 허용 테스트")
    void isPositiveTest() {
        assertThrows(IllegalArgumentException.class, () -> validator.isPositive(-1));
    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void isSingleCharTest() {
        assertDoesNotThrow(() -> validator.isSingleChar(";"));
        assertThrows(IllegalArgumentException.class, () -> validator.isSingleChar(";;"));
    }



}
