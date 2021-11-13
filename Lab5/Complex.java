public class Complex
{
	private double a = 0;
	private double b = 0;

	public Complex() {}

	public Complex(double _a)
	{
		a = _a;
	}

	public Complex(double _a, double _b)
	{
		a = _a;
		b = _b;
	}

	public static Complex Negate(Complex c)
	{
		return new Complex(-c.getRe(), -c.getIm());
	}

	public static Complex Add(Complex a, Complex b)
	{
		return new Complex(a.getRe() + b.getRe(), a.getIm() + b.getIm());
	}

	public static Complex Add(Complex a, double b)
	{
		return Add(a, new Complex(b));
	}

	public static Complex Add(double a, Complex b)
	{
		return Add(new Complex(a), b);
	}

	public static Complex Subtract(Complex a, Complex b)
	{
		return Add(a, Negate(b));
	}

	public static Complex Subtract(Complex a, double b)
	{
		return Subtract(a, new Complex(b));
	}

	public static Complex Subtract(double a, Complex b)
	{
		return Subtract(new Complex(a), b);
	}

	public static Complex Multiply(Complex a, Complex b)
	{
		double re = a.getRe() * b.getRe() - a.getIm() * b.getIm();
		double im = a.getRe() * b.getIm() + a.getIm() * b.getRe();
		return new Complex(re, im);
	}

	public static Complex Multiply(Complex a, double b)
	{
		return Multiply(a, new Complex(b));
	}

	public static Complex Multiply(double a, Complex b)
	{
		return Multiply(new Complex(a), b);
	}

	public static Complex Divide(Complex a, Complex b)
	{
		double div = b.getRe() * b.getRe() + b.getIm() * b.getIm();
		double re = (a.getRe() * b.getRe() + a.getIm() * b.getIm()) / div;
		double im = (a.getIm() * b.getRe() - a.getRe() * b.getIm()) / div;
		return new Complex(re, im);
	}

	public static Complex Divide(Complex a, double b)
	{
		return Divide(a, new Complex(b));
	}

	public static Complex Divide(double a, Complex b)
	{
		return Divide(new Complex(a), b);
	}

	public String toString()
	{
		if (b >= 0)
			return a + "+" + b + "i";
		else
			return a + "" + b + "i";
	}

	public void set(double _a, double _b)
	{
		a = _a;
		b = _b;
	}

	public double getRe()
	{
		return a;
	}

	public void setRe(double _a)
	{
		a = _a;
	}

	public double getIm()
	{
		return b;
	}

	public void setIm(double _b)
	{
		b = _b;
	}
}