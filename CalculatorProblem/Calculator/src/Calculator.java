import java.util.*;
import java.util.Stack;
public class Calculator 
{
	private String operators[] = {"+", "-", "*", "/", "^"};
	private static final String INVALID_MESSAGE = "Invalid Command";
	List<String>listOperators = Arrays.asList(operators);
	
	/*
	* Process the calculator command assuming post-fix notation
	*    commands - a vector that is assured to be numbers (doubles) or valid operators
	*  returns a String that is either the computed number or the INVALID_MESSAGE constant
	*/
	public Stack<Double> data = new Stack<Double>();
	String processCommand(List<String> commands) {
		data.clear();
		for (String command : commands) {
			if (!listOperators.contains(command)) {
				data.push(Double.parseDouble(command));
				continue;
			}
			switch (command) {
				case "^":
					double sum = data.pop();
					if (data.isEmpty()) {
						return INVALID_MESSAGE;
					}
					data.push(Math.pow(data.pop(), sum));
					break;
				case "/":
					sum = data.pop();
					if (data.isEmpty()) {
						return INVALID_MESSAGE;
					}
					data.push(data.pop() / sum);

					break;
				case "*":
					sum = data.pop();
					if (data.isEmpty()) {
						return INVALID_MESSAGE;
					}
					data.push(sum * data.pop());
					break;
				case "-":
					sum = data.pop();
					if (data.isEmpty()) {
						return INVALID_MESSAGE;
					}
					data.push(data.pop() - sum);
					break;
				case "+":
					sum = data.pop();
					if (data.isEmpty()) {
						return INVALID_MESSAGE;
					}
					data.push(sum + data.pop());
					break;
			}
		}

//			if(commands.get(command).equals("^")){
//				double sum= data.pop();
//				if (data.isEmpty()){
//					return INVALID_MESSAGE;
//				}
//				data.push(Math.pow(data.pop(),sum));
//				continue;
//			}
//			if(commands.get(command).equals("/")){
//				double sum= data.pop();
//				if (data.isEmpty()){
//					return INVALID_MESSAGE;
//				}
//				data.push(data.pop()/sum);
//
//				continue;
//			}
//			if(commands.get(command).equals("*")){
//				double sum= data.pop();
//				if (data.isEmpty()){
//					return INVALID_MESSAGE;
//				}
//				data.push(sum * data.pop());
//				continue;
//			}
//			if(commands.get(command).equals("-")){
//				double sum= data.pop();
//				if (data.isEmpty()){
//					return INVALID_MESSAGE;
//				}
//				data.push(data.pop()- sum);
//
//				continue;
//			}
//			if(commands.get(command).equals("+")){
//				double sum= data.pop();
//				if (data.isEmpty()){
//					return INVALID_MESSAGE;
//				}
//				data.push(sum + data.pop());
//			}
//		}
		if (data.size() > 1) {
			return INVALID_MESSAGE;
		}
		return data.pop().toString();
	}
//
//	public String userInput(List<String > commands2) {
//		for (String command : commands2) {
//			if (!listOperators.contains(command)) {
//				data.push(Double.parseDouble(command));
//				continue;
//			}
//			switch (command) {
//				case "^":
//					double sum = data.pop();
//					if (data.isEmpty()) {
//						return INVALID_MESSAGE;
//					}
//					data.push(Math.pow(data.pop(), sum));
//					break;
//				case "/":
//					sum = data.pop();
//					if (data.isEmpty()) {
//						return INVALID_MESSAGE;
//					}
//					data.push(data.pop() / sum);
//
//					break;
//				case "*":
//					sum = data.pop();
//					if (data.isEmpty()) {
//						return INVALID_MESSAGE;
//					}
//					data.push(sum * data.pop());
//					break;
//				case "-":
//					sum = data.pop();
//					if (data.isEmpty()) {
//						return INVALID_MESSAGE;
//					}
//					data.push(data.pop() - sum);
//					break;
//				case "+":
//					sum = data.pop();
//					if (data.isEmpty()) {
//						return INVALID_MESSAGE;
//					}
//					data.push(sum + data.pop());
//					break;
//			}
//		}
//			if (data.size() > 1) {
//				return INVALID_MESSAGE;
//			}
//			return data.pop().toString();
//		}




			// Use a stack to process the incoming user command
			// The user entry has been broken into a vector of Strings.  Each String is assured to be
			//  1.) a number
			//  2.) a valid operator from the operators above
			// The inputs will NOT BE invalid themselves, but they may not amount to a valid command.
			// For instance, 2+2 would be blocked, but 2 + 2 could come through and would be invalid
			// since it is not in post-fix notation.
			//
			//  Your task is to process the command into a single numerical response and return that response
			//  as a String (no formatting required).  If the command is invalid, return the constant INVALID_MESSAGE
//		return INVALID_MESSAGE;



	//..................................................................................................................
	// Everything below here is test code, DO NOT MODIFY
	
	/*
	* The main method for the program, calls the test cases and then presents the user with the UI
	*/
	public static void main(String args[])
	{
		Calculator c = new Calculator();
	    c.testCalculator();
	    Scanner in = new Scanner(System.in);
	    
	    System.out.println("Welcome to the Calculator");
	    while (true)
	    {
	        System.out.print("calc>>");
	        String input = in.nextLine();
	        if ("quit".equals(input) || "q".equals(input))
	        {
	            break;
	        }
	
	        List<String> commands = c.parseInput(input);
	        if (commands.size() == 0)
	        {
	            System.out.println("Your command was invalid");
	            System.out.println("Enter a valid post-fix expression to process or quit to end the program");
	        }
	        else
	        {
	            System.out.println(c.processCommand(commands));
	        }
	    }
	}
	
	/*
	* Check if a String value is indeed a double
	*    value - the value to check
	*  returns true if the number is a double, false otherwise
	*/
	boolean isDouble(String value)
	{
	    try
	    {
	        double answer = Double.parseDouble(value);
	        return true;
	    } catch (Exception e) {}
	    return false;
	}
	
	/*
	* A tester for the processCommand() function
	* Many test cases taken from or validated using...
	* https://www.free-online-calculator-use.com/postfix-evaluator.html#
	*/
	void testCalculator()
	{
	    String[][] TEST_CASES =
	    { {"2 2 +","4.0"},
	      {"2 2 -","0.0"},
	      {"2 2 *","4.0"},
	      {"2 2 /","1.0"},
	      {"4 8 3 * +","28.0"},
	      {"4 8 + 3 *","36.0"},
	      {"78 30 0.5 28 8 + * - 6 / +","80.0"},
	      {"2.1 2 ^ 5.2 + 7.2 - 7.1 *","17.110999999999994"},
	      {"2 20 * 2 / 3 4 + 3 2 ^ * + 6 - 15 +","92.0"},
	      {"2 + 2", INVALID_MESSAGE},
	      {"2 2 2 +", INVALID_MESSAGE} };
	
	    boolean success = true;
	    for (String[] testCase : TEST_CASES)
	    {
	        String input = testCase[0];
	        String expected = testCase[1];
	        String actual = processCommand(parseInput(input));
	        if (! expected.equals(actual))
	        {
	            success = false;
	            System.err.printf("Failure for the input |%s| I expected to get (%s) but your code returned (%s)\n", input, expected, actual);
	        }
	    }
	    if (success)
	    {
	    	System.out.printf("All test cases passed!\n");
	    }
	
	}
	
	
	/*
	* Parse the input value into a series of numbers and valid operators
	*   input - any String that might be a calculator command
	*  returns a vector including a sequence of numbers and operators, or an empty vector 
	*         if the input included invalid elements
	*/
	List<String> parseInput(String input)
	{
	    List<String> commands = new ArrayList<String>();
	    StringTokenizer tokens = new StringTokenizer(input, " ");
	    CheckTokens:
	    while (tokens.hasMoreTokens())
	    {
	    	String token = tokens.nextToken();
	        try
	        {
	            boolean valid = true;
	            double answer = Double.parseDouble(token);
                commands.add(token);
                continue; // It's a number, move on to the next token
	        } catch (Exception e) {} // Ignore it and see if it an operator instead
	
	        for (String op : operators)
	        {
	            if (op.equals(token))
	            {
	                commands.add(op);
	                continue CheckTokens;
	            }
	        }
            commands.clear();
            break;
	    }
	    return commands;
	}
}