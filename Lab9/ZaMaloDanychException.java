public class ZaMaloDanychException extends Exception
{
	protected int data = 0;

	public ZaMaloDanychException() {}

	public ZaMaloDanychException(int data)
	{
		this.data = data;
	}

	public String getMessage()
	{
		return "n=" + data;
	}
}