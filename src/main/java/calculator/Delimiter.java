package calculator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private static final Pattern pattern = Pattern.compile("//(.)\\n*");
    private final List<String> delimiterSet;

    public Delimiter() {
        delimiterSet = new ArrayList<>();
        delimiterSet.add(",");
        delimiterSet.add(";");
    }

    public String customizeExpression(String expression) {
        if(checkCustomDelimiter(expression)) {
            return expression.substring(5);
        }

        return expression;
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

    private boolean checkCustomDelimiter(String expression) {
        Matcher m = pattern.matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiterSet.add(customDelimiter);
            return true;
        }

        return false;
    }
}
