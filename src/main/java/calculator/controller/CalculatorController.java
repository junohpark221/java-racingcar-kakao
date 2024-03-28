package calculator.controller;

import calculator.Calculator;
import calculator.Delimiter;
import calculator.Splitter;
import calculator.Validator;
import calculator.view.CalculatorView;

import java.util.*;

public class CalculatorController {
    private Calculator calculator;
    private Validator validator;
    private Splitter splitter;
    private CalculatorView calculatorView;

    public CalculatorController() {
        calculator = new Calculator();
        validator = new Validator();
        splitter = new Splitter();
        calculatorView = new CalculatorView();
    }

    public void start() {
        Delimiter delimiter = new Delimiter();

        String expression = calculatorView.getExpression();

        expression = delimiter.customizeExpression(expression);
        validator.validate(expression, delimiter);

        List<Integer> numberList = splitter.split(expression, delimiter);

        int result = calculator.calculate(numberList);

        calculatorView.printResult(result);
    }
}
