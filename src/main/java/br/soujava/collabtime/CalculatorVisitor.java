package br.soujava.collabtime;

public class CalculatorVisitor extends  ExprBaseVisitor<Calculator.Expr> implements  ExprVisitor<Calculator.Expr> {
    @Override
    public Calculator.Expr visitTypeInt(ExprParser.TypeIntContext ctx) {
        double value = Double.valueOf( ctx.getChild(0).getText());
        return Calculator.valueOf(value);
    }

    @Override
    public Calculator.Expr visitTypeSum(ExprParser.TypeSumContext ctx) {
        Calculator.Expr lvalue = ctx.getChild(0).accept(this);
        Calculator.Expr rvalue = ctx.getChild(2).accept(this);
        return lvalue.sum(rvalue);
    }

    @Override
    public Calculator.Expr visitTypeSub(ExprParser.TypeSubContext ctx) {
        Calculator.Expr lvalue = ctx.getChild(0).accept(this);
        Calculator.Expr rvalue = ctx.getChild(2).accept(this);
        return lvalue.subtract(rvalue);
    }


    @Override
    public Calculator.Expr visitTypeMul(ExprParser.TypeMulContext ctx) {
        Calculator.Expr lvalue = ctx.getChild(0).accept(this);
        Calculator.Expr rvalue = ctx.getChild(2).accept(this);
        return lvalue.multiply(rvalue);
    }

    @Override
    public Calculator.Expr visitTypeDiv(ExprParser.TypeDivContext ctx) {
        Calculator.Expr lvalue = ctx.getChild(0).accept(this);
        Calculator.Expr rvalue = ctx.getChild(2).accept(this);
        return lvalue.divide(rvalue);
    }

    @Override
    public Calculator.Expr visitTypeRec(ExprParser.TypeRecContext ctx) {
        Calculator.Expr lvalue = ctx.getChild(1).accept(this);
        return lvalue;
    }

    @Override
    public Calculator.Expr visitProg(ExprParser.ProgContext ctx) {
        Calculator.Expr lvalue = ctx.getChild(0).accept(this);
        return lvalue;
    }
}
