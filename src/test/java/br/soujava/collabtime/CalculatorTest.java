package br.soujava.collabtime;

import org.junit.jupiter.api.Test;

import static br.soujava.collabtime.Calculator.asText;
import static br.soujava.collabtime.Calculator.evaluate;
import static br.soujava.collabtime.Calculator.valueOf;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class CalculatorTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        var expr = valueOf(1).sum(valueOf(1));
        String exprAsText = asText(expr);
        assertEquals("(1.0+1.0)", exprAsText);

        double evaluatedExpr = evaluate(expr);
        assertEquals(2.0, evaluatedExpr);
    }
}
