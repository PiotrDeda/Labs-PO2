public class Lista
{
	Node root;

	public void add(Object obj)
	{
		if (root == null)
		{
			root = new Node(obj);
			return;
		}

		Node currNode = root;
		while (currNode.next != null)
		{
			currNode = currNode.next;
		}
		currNode.next = new Node(obj);
	}

	public int size()
	{
		int i = 0;
		Node currNode = root;
		while (currNode != null)
		{
			i += 1;
			currNode = currNode.next;
		}
		return i;
	}

	public Object firstElement()
	{
		return root.obj;
	}

	public Object lastElement()
	{
		Node currNode = root;
		while (currNode.next != null)
		{
			currNode = currNode.next;
		}
		return currNode.obj;
	}

	public Object elementAt(int index)
			throws IllegalArgumentException
	{
		if (index >= size())
			throw new IllegalArgumentException();

		Node currNode = root;
		for (int i = 0; i < index; i++)
			currNode = currNode.next;

		return currNode.obj;
	}

	public void removeAt(int index)
			throws IllegalArgumentException
	{
		if (index >= size())
			throw new IllegalArgumentException();

		if (index == 0)
		{
			root = root.next;
			return;
		}

		Node currNode = root;
		for (int i = 0; i < index - 1; i++)
			currNode = currNode.next;

		currNode.next = currNode.next.next;
	}

	public void removeAll()
	{
		root = null;
	}

	public String toString()
	{
		StringBuilder str = new StringBuilder();
		Node currNode = root;
		while (currNode != null)
		{
			str.append(currNode.obj.toString());
			if (currNode.next != null)
				str.append("\n");
			currNode = currNode.next;
		}
		return str.toString();
	}

	static class Node
	{
		Node next = null;
		Object obj;

		public Node(Object _obj) {obj = _obj;}
	}
}