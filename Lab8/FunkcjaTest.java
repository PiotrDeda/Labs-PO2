import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FunkcjaTest
{
	final double delta = 1e-4;

	@Test
	public void testFunkcjaSin()
	{
		assertEquals(0.7071067811865475, Funkcja.SIN.wartosc(Math.PI / 4), delta);
	}

	@Test
	public void testFunkcjaArcsin()
	{
		assertEquals(0.9033391107665127, Funkcja.ARCSIN.wartosc(Math.PI / 4), delta);
	}

	@Test
	public void testFunkcjaLn()
	{
		assertEquals(-0.2415644752704905, Funkcja.LN.wartosc(Math.PI / 4), delta);
	}

	@Test
	public void testFunkcjaArcsinOutOfRange()
	{
		assertThrows(BladFunkcji.class, () -> Funkcja.ARCSIN.wartosc(2));
	}

	@Test
	public void testFunkcjaLnOutOfRange()
	{
		assertThrows(BladFunkcji.class, () -> Funkcja.LN.wartosc(-1));
	}
}