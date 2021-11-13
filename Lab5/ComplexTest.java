import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComplexTest
{
	final double delta = 1e-12;

	private void assertEqualsComplex(double expectedRe, double expectedIm, Complex testedC)
	{
		assertEquals(expectedRe, testedC.getRe(), delta);
		assertEquals(expectedIm, testedC.getIm(), delta);
	}

	// Setters

	@Test
	public void textComplexSetSimple()
	{
		Complex c = new Complex(1, 2);
		c.set(3, 4);
		assertEqualsComplex(3, 4, c);
	}

	@Test
	public void textComplexSetNegative()
	{
		Complex c = new Complex(1, 2);
		c.set(-3, -4);
		assertEqualsComplex(-3, -4, c);
	}

	@Test
	public void textComplexSetReSimple()
	{
		Complex c = new Complex(1, 2);
		c.setRe(3);
		assertEqualsComplex(3, 2, c);
	}

	@Test
	public void textComplexSetReNegative()
	{
		Complex c = new Complex(1, 2);
		c.setRe(-3);
		assertEqualsComplex(-3, 2, c);
	}

	@Test
	public void textComplexSetImSimple()
	{
		Complex c = new Complex(1, 2);
		c.setIm(4);
		assertEqualsComplex(1, 4, c);
	}

	@Test
	public void textComplexSetImNegative()
	{
		Complex c = new Complex(1, 2);
		c.setIm(-4);
		assertEqualsComplex(1, -4, c);
	}

	// Getters

	@Test
	public void textComplexGetReSimple()
	{
		Complex c = new Complex(1, 2);
		assertEquals(1, c.getRe(), delta);
	}

	@Test
	public void textComplexGetReNegative()
	{
		Complex c = new Complex(-1, 2);
		assertEquals(-1, c.getRe(), delta);
	}

	@Test
	public void textComplexGetImSimple()
	{
		Complex c = new Complex(1, 2);
		assertEquals(2, c.getIm(), delta);
	}

	@Test
	public void textComplexGetImNegative()
	{
		Complex c = new Complex(-1, -2);
		assertEquals(-2, c.getIm(), delta);
	}

	// Add

	@Test
	public void textComplexAddCC1()
	{
		Complex c1 = new Complex(3, 2);
		Complex c2 = new Complex(4, 6);
		Complex c = Complex.Add(c1, c2);
		assertEqualsComplex(7, 8, c);
	}

	@Test
	public void textComplexAddCC2()
	{
		Complex c1 = new Complex(-3, 2.15);
		Complex c2 = new Complex(4, -6.5);
		Complex c = Complex.Add(c1, c2);
		assertEqualsComplex(1, -4.35, c);
	}

	@Test
	public void textComplexAddCD1()
	{
		Complex c1 = new Complex(3, 2);
		Complex c = Complex.Add(c1, 5);
		assertEqualsComplex(8, 2, c);
	}

	@Test
	public void textComplexAddCD2()
	{
		Complex c1 = new Complex(3.5, -6);
		Complex c = Complex.Add(c1, 5.15);
		assertEqualsComplex(8.65, -6, c);
	}

	@Test
	public void textComplexAddDC1()
	{
		Complex c1 = new Complex(3, 2);
		Complex c = Complex.Add(5, c1);
		assertEqualsComplex(8, 2, c);
	}

	@Test
	public void textComplexAddDC2()
	{
		Complex c1 = new Complex(3.5, -6);
		Complex c = Complex.Add(5.15, c1);
		assertEqualsComplex(8.65, -6, c);
	}

	// Subtract

	@Test
	public void textComplexSubtractCC1()
	{
		Complex c1 = new Complex(4, 6);
		Complex c2 = new Complex(3, 2);
		Complex c = Complex.Subtract(c1, c2);
		assertEqualsComplex(1, 4, c);
	}

	@Test
	public void textComplexSubtractCC2()
	{
		Complex c1 = new Complex(-3, 2.15);
		Complex c2 = new Complex(4, -6.5);
		Complex c = Complex.Subtract(c1, c2);
		assertEqualsComplex(-7, 8.65, c);
	}

	@Test
	public void textComplexSubtractCD1()
	{
		Complex c1 = new Complex(3, 2);
		Complex c = Complex.Subtract(c1, 5);
		assertEqualsComplex(-2, 2, c);
	}

	@Test
	public void textComplexSubtractCD2()
	{
		Complex c1 = new Complex(3.5, -6);
		Complex c = Complex.Subtract(c1, 5.15);
		assertEqualsComplex(-1.65, -6, c);
	}

	@Test
	public void textComplexSubtractDC1()
	{
		Complex c1 = new Complex(3, 2);
		Complex c = Complex.Subtract(5, c1);
		assertEqualsComplex(2, -2, c);
	}

	@Test
	public void textComplexSubtractDC2()
	{
		Complex c1 = new Complex(3.5, -6);
		Complex c = Complex.Subtract(5.15, c1);
		assertEqualsComplex(1.65, 6, c);
	}

	// Multiply

	@Test
	public void textComplexMultiplyCC1()
	{
		Complex c1 = new Complex(3, 2);
		Complex c2 = new Complex(4, 6);
		Complex c = Complex.Multiply(c1, c2);
		assertEqualsComplex(0, 26, c);
	}

	@Test
	public void textComplexMultiplyCC2()
	{
		Complex c1 = new Complex(-3, 2.15);
		Complex c2 = new Complex(4, -6.5);
		Complex c = Complex.Multiply(c1, c2);
		assertEqualsComplex(1.975, 28.1, c);
	}

	@Test
	public void textComplexMultiplyCD1()
	{
		Complex c1 = new Complex(3, 2);
		Complex c = Complex.Multiply(c1, 5);
		assertEqualsComplex(15, 10, c);
	}

	@Test
	public void textComplexMultiplyCD2()
	{
		Complex c1 = new Complex(3.5, -6);
		Complex c = Complex.Multiply(c1, 5.15);
		assertEqualsComplex(18.025, -30.9, c);
	}

	@Test
	public void textComplexMultiplyDC1()
	{
		Complex c1 = new Complex(3, 2);
		Complex c = Complex.Multiply(5, c1);
		assertEqualsComplex(15, 10, c);
	}

	@Test
	public void textComplexMultiplyDC2()
	{
		Complex c1 = new Complex(3.5, -6);
		Complex c = Complex.Multiply(5.15, c1);
		assertEqualsComplex(18.025, -30.9, c);
	}

	// Divide

	@Test
	public void textComplexDivideCC1()
	{
		Complex c1 = new Complex(3, 2);
		Complex c2 = new Complex(4, 6);
		Complex c = Complex.Divide(c1, c2);
		assertEqualsComplex(0.4615384615384615, -0.1923076923076923, c);
	}

	@Test
	public void textComplexDivideCC2()
	{
		Complex c1 = new Complex(-3, 2);
		Complex c2 = new Complex(4, -6);
		Complex c = Complex.Divide(c1, c2);
		assertEqualsComplex(-0.4615384615384615, -0.1923076923076923, c);
	}

	@Test
	public void textComplexDivideCD1()
	{
		Complex c1 = new Complex(3, 2);
		Complex c = Complex.Divide(c1, 5);
		assertEqualsComplex(0.6, 0.4, c);
	}

	@Test
	public void textComplexDivideCD2()
	{
		Complex c1 = new Complex(3.5, -6);
		Complex c = Complex.Divide(c1, 5.15);
		assertEqualsComplex(0.6796116504854368, -1.1650485436893203, c);
	}

	@Test
	public void textComplexDivideDC1()
	{
		Complex c1 = new Complex(3, 2);
		Complex c = Complex.Divide(5, c1);
		assertEqualsComplex(1.1538461538461538, -0.7692307692307692, c);
	}

	@Test
	public void textComplexDivideDC2()
	{
		Complex c1 = new Complex(3.5, -6);
		Complex c = Complex.Divide(5.15, c1);
		assertEqualsComplex(0.3735751295336787, 0.6404145077720207, c);
	}
}