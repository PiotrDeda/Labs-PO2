public class Pochodna
{
	private final UsedFunction f;
	private double h = 1e-6;

	public Pochodna(Funkcja f)
	{
		this.f = f.func;
	}

	public Pochodna(UsedFunction f)
	{
		this.f = f;
	}

	public void setH(double h)
	{
		this.h = h;
	}

	public double wartosc(int n, double x)
	{
		if (n == 1)
			return (f.f(x + h / 2) - f.f(x - h / 2)) / h;
		else if (n == 2)
			return (f.f(x + h) - 2 * f.f(x) + f.f(x - h)) / (h * h);
		else
			throw new BladPochodnej();
	}

	public double[] wartosc(int n, double... xs)
	{
		double[] result = new double[xs.length];
		int i = 0;
		for (double x : xs)
		{
			result[i++] = wartosc(n, x);
		}
		return result;
	}
}