import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Student Test for Notation Class
 * @author Inshaal Chaudhury
 */

public class NotationTest_STUDENT 
{
    public String basicInfix = "(2+3)";
    public String basicPostfix = "23+";
    public String complexInfix = "((4+5)*6)";
    public String complexPostfix = "45+6*";
    public String nestedInfix = "((2+3)*(4-5))";
    public String nestedPostfix = "23+45-*";
    
    public String invalidInfixExpression = "((2+3)*4";
    public String invalidPostfixExpression = "23+*";

    public double evalBasicPostfix = 5.0;
    public double evalComplexPostfix = 54.0;
    public double evalNestedPostfix = -5.0;

    @BeforeEach    
    public void setUp() throws Exception 
    {
    }

    @AfterEach
    public void tearDown() throws Exception 
    {
    }

    @Test
    public void testBasicConvertInfixToPostfix() throws InvalidNotationFormatException 
    {
        String postfixResult = Notation.convertInfixToPostfix(basicInfix);
        assertEquals(basicPostfix, postfixResult);
    }

    @Test
    public void testComplexConvertInfixToPostfix() throws InvalidNotationFormatException 
    {
        String postfixResult = Notation.convertInfixToPostfix(complexInfix);
        assertEquals(complexPostfix, postfixResult);
    }

    @Test
    public void testNestedConvertInfixToPostfix() throws InvalidNotationFormatException 
    {
        String postfixResult = Notation.convertInfixToPostfix(nestedInfix);
        assertEquals(nestedPostfix, postfixResult);
    }

    @Test
    public void testInvalidInfixExpression() 
    {
        try 
        {
            Notation.convertInfixToPostfix(invalidInfixExpression);
            assertTrue("This should have thrown an InvalidNotationFormatException", false);
        } 
        catch (InvalidNotationFormatException e) 
        {
            assertTrue("This should have thrown an InvalidNotationFormatException", true);
        }
    }

    @Test
    public void testBasicConvertPostfixToInfix() throws InvalidNotationFormatException, StackUnderflowException 
    {
        String infixResult = Notation.convertPostfixToInfix(basicPostfix);
        assertEquals(basicInfix, infixResult);
    }

    @Test
    public void testComplexConvertPostfixToInfix() throws InvalidNotationFormatException, StackUnderflowException 
    {
        String infixResult = Notation.convertPostfixToInfix(complexPostfix);
        assertEquals(complexInfix, infixResult);
    }

    @Test
    public void testNestedConvertPostfixToInfix() throws InvalidNotationFormatException, StackUnderflowException 
    {
        String infixResult = Notation.convertPostfixToInfix(nestedPostfix);
        assertEquals(nestedInfix, infixResult);
    }

    @Test
    public void testInvalidPostfixExpression() throws StackUnderflowException 
    {
        try 
        {
            Notation.convertPostfixToInfix(invalidPostfixExpression);
            assertTrue("This should have thrown an InvalidNotationFormatException", false);
        } 
        catch (InvalidNotationFormatException e) 
        {
            assertTrue("This should have thrown an InvalidNotationFormatException", true);
        }
    }

    @Test
    public void testBasicEvaluatePostfixExpression() throws InvalidNotationFormatException 
    {
        double result = Notation.evaluatePostfixExpression(basicPostfix);
        assertEquals(evalBasicPostfix, result, 0.001);
    }

    @Test
    public void testComplexEvaluatePostfixExpression() throws InvalidNotationFormatException 
    {
        double result = Notation.evaluatePostfixExpression(complexPostfix);
        assertEquals(evalComplexPostfix, result, 0.001);
    }

    @Test
    public void testNestedEvaluatePostfixExpression() throws InvalidNotationFormatException 
    {
        double result = Notation.evaluatePostfixExpression(nestedPostfix);
        assertEquals(evalNestedPostfix, result, 0.001);
    }

    @Test
    public void testInvalidPostfixExpressionA() 
    {
        try 
        {
            Notation.evaluatePostfixExpression(invalidPostfixExpression);
            assertTrue("This should have thrown an InvalidNotationFormatException", false);
        } 
        catch (InvalidNotationFormatException e) 
        {
            assertTrue("This should have thrown an InvalidNotationFormatException", true);
        }
    }
}
