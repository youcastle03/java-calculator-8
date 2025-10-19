package calculator;

public class Application {
    public static void main(String[] args) {
        OutputHandler out = new OutputHandler();
        InputHandler in = new InputHandler();
        Validator validator = new Validator();
        Parser parser = new Parser(validator);
        Adder adder = new Adder();
        Calculator calculator = new Calculator(in, out, parser, adder);
    }
}
