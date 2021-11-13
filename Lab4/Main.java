import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		BufferedReader f;
		try
		{
			f = new BufferedReader(new FileReader(args[0]));
		} catch (Throwable e)
		{
			System.out.println("Nie mozna wczytac pliku");
			return;
		}

		Object[] linesObj = f.lines().toArray();
		String[] lines = new String[linesObj.length];
		for (int i = 0; i < lines.length; i++)
			lines[i] = linesObj[i].toString();

		System.out.println(lines[0]);
		System.out.println(lines[1]);
		System.out.println(lines[2]);
		System.out.println(lines[lines.length - 3]);
		System.out.println(lines[lines.length - 2]);
		System.out.println(lines[lines.length - 1]);
		System.out.println("\n####################\n");

		String regex = "[\\s,./;?!:\"()“”‘]+";
		int wordCount = 0;
		for (String line : lines)
		{
			List<String> wordsTemp = new ArrayList<>(Arrays.stream(line.split(regex)).toList());
			if (wordsTemp.size() == 1 && wordsTemp.get(0).length() == 0)
				continue;
			wordsTemp.removeIf(String::isBlank);
			wordCount += wordsTemp.size();
		}

		String[] words = new String[wordCount];
		int lastIndex = 0;
		for (String line : lines)
		{
			List<String> wordsTemp = new ArrayList<>(Arrays.stream(line.split(regex)).toList());
			if (wordsTemp.size() == 1 && wordsTemp.get(0).length() == 0)
				continue;
			wordsTemp.removeIf(String::isBlank);
			System.arraycopy(wordsTemp.toArray(new String[0]), 0, words, lastIndex, wordsTemp.size());
			lastIndex += wordsTemp.size();
		}

		System.out.println(words.length);

		String[] wordsCopy = Arrays.copyOf(words, words.length);

		long start = System.currentTimeMillis();
		Arrays.sort(words);
		long finish = System.currentTimeMillis();
		System.out.println("Non-parallel: " + (finish - start));

		start = System.currentTimeMillis();
		Arrays.parallelSort(wordsCopy);
		finish = System.currentTimeMillis();
		System.out.println("Parallel: " + (finish - start));

		Scanner scanner = new Scanner(System.in);
		System.out.print("Podaj numer slowa: ");
		String s = scanner.nextLine();
		System.out.println(wordsCopy[Integer.parseInt(s)]);

		System.out.print("Podaj N: ");
		s = scanner.nextLine();
		int N = Integer.parseInt(s);

		class WordCount
		{
			public final String word;
			public int count = 1;

			public WordCount(String _word) {word = _word;}

			public int getCount() {return count;}
		}

		List<WordCount> wordCounts = new ArrayList<>();

		for (String word : words)
		{
			boolean found = false;
			for (WordCount wc : wordCounts)
			{
				if (word.equals(wc.word))
				{
					wc.count++;
					found = true;
					break;
				}
			}
			if (!found)
				wordCounts.add(new WordCount(word));
		}

		wordCounts.sort(Comparator.comparing(WordCount::getCount).reversed());

		int n = 0;
		for (WordCount wc : wordCounts)
		{
			System.out.println(wc.word + " [" + wc.count + "]");
			if (++n == N) break;
		}
	}
}