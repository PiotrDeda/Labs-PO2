public class Main
{
	public static void main(String[] args)
	{
		MyTable t = new MyTable(1000, 2);
		//t.Print();
		System.out.println("Avg = " + t.Average());
		System.out.println("Max = " + t.Max());
		System.out.println("Min = " + t.Min());
		t.Histogram(15);
	}
}

class MyTable
{
	private final double[] table;

	public MyTable(int n, int k)
	{
		table = new double[n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < k; j++)
				table[i] += Math.random();
	}

	public void Print()
	{
		for (double elem : table)
			System.out.println(elem);
	}

	public double Average()
	{
		double sum = 0.0;
		for (double elem : table)
			sum += elem;
		return sum / table.length;
	}

	public double Max()
	{
		double max = table[0];
		for (double elem : table)
			if (elem > max)
				max = elem;
		return max;
	}

	public double Min()
	{
		double min = table[0];
		for (double elem : table)
			if (elem < min)
				min = elem;
		return min;
	}

	public void Histogram(int binCount)
	{
		double[] binBounds = new double[binCount];
		double max = Max(), min = Min();
		double step = (max - min) / binCount;
		for (int i = 0; i < binCount; i++)
			binBounds[i] = min + step * (i + 1);

		int[] bins = new int[binCount];
		for (double elem : table)
			for (int i = 0; i < binCount; i++)
				if (elem <= binBounds[i])
				{
					bins[i]++;
					break;
				}
		for (double bin : bins)
		{
			for (int i = 0; i < bin; i++)
				System.out.print("*");
			System.out.println();
		}
	}
}

