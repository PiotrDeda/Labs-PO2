public class Biblioteka
{
	private Node root;

	public void dodaj(Ksiazka k)
	{
		Node previousNode = null;
		Node currentNode = root;
		Node newNode = new Node(k);

		while (currentNode != null)
		{
			if (k.getId() == currentNode.getId())
			{
				System.out.println("Book with id [" + k.getId() + "] already exists!");
				return;
			}

			previousNode = currentNode;

			if (k.getId() < currentNode.getId())
				currentNode = currentNode.left;
			else
				currentNode = currentNode.right;
		}

		newNode.parent = previousNode;

		if (previousNode == null)
		{
			root = newNode;
			return;
		}

		if (newNode.getId() < previousNode.getId())
			previousNode.left = newNode;
		else
			previousNode.right = newNode;
	}

	public void rysuj()
	{
		if (root != null)
			root.Print(0);
	}

	public Ksiazka wyszukajID(int id)
	{
		long start = System.nanoTime();
		Node currentNode = root;
		while (currentNode != null && currentNode.getId() != id)
			if (id < currentNode.getId())
				currentNode = currentNode.left;
			else
				currentNode = currentNode.right;
		long finish = System.nanoTime();
		long timeElapsed = finish - start;
		System.out.println("Elapsed time: " + timeElapsed);
		if (currentNode != null)
			return currentNode.book;
		else
			return null;
	}

	public Ksiazka wyszukajTytul(String wartosc)
	{
		long start = System.nanoTime();
		Node s = preorderSearch(root, wartosc);
		long finish = System.nanoTime();
		long timeElapsed = finish - start;
		System.out.println("Elapsed time: " + timeElapsed);
		if (s != null)
			return s.book;
		return null;
	}

	private Node preorderSearch(Node root, String wartosc)
	{
		if (root != null)
		{
			if (root.getTitle().equals(wartosc))
				return root;
			Node sl = preorderSearch(root.left, wartosc);
			if (sl != null)
				return sl;
			return preorderSearch(root.right, wartosc);
		}
		return null;
	}
}

class Node
{
	Node parent;
	Node left;
	Node right;
	Ksiazka book;

	public Node(Ksiazka _book)
	{
		book = _book;
	}

	public int getId()
	{
		return book.getId();
	}

	public String getTitle()
	{
		return book.getTitle();
	}

	public void Print(int level)
	{
		for (int i = 0; i < level; i++)
			System.out.print("\t");
		System.out.println("[" + getId() + "] " + getTitle());
		if (left != null)
			left.Print(level + 1);
		if (right != null)
			right.Print(level + 1);
	}
}