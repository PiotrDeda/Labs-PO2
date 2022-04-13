public enum Funkcja
{
	SIN(Math::sin),
	ARCSIN(Math::asin),
	LN(Math::log);

	public final UsedFunction func;

	Funkcja(UsedFunction func)
	{
		this.func = func;
	}

	double wartosc(double x)
	{
		double result = func.f(x);
		if (Double.isNaN(result))
			throw new BladFunkcji();
		return result;
	}
}

interface UsedFunction
{
	double f(double x);
}