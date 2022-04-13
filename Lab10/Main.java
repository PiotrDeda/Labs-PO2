public class Main
{
	public static void main(String[] args)
	{
		System.out.println(Math.random());
		Matrix A1 = new Matrix(2);
		A1.set(0, 0, 1.0);
		A1.set(0, 1, 2.0);
		A1.set(1, 0, 3.0);
		A1.set(1, 1, 4.0);
		Matrix B1 = new Matrix(2);
		B1.set(0, 0, 5.0);
		B1.set(0, 1, 7.0);
		B1.set(1, 0, 6.0);
		B1.set(1, 1, 8.0);
		System.out.println(A1);
		System.out.println(B1);
		System.out.println(Matrix.multiply(A1, B1));

		MatrixDouble A2 = new MatrixDouble(2);
		A2.set(0, 0, 1.0);
		A2.set(0, 1, 2.0);
		A2.set(1, 0, 3.0);
		A2.set(1, 1, 4.0);
		MatrixDouble B2 = new MatrixDouble(2);
		B2.set(0, 0, 5.0);
		B2.set(0, 1, 7.0);
		B2.set(1, 0, 6.0);
		B2.set(1, 1, 8.0);
		System.out.println(A2);
		System.out.println(B2);
		System.out.println(MatrixDouble.multiply(A2, B2));

		MatrixGeneric<Double> A3 = new MatrixGeneric<Double>(2);
		A3.set(0, 0, 1.0);
		A3.set(0, 1, 2.0);
		A3.set(1, 0, 3.0);
		A3.set(1, 1, 4.0);
		MatrixGeneric<Double> B3 = new MatrixGeneric<Double>(2);
		B3.set(0, 0, 5.0);
		B3.set(0, 1, 7.0);
		B3.set(1, 0, 6.0);
		B3.set(1, 1, 8.0);
		System.out.println(A3);
		System.out.println(B3);
		System.out.println(MatrixGeneric.multiply(A3, B3));

		long start, finish, timeElapsed;
		System.out.println("Measuring time:");

		Matrix A4 = new Matrix(200);
		Matrix B4 = new Matrix(200);
		start = System.currentTimeMillis();
		Matrix.multiply(A4, B4);
		finish = System.currentTimeMillis();
		timeElapsed = finish - start;
		System.out.println("Matrix:\t\t" + timeElapsed / 1000.0);

		MatrixDouble A5 = new MatrixDouble(200);
		MatrixDouble B5 = new MatrixDouble(200);
		start = System.currentTimeMillis();
		MatrixDouble.multiply(A5, B5);
		finish = System.currentTimeMillis();
		timeElapsed = finish - start;
		System.out.println("MatrixDouble:\t" + timeElapsed / 1000.0);

		MatrixGeneric<Double> A6 = new MatrixGeneric<>(200);
		MatrixGeneric<Double> B6 = new MatrixGeneric<>(200);
		start = System.currentTimeMillis();
		MatrixGeneric.multiply(A6, B6);
		finish = System.currentTimeMillis();
		timeElapsed = finish - start;
		System.out.println("MatrixGeneric:\t" + timeElapsed / 1000.0);

		//Lab10A test = new Lab10A();
		Lab10A test = new Lab10A(1, "Test");
		W7X3E test2 = new W7X3E();
		java.lang.reflect.Method[] m = W7X3E.class.getDeclaredMethods();
		for (java.lang.reflect.Method method : m)
		{
			try
			{
				System.out.println("[" + method.getName() + "] " + method.getReturnType());
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
		try
		{
			Object r1 = m[1].invoke(test2, 53);
			Object r2 = m[0].invoke(test2, (char) r1);
			m[2].invoke(test2, (byte) r2);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		B9Q9R test3 = new B9Q9R();
		java.lang.reflect.Field[] f = B9Q9R.class.getFields();
		for (java.lang.reflect.Field field : f)
		{
			try
			{
				System.out.println("[" + field.getName() + "] " + field.get(test3));
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}
}