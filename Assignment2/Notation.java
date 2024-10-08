/**
 * Primary Utility class used for all the evaluations/conversions
 * @author Inshaal Chaudhury
 */
public class Notation 
{
    /**
     * Empty Constructor
     */
    public Notation()
    {
    }

    /**
     * Evaluates a postfix expression from a string to a double
     * @param postfixExpr
     * @return
     * @throws InvalidNotationFormatException
     */
    public static double evaluatePostfixExpression(java.lang.String postfixExpr) throws InvalidNotationFormatException 
    {
    	MyStack<String> stack = new MyStack<>();
        double number = 0.0;
        char next;
        double firstOperand, secondOperand, result;

        for (int i = 0; i < postfixExpr.length(); i++) 
        {
            next = postfixExpr.charAt(i);
            switch (next) 
            {
                case ' ':
                    break;
                    
                case '0': 
                case '1': 
                case '2': 
                case '3': 
                case '4': 
                case '5': 
                case '6': 
                case '7': 
                case '8': 
                case '9':
                	stack.push(Character.toString(next));
                    break;
                    
                case '+':
                case '-':
                case '*':
                case '/':
                    try 
                    {
                    	firstOperand = Double.parseDouble(stack.pop());
                    	secondOperand = Double.parseDouble(stack.pop());
                    } 
                    catch (StackUnderflowException e) 
                    {
                        throw new InvalidNotationFormatException();
                    }
                    switch (next) 
                    {
                    	case '+':
                    		result = secondOperand + firstOperand;
                    		break;
                        case '-': 
                        	result = secondOperand - firstOperand;
                        	break;
                        case '*':
                        	result = secondOperand * firstOperand;
                        	break;
                        case '/':
                        	result = secondOperand / firstOperand;
                        	break;
                        default: 
                        	result = 0; 
                    }
                    stack.push(String.valueOf(result));
                    break;
                    
                default:
                    throw new InvalidNotationFormatException();
            }
        }
        
        try 
        {
        	number = Double.parseDouble(stack.pop());
        } 
        catch (StackUnderflowException e) 
        {
            throw new InvalidNotationFormatException();
        }

        if (!stack.isEmpty()) 
        {
            throw new InvalidNotationFormatException();
        }
        return number;
    }

    /**
     * Convert the Postfix expression to the Infix expression
     * @param postfix
     * @return String
     * @throws InvalidNotationFormatException
     * @throws StackUnderflowException 
     */
    public static java.lang.String convertPostfixToInfix(java.lang.String postfix) throws InvalidNotationFormatException, StackUnderflowException 
    {
        MyStack<String> stack = new MyStack<>();

        for (int i = 0; i < postfix.length(); i++) 
        {
            char next = postfix.charAt(i);
            
            if (Character.isDigit(next)) 
            {
                stack.push(String.valueOf(next));  
            } 
            else if (next == '+' || next == '-' || next == '*' || next == '/') 
            {
                if (stack.size() < 2)
                {
                    throw new InvalidNotationFormatException();
                }
                String secondOperand = stack.pop();
                String firstOperand = stack.pop();
                String infixExpression = "(" + firstOperand + next + secondOperand + ")";
                stack.push(infixExpression);  
            } 
            else 
            {
                throw new InvalidNotationFormatException();
            }
        }

        if (stack.isEmpty()) 
        {
            throw new InvalidNotationFormatException();
        }

        return stack.pop(); 
    }

    /**
     * Convert an infix expression into a postfix expression
     * @param infix
     * @return String
     * @throws InvalidNotationFormatException
     */
    public static java.lang.String convertInfixToPostfix(java.lang.String infix) throws InvalidNotationFormatException 
    {
        MyQueue<Character> solutionQueue = new MyQueue<>();
        MyStack<Character> stack = new MyStack<>();

        int openParenthesesCount = 0;  

        for (int i = 0; i < infix.length(); i++) 
        {
            char next = infix.charAt(i);
            System.out.println("Processing: " + next);

            switch (next) 
            {
                case ' ':
                    break;

                case '0': 
                case '1': 
                case '2': 
                case '3': 
                case '4':
                case '5': 
                case '6': 
                case '7': 
                case '8': 
                case '9':
                    try 
                    {
                    	solutionQueue.enqueue(next);
                    } 
                    catch (QueueOverflowException e) 
                    {
                        e.printStackTrace();
                    }
                    break;

                case '(':
                    openParenthesesCount++;  
                    try 
                    {
                    	stack.push(next);
                    } 
                    catch (StackOverflowException e) 
                    {
                        e.printStackTrace();
                    }
                    break;

                case '+': 
                case '-': 
                case '*': 
                case '/':
                    while (!stack.isEmpty()) 
                    {
                        try 
                        {
                            System.out.println("Current operator: " + next + ", Top of stack: " + stack.top());
                            if (((stack.top() == '*' || stack.top() == '/') && (next == '-' || next == '+')) ||
                                ((stack.top() == '-' || stack.top() == '+') && (next == '-' || next == '+')) ||
                                ((stack.top() == '*' || stack.top() == '/') && (next == '*' || next == '/'))) 
                            {
                            	solutionQueue.enqueue(stack.pop());
                            } 
                            else 
                            {
                                break;
                            }
                        } 
                        catch (StackUnderflowException e) 
                        {
                            e.printStackTrace();
                            throw new InvalidNotationFormatException("Invalid operator sequence");
                        } 
                        catch (QueueOverflowException e) 
                        {
                            e.printStackTrace();
                        }
                    }
                    try 
                    {
                    	stack.push(next);
                    } 
                    catch (StackOverflowException e) 
                    {
                        e.printStackTrace();
                    }
                    break;

                case ')':
                    if (openParenthesesCount == 0) 
                    {
                        throw new InvalidNotationFormatException("Mismatched parentheses");
                    }
                    openParenthesesCount--;  
                    try 
                    {
                        while (!stack.isEmpty()) 
                        {
                            char nextOperator = stack.pop();
                            if (nextOperator == '(') break; 
                            solutionQueue.enqueue(nextOperator);
                        }
                    } 
                    catch (StackUnderflowException e) 
                    {
                        e.printStackTrace();
                        throw new InvalidNotationFormatException("Mismatched parentheses");
                    } 
                    catch (QueueOverflowException e) 
                    {
                        e.printStackTrace();
                    }
                    break;

                default:
                    throw new InvalidNotationFormatException("Invalid character: " + next);
            }
        }

        if (openParenthesesCount > 0) 
        {
            throw new InvalidNotationFormatException("Unclosed parentheses");
        }

        while (!stack.isEmpty()) 
        {
            try 
            {
            	solutionQueue.enqueue(stack.pop());
            }
            catch (StackUnderflowException e) 
            {
                e.printStackTrace();
                throw new InvalidNotationFormatException("Invalid operator sequence");
            } 
            catch (QueueOverflowException e) 
            {
                e.printStackTrace();
            }
        }

        return solutionQueue.toString();
    }
}
