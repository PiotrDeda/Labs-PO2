public class ListaLiczb extends Lista
{
	public void add(Liczba obj)
	{
		super.add(obj);
	}

	public void add(Object obj)
			throws IllegalArgumentException
	{
		throw new IllegalArgumentException();
	}

	public Object smallestValue()
	{
		Node smallest = root;
		Node currNode = root;
		while (currNode.next != null)
		{
			if (((Liczba) currNode.next.obj).toDouble() < ((Liczba) smallest.obj).toDouble())
				smallest = currNode.next;
			currNode = currNode.next;
		}
		return smallest.obj;
	}

	public Object largestValue()
	{
		Node largest = root;
		Node currNode = root;
		while (currNode.next != null)
		{
			if (((Liczba) currNode.next.obj).toDouble() > ((Liczba) largest.obj).toDouble())
				largest = currNode.next;
			currNode = currNode.next;
		}
		return largest.obj;
	}

	public double[] toArray()
	{
		double[] result = new double[size()];
		Node currNode = root;
		int i = 0;
		while (currNode != null)
		{
			result[i] = ((Liczba) currNode.obj).toDouble();
			i += 1;
			currNode = currNode.next;
		}
		return result;
	}

	public double average()
	{
		double[] arr = toArray();
		double sum = 0;
		for (double n : arr)
			sum += n;
		return sum / size();
	}

	public void sort()
	{
		// sortowanie jeszcze niezrealizowane, może kiedyś do niego wrócę
	}
}