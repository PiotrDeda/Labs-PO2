public class Main
{
	public static void main(String[] args)
	{
		Ksiazka k1 = new Ksiazka(3, "Test");
		Ksiazka k2 = new Ksiazka(1, "Test2");
		Ksiazka k3 = new Ksiazka(2, "Test3");
		Ksiazka k4 = new Ksiazka(13, "Test4");
		Ksiazka k5 = new Ksiazka(12, "Test5");
		Ksiazka k6 = new Ksiazka(14, "Test6");
		System.out.println("Book id: " + k1.getId());
		System.out.println("Book title: " + k1.getTitle());
		System.out.println("Full book: " + k1);
		System.out.println("Book count: " + k1.getCount());

		Biblioteka b = new Biblioteka();
		b.dodaj(k1);
		b.dodaj(k2);
		b.dodaj(k3);
		b.dodaj(k4);
		b.dodaj(k5);
		b.dodaj(k6);
		b.rysuj();

		System.out.println(b.wyszukajID(12));
		System.out.println(b.wyszukajTytul("Test3"));
		System.out.println(b.wyszukajID(20));
		System.out.println(b.wyszukajTytul("Brak"));
	}
}