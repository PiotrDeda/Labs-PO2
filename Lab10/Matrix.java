public class Matrix
{
	protected final double[][] arr;
	protected final int size;

	public Matrix(int N)
	{
		size = N;
		arr = new double[N][N];
		for (int i = 0; i < getSize(); i++)
		{
			for (int j = 0; j < getSize(); j++)
			{
				arr[i][j] = Math.random();
			}
		}
	}

	public static Matrix multiply(Matrix A, Matrix B)
			throws IllegalArgumentException
	{
		int N = A.getSize();
		if (N != B.getSize())
			throw new IllegalArgumentException();
		Matrix result = new Matrix(N);
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				double val = 0;
				for (int k = 0; k < N; k++)
				{
					val += A.get(i, k) * B.get(k, j);
				}
				result.set(i, j, val);
			}
		}
		return result;
	}

	public double get(int i, int j)
	{
		return arr[i][j];
	}

	public void set(int i, int j, double value)
	{
		arr[i][j] = value;
	}

	public int getSize()
	{
		return size;
	}

	public String toString()
	{
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < getSize(); i++)
		{
			result.append("[");
			for (int j = 0; j < getSize(); j++)
			{
				result.append(get(i, j));
				result.append(" ");
			}
			result.append("\b]\n");
		}
		return result.toString();
	}
}