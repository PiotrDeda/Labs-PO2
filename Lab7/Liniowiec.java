public class Liniowiec extends Statek implements Pasazerski, Silnikowy
{
	protected final Pasazerski.Bilet ticket = new Pasazerski.Bilet();
	protected int power = 0;

	public Liniowiec(String _name)
	{
		super(_name);
	}

	public String toString()
	{
		return "Liniowiec[" + name + "]";
	}

	public void ustawCeneBiletu(int newPrice)
	{
		ticket.ustawCene(newPrice);
	}

	public Pasazerski.Bilet bilet()
	{
		return ticket;
	}

	public void zwiekszMoc(int newPower)
	{
		power = newPower;
	}
}