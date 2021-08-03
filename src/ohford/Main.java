package ohford;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		run();
	}

	private static BigInteger fibonacci(int iterations, HashMap<Integer, BigInteger> previous)
	{
		previous.putIfAbsent(0, new BigInteger("0"));
		previous.putIfAbsent(1, new BigInteger("1"));

		for (int x = 2; x <= iterations; x++)
		{
			previous.put(x, previous.get(x - 1).add(previous.get(x - 2)));
		}

		return previous.get(iterations);
	}

	public static void run()
	{
		HashMap<Integer, BigInteger> previous = new HashMap<Integer, BigInteger>();
		Scanner kb = new Scanner(System.in);
		boolean goAgain = true;

		System.out.println("In mathematics, the Fibonacci numbers form a sequence, called the Fibonacci sequence,");
		System.out.println("such that each number is the sum of the two preceding ones,");
		System.out.println("starting from 0 and 1. Named after Leonardo Bonacci also known as Fibonacci (Wikipedia).\n");

		while (goAgain == true)
		{
			System.out.println("---------------------------------------------------------------------------------------\n");
			try
			{
				System.out.println("Enter how many iterations you would like to process: ");
				int iterations = kb.nextInt();
				BigInteger returnValue = new BigInteger(fibonacci(iterations, previous).toString());
				String returnValueString = NumberFormat.getNumberInstance(Locale.US).format(returnValue);
				System.out.println(returnValueString);
			} catch (Exception e)
			{
				System.out.println("ERROR: ENTER ONLY A WHOLE NUMBER.");
			} finally
			{
				boolean invalidInput = true;
				do
				{
					System.out.print("Would you like to go again? ");
					String repeatInput = kb.next();
					if (repeatInput.equalsIgnoreCase("yes") || repeatInput.equalsIgnoreCase("y"))
					{
						goAgain = true;
						invalidInput = false;
					} else if (repeatInput.equalsIgnoreCase("no") || repeatInput.equalsIgnoreCase("n"))
					{
						goAgain = false;
						invalidInput = false;
					} else
					{
						invalidInput = true;
						System.out.println("Enter a yes or no");
					}
				} while (invalidInput == true);

				System.out.println();
			}
		}
		kb.close();
	}

}
