public class Okret extends Statek implements UczestnikBitwy, Silnikowy
{
	protected int ammo = 100;
	protected boolean destroyed = false;
	protected int power = 0;

	public Okret(String _name)
	{
		super(_name);
	}

	public String toString()
	{
		if (destroyed)
			return "Okret[" + name + " - wrak]";
		return "Okret[" + name + "]";
	}

	public int amunicja()
	{
		return ammo;
	}

	public void strzelaj()
	{
		if (ammo > 0)
			ammo -= 1;
	}

	public void zatopiony()
	{
		destroyed = true;
		ammo = 0;
	}

	public void zwiekszMoc(int newPower)
	{
		power = newPower;
	}
}