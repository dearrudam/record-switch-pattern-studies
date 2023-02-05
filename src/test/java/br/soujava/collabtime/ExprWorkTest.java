package br.soujava.collabtime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static br.soujava.collabtime.Calculator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class ExprWorkTest
{
    private static ExprWork exprWork;

    /**
     * Rigorous Test :-)
     */

    @BeforeAll
    public static void setup() {
        exprWork = new ExprWork();
    }
    @Test
    public void shouldAnswerOnePlusOne()
    {
        String exprAsText = exprWork.process("1+1");
        assertEquals("(1.0+1.0) = 2.0", exprAsText);
    }


    @Test
    public void shouldAnswerComplex1()
    {
        String exprAsText = exprWork.process("2+3*5");
        assertEquals("(2.0+(3.0*5.0)) = 17.0", exprAsText);
    }


    @Test
    public void shouldAnswerComplex2()
    {
        String exprAsText = exprWork.process("(2+3)*5");
        assertEquals("((2.0+3.0)*5.0) = 25.0", exprAsText);
    }

    @Test
    public void shouldAnswerComplex3()
    {
        String exprAsText = exprWork.process("(2.1+3.1)*5");
        assertEquals("((2.1+3.1)*5.0) = 26.0", exprAsText);
    }

}
