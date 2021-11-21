public class LiczbaOdZeraDoJeden extends Liczba
{
	private final double n;

	public LiczbaOdZeraDoJeden(double _n)
	{
		if (_n > 1)
			n = 1;
		else if (_n < 0)
			n = 0;
		else
			n = _n;
	}

	public double toDouble()
	{
		return n;
	}

	public String toString()
	{
		return Double.toString(toDouble());
	}
}