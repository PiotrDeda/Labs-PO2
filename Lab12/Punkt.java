import java.util.Scanner;

public record Punkt(double x, double y)
{

	public static Punkt pointFromLine(String line)
	{
		Scanner lineScanner = new Scanner(line);
		if (lineScanner.hasNextDouble())
		{
			double x = lineScanner.nextDouble();
			if (lineScanner.hasNextDouble())
			{
				double y = lineScanner.nextDouble();
				return new Punkt(x, y);
			}
		}
		return null;
	}


	@Override
	public String toString()
	{
		return x() + " " + y();
	}
}
