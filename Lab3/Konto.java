/**
 * Konto zawierajace identyfikator i przechowujace jakas kwote.
 *
 * @author Piotr Deda
 */
public class Konto
{
	private final String id;
	private Kwota kwota;

	public Konto(String _id, Kwota _kwota)
	{
		id = _id;
		setStan(_kwota);
	}

	public String getId()
	{
		return id;
	}

	public Kwota getStan()
	{
		return new Kwota(kwota);
	}

	public void setStan(Kwota k)
	{
		kwota = new Kwota(k);
	}

	public void dodajKwote(Kwota k)
	{
		kwota = Kwota.dodaj(kwota, k);
	}

	public void odejmijKwote(Kwota k)
	{
		kwota = Kwota.odejmij(kwota, k);
	}

	public String toString()
	{
		return "[" + id + "] " + kwota;
	}
}