package br.soujava.collabtime;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.Scanner;

public class ExprWork {
    public void repl() {
        Scanner sc= new Scanner(System.in);

        while (true) {
            System.out.println("Digite a expressao: ");
            String program = sc.nextLine();
            if ("exit".equals(program)) {
                break;
            }
            try {
                String output = process(program);
                System.out.println(output);
            }
            catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
            }
        }

    }

    public String process(String programa )
    {
        ExprLexer exprLexer = new ExprLexer(CharStreams.fromString(programa));
        CommonTokenStream tokens = new CommonTokenStream(exprLexer);
        ExprParser parser = new ExprParser(tokens);
        parser.setTrace(false);
        CalculatorVisitor calculatorVisitor =new CalculatorVisitor();
        Calculator.Expr expression = calculatorVisitor.visitProg(parser.prog());

        return "%s = %s".formatted(Calculator.asText(expression), Calculator.evaluate(expression));
    }
    public static void main(String[] args) {
        new ExprWork().repl();
    }
}