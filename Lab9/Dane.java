public class Dane
{
	protected int data;

	public Dane(int data)
	{
		this.data = data;
	}

	public int get()
	{
		return data;
	}

	public void set(int d)
	{
		data = d;
	}

	public int wynik(int w)
			throws ZaMaloDanychException, UjemnyParametrException
	{
		if (w > data)
			throw new ZaMaloDanychException(data);
		else if (w < 0)
			throw new UjemnyParametrException();
		return w;
	}

	public void innyWynik(int w)
			throws RuntimeException
	{
		ZaMaloDanychException e = new ZaMaloDanychException(data);
		throw new RuntimeException("ZaMaloDanychException: " + e.getMessage(), e);
	}

	public Object clone()
	{
		return new Dane(data);
	}

	public int hashCode()
	{
		return Integer.valueOf(data).hashCode();
	}

	public String toString()
	{
		return String.valueOf(data);
	}

	public boolean equals(Object anObject)
	{
		return anObject instanceof Dane && data == ((Dane) anObject).get();
	}
}