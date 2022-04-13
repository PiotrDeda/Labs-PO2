public class Zaglowiec extends Statek implements Pasazerski
{
	protected final Pasazerski.Bilet ticket = new Pasazerski.Bilet();

	public Zaglowiec()
	{
		super("Zaglowiec");
	}

	public void ustawCeneBiletu(int newPrice)
	{
		ticket.ustawCene(newPrice);
	}

	public Pasazerski.Bilet bilet()
	{
		return ticket;
	}
}