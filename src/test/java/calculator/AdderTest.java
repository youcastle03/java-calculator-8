package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AdderTest {

    private Adder adder;

    @BeforeEach
    void setUp() {
        adder = new Adder();
    }

    @Test
    @DisplayName("합 계산 테스트")
    void addNumTest() {
        assertThat(6).isEqualTo(adder.addNum(List.of(1,2,3)));
        assertThat(55).isEqualTo(adder.addNum(List.of(1,2,3,4,5,6,7,8,9,10)));
    }
}
