public class Ksiazka
{
	private static int count = 0;
	private final int id;
	private final String title;

	public Ksiazka(int _id, String _title)
	{
		id = _id;
		title = _title;
		count++;
	}

	public int getId()
	{
		return id;
	}

	public String getTitle()
	{
		return title;
	}

	public int getCount()
	{
		return count;
	}

	public String toString()
	{
		return "[" + id + "] " + title;
	}
}