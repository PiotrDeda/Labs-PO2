/**
 * Klasa przechowujaca dowolna ilosc kont bankowych.
 *
 * @author Piotr Deda
 */
public class Bank
{
	private NodeKonto root;

	public void utworzKonto(String id)
	{
		if (root == null)
		{
			root = new NodeKonto(id);
			return;
		}

		NodeKonto node = root;
		while (node.next != null)
			node = node.next;
		node.next = new NodeKonto(id);
	}

	public void wplataNaKonto(String id, Kwota k)
	{
		if (root == null)
		{
			System.out.println("Nie znaleziono konta! [root null]");
			return;
		}

		NodeKonto node = root;
		while (node.next != null)
		{
			if (node.konto.getId().equals(id))
			{
				node.konto.dodajKwote(k);
				return;
			}
			node = node.next;
		}
		if (node.konto.getId().equals(id))
			node.konto.dodajKwote(k);
		else
			System.out.println("Nie znaleziono konta!");
	}

	public void wyplataZKonta(String id, Kwota k)
	{
		if (root == null)
		{
			System.out.println("Nie znaleziono konta! [root null]");
			return;
		}

		NodeKonto node = root;
		while (node.next != null)
		{
			if (node.konto.getId().equals(id))
			{
				node.konto.odejmijKwote(k);
				return;
			}
			node = node.next;
		}
		if (node.konto.getId().equals(id))
			node.konto.odejmijKwote(k);
		else
			System.out.println("Nie znaleziono konta!");
	}

	public Kwota stanKonta(String id)
	{
		if (root == null)
			return null;

		NodeKonto node = root;
		while (node.next != null)
		{
			if (node.konto.getId().equals(id))
				return node.konto.getStan();
			node = node.next;
		}
		if (node.konto.getId().equals(id))
			return node.konto.getStan();
		return null;
	}

	public String toString()
	{
		if (root == null)
			return "";

		var str = new StringBuilder();
		NodeKonto node = root;
		while (node.next != null)
		{
			str.append(node.konto).append(" ; ");
			node = node.next;
		}
		str.append(node.konto).append(" ; ");
		return str.toString();
	}

	private static class NodeKonto
	{
		public NodeKonto next;
		public Konto konto;

		public NodeKonto(String id)
		{
			konto = new Konto(id, new Kwota(0));
		}
	}
}
