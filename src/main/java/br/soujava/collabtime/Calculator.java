package br.soujava.collabtime;

import java.util.Objects;

public class Calculator {

    public static void main(String[] args) {

        // (((1.0+1.0)*2.0)/4.0)
        var expression =
                valueOf(1)
                .sum(valueOf(3))
                .subtract(valueOf(2))
                .multiply(valueOf(2))
                .divide(valueOf(4));

        System.out.println("%s = %s".formatted(asText(expression), evaluate(expression)));

    }

    static String asText(Expr expr) {
        return switch (expr) {
            case null -> "";
            case Value c -> String.valueOf(c.value());
            case Addition a -> "(%s+%s)".formatted(asText(a.arg1()), asText(a.arg2()));
            case Subtraction(Expr a1, Expr a2) -> "(%s-%s)".formatted(asText(a1), asText(a2));
            case Multiplication m -> "(%s*%s)".formatted(asText(m.arg1()), asText(m.arg2()));
            case Division(Expr n1, Expr n2) -> "(%s/%s)".formatted(asText(n1), asText(n2));
        };
    }

    static double evaluate(Expr expr) {
        Objects.requireNonNull(expr, "expr is required");
        return switch (expr) {
            case Value(double num) -> num;
            case Addition(Expr a1, Expr a2) -> evaluate(a1) + evaluate(a2);
            case Subtraction(Expr n1, Expr n2) -> evaluate(n1) - evaluate(n2);
            case Multiplication m -> evaluate(m.arg1()) * evaluate(m.arg2());
            case Division(Expr n1, Expr n2) -> evaluate(n1) / evaluate(n2);
        };
    }

    static Value valueOf(double value) {
        return new Value(value);
    }

    sealed static interface Expr permits
            Value,
            Addition,
            Subtraction,
            Multiplication,
            Division {

        default Addition sum(Expr expr) {
            return new Addition(this, expr);
        }

        default Subtraction subtract(Expr expr) {
            return new Subtraction(this, expr);
        }

        default Multiplication multiply(Expr expr) {
            return new Multiplication(this, expr);
        }

        default Division divide(Expr expr) {
            return new Division(this, expr);
        }
    }

    static record Value(double value) implements Expr {

        static Value of(double number) {
            return new Value(number);
        }

    }

    static record Addition(Expr arg1, Expr arg2) implements Expr {
    }

    static record Subtraction(Expr arg1, Expr arg2) implements Expr {
    }

    static record Multiplication(Expr arg1, Expr arg2) implements Expr {
    }

    static record Division(Expr arg1, Expr arg2) implements Expr {
    }

}
