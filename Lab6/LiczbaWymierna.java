public class LiczbaWymierna extends Liczba
{
	private final int l;
	private final int m;

	public LiczbaWymierna(int _l, int _m)
	{
		l = _l;
		m = _m;
	}

	public double toDouble()
	{
		return (double) l / m;
	}

	public String toString()
	{
		return Double.toString(toDouble());
	}
}