package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {

    private Parser parser;

    @BeforeEach
    void setUp() {
        parser = new Parser(new Validator());
    }

    @Test
    @DisplayName("빈 문자열 입력시 빈 리스트 반환 테스트")
    void parseEmptyListTest() {
        assertThat(List.of(0)).isEqualTo(parser.parseNum(""));
    }

    @Test
    @DisplayName("기본 구분자 테스트")
    void defaultDelimitersTest() {
        assertThat(List.of(1,2,3)).isEqualTo(parser.parseNum("1,2:3"));
        assertThat(List.of(1,2,3,4)).isEqualTo(parser.parseNum("1:2,3:4"));
    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void customDelimiterTest() {
        assertThat(List.of(1,2,3)).isEqualTo(parser.parseNum("//;\\n1;2;3"));
        assertThat(List.of(1,2,3,4)).isEqualTo(parser.parseNum("//;\\n1;2:3,4"));
    }

    @Test
    @DisplayName("예외 테스트")
    void exceptionTest(){
        assertThrows(IllegalArgumentException.class, () -> parser.parseNum("1,a"));
        assertThrows(IllegalArgumentException.class, () -> parser.parseNum("-1,2"));
    }
}
