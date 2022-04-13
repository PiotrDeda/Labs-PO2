import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixTest
{
	final double delta = 1e-12;

	@Test
	public void textMatrix()
	{
		Matrix A = new Matrix(2);
		A.set(0, 0, 1.0);
		A.set(0, 1, 2.0);
		A.set(1, 0, 3.0);
		A.set(1, 1, 4.0);
		Matrix B = new Matrix(2);
		B.set(0, 0, 5.0);
		B.set(0, 1, 7.0);
		B.set(1, 0, 6.0);
		B.set(1, 1, 8.0);
		Matrix result = Matrix.multiply(A, B);
		double[][] expected = {{17, 23}, {39, 53}};
		for (int i = 0; i < A.getSize(); i++)
		{
			for (int j = 0; j < A.getSize(); j++)
			{
				assertEquals(expected[i][j], result.get(i, j), delta);
			}
		}
	}

	@Test
	public void textMatrixDouble()
	{
		MatrixDouble A = new MatrixDouble(2);
		A.set(0, 0, 1.0);
		A.set(0, 1, 2.0);
		A.set(1, 0, 3.0);
		A.set(1, 1, 4.0);
		MatrixDouble B = new MatrixDouble(2);
		B.set(0, 0, 5.0);
		B.set(0, 1, 7.0);
		B.set(1, 0, 6.0);
		B.set(1, 1, 8.0);
		MatrixDouble result = MatrixDouble.multiply(A, B);
		double[][] expected = {{17, 23}, {39, 53}};
		for (int i = 0; i < A.getSize(); i++)
		{
			for (int j = 0; j < A.getSize(); j++)
			{
				assertEquals(expected[i][j], result.get(i, j), delta);
			}
		}
	}

	@Test
	public void textMatrixGeneric()
	{
		MatrixGeneric<Double> A = new MatrixGeneric<>(2);
		A.set(0, 0, 1.0);
		A.set(0, 1, 2.0);
		A.set(1, 0, 3.0);
		A.set(1, 1, 4.0);
		MatrixGeneric<Double> B = new MatrixGeneric<>(2);
		B.set(0, 0, 5.0);
		B.set(0, 1, 7.0);
		B.set(1, 0, 6.0);
		B.set(1, 1, 8.0);
		MatrixGeneric<?> result = MatrixGeneric.multiply(A, B);
		double[][] expected = {{17, 23}, {39, 53}};
		for (int i = 0; i < A.getSize(); i++)
		{
			for (int j = 0; j < A.getSize(); j++)
			{
				assertEquals(expected[i][j], result.get(i, j), delta);
			}
		}
	}
}