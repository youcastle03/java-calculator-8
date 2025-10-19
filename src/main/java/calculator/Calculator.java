package calculator;

import java.util.List;

public class Calculator {

    private final InputHandler in;
    private final OutputHandler out;
    private final Parser parser;
    private final Adder adder;

    public Calculator(InputHandler in, OutputHandler out, Parser parser, Adder adder) {
        this.in = in;
        this.out = out;
        this.parser = parser;
        this.adder = adder;
    }

    public void run(){
        String expression = in.readLine();
        List<Integer> numbers = parser.parseNum(expression);
        int result = adder.addNum(numbers);
        out.printResult(result);
    }
}
