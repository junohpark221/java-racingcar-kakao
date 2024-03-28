package calculator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private final List<String> delimiterSet;
    private static final Pattern pattern = Pattern.compile("//(.)\\n*");

    public Delimiter() {
        delimiterSet = new ArrayList<>();
        delimiterSet.add(",");
        delimiterSet.add(";");
    }

    public String customExpression(String expression) {
        return checkCustomDelimiter(expression);
    }

    public void add(String delimiter) {
        delimiterSet.add(delimiter);
    }

    public String getDelimiter() {
        return "[" + String.join("", delimiterSet) + "]";
    }

    public boolean contains(String token) {
        return delimiterSet.contains(token);
    }

    private String checkCustomDelimiter(String expression) {
        Matcher m = pattern.matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiterSet.add(customDelimiter);
            return expression.substring(5);
        }

        return expression;
    }
}
