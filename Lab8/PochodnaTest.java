import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PochodnaTest
{
	final double delta = 1e-2;

	@Test
	public void testFunkcjaPochodna1()
	{
		Pochodna p = new Pochodna(Funkcja.SIN);
		assertEquals(0.7071067811865475, p.wartosc(1, Math.PI / 4), delta);
	}

	@Test
	public void testFunkcjaPochodna2()
	{
		Pochodna p = new Pochodna(Funkcja.SIN);
		assertEquals(-0.7071067811865475, p.wartosc(2, Math.PI / 4), delta);
	}

	@Test
	public void testFunkcjaPochodnaMultipleValues()
	{
		double[] expected = {1, 0.7071067811865475, 0, -1};
		Pochodna p = new Pochodna(Funkcja.SIN);
		double[] results = p.wartosc(1, 0, Math.PI / 4, Math.PI / 2, Math.PI);
		int i = 0;
		for (double result : results)
			assertEquals(expected[i++], result, delta);
	}

	@Test
	public void testFunkcjaPochodnaNTooLarge()
	{
		Pochodna p = new Pochodna(Funkcja.SIN);
		assertThrows(BladPochodnej.class, () -> p.wartosc(3, Math.PI / 4));
	}

	@Test
	public void testFunkcjaPochodnaCustomFunc()
	{
		Pochodna p = new Pochodna((x) -> (x * x));
		assertEquals(10, p.wartosc(1, 5), delta);
	}

	@Test
	public void testFunkcjaPochodnaRefToFunc()
	{

		Pochodna p = new Pochodna(TestingFunction::xsqr);
		assertEquals(10, p.wartosc(1, 5), delta);
	}
}

class TestingFunction
{
	static double xsqr(double x) {return x * x;}
}