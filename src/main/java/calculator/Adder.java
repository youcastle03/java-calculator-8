package calculator;

import java.util.List;

public class Adder {

    public int addNum(List<Integer> numbers) {
        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
