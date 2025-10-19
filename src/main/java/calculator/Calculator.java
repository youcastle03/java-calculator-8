package calculator;

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
}
