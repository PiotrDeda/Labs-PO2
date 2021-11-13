/**
 * Klasa przechowujaca ilosc pieniedzy w zlotowkach i groszach.
 *
 * @author Piotr Deda
 */
public class Kwota
{
	private long kwota;

	/**
	 * @param totalGr Laczna kwota podana w groszach
	 */
	public Kwota(long totalGr)
	{
		kwota = totalGr;
	}

	/**
	 * @param zl Ilosc zlotowek w kwocie
	 * @param gr Ilosc groszy w kwocie
	 */
	public Kwota(long zl, long gr)
	{
		set(zl, gr);
	}

	/**
	 * @param k Kwota do skopiowania
	 */
	public Kwota(Kwota k)
	{
		kwota = 100 * k.getZl() + k.getGr();
	}

	/**
	 * Dodaje do siebie dwie kwoty.
	 *
	 * @param k1 Pierwsza dodawana kwota
	 * @param k2 Druga dodawana kwota
	 * @return Otrzymana kwota
	 */
	public static Kwota dodaj(Kwota k1, Kwota k2)
	{
		long newGr = 100 * (k1.getZl() + k2.getZl()) + k1.getGr() + k2.getGr();
		return new Kwota(newGr);
	}

	/**
	 * Odejmuje jedna kwote od drugiej.
	 *
	 * @param k1 Kwota od ktorej odejmujemy
	 * @param k2 Odejmowana kwota
	 * @return Otrzymana kwota
	 */
	public static Kwota odejmij(Kwota k1, Kwota k2)
	{
		long newGr = 100 * (k1.getZl() - k2.getZl()) + k1.getGr() - k2.getGr();
		return new Kwota(newGr);
	}

	/**
	 * Zwraca ilosc zlotowek w kwocie (nie uwzgledniajac groszy).
	 *
	 * @return Ilosc zlotowek w kwocie
	 */
	public long getZl()
	{
		return kwota / 100;
	}

	/**
	 * Zwraca ilosc groszy w kwocie (nie uwzgledniajac zlotowek).
	 *
	 * @return Ilosc groszy w kwocie
	 */
	public long getGr()
	{
		return kwota % 100;
	}

	/**
	 * Ustawia kwote na podana ilosc.
	 *
	 * @param zl Ilosc zlotowek do ustawienia
	 * @param gr Ilosc groszy do ustawienia
	 */
	public void set(long zl, long gr)
	{
		kwota = 100 * zl + gr;
	}

	public String toString()
	{
		return getZl() + "zl " + getGr() + "gr";
	}
}