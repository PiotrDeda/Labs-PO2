import java.util.Arrays;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("# LIST #");

		Lista testList = new Lista();

		testList.add(5);
		testList.add(3.4);
		testList.add(true);
		testList.add("test");
		System.out.println("[List]");
		System.out.println(testList);

		System.out.println("[Size] " + testList.size());

		Object first = testList.firstElement();
		System.out.println("[First] " + first);

		Object last = testList.lastElement();
		System.out.println("[Last] " + last);

		Object ielement = testList.elementAt(1);
		System.out.println("[At i=1] " + ielement);

		//Object outOfBoundElement = testList.elementAt(4);

		testList.removeAt(2);
		System.out.println("[List Removed At i=2]");
		System.out.println(testList);

		//testList.removeAt(4);

		testList.removeAll();
		System.out.println("[List Removed All]");
		System.out.println(testList);

		System.out.println("# NUMBER #");

		LiczbaWymierna real = new LiczbaWymierna(3, 4);
		System.out.println("[Real Number] " + real);

		LiczbaOdZeraDoJeden lim1 = new LiczbaOdZeraDoJeden(0.345);
		System.out.println("[Limited Number <0,1>] " + lim1);

		LiczbaOdZeraDoJeden lim2 = new LiczbaOdZeraDoJeden(250);
		System.out.println("[Limited Number >1] " + lim2);

		LiczbaOdZeraDoJeden lim3 = new LiczbaOdZeraDoJeden(-1000);
		System.out.println("[Limited Number <0] " + lim3);

		ListaLiczb numberList = new ListaLiczb();
		numberList.add(real);
		numberList.add(lim1);
		numberList.add(lim2);
		numberList.add(lim3);
		//numberList.add("test");
		System.out.println("[Number List]");
		System.out.println(numberList);

		Liczba smallest = (Liczba) numberList.smallestValue();
		System.out.println("[Smallest Number] " + smallest);

		Liczba largest = (Liczba) numberList.largestValue();
		System.out.println("[Largest Number] " + largest);

		double[] numberArray = numberList.toArray();
		System.out.println("[Array] " + Arrays.toString(numberArray));

		double avg = numberList.average();
		System.out.println("[Average] " + avg);

		numberList.sort();
		System.out.println("[Sorted List]");
		System.out.println(numberList);
	}
}