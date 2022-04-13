interface Pasazerski
{
	void ustawCeneBiletu(int newPrice);

	Pasazerski.Bilet bilet();

	class Bilet
	{
		int price = 0;

		public void ustawCene(int newPrice)
		{
			price = newPrice;
		}

		public int cena()
		{
			return price;
		}
	}
}