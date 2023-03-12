import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Locale.setDefault(Locale.US);
		java.util.List<Punkt> pointList = new LinkedList<>();
		Scanner sc = new Scanner(System.in);

		int lineCount = 0;
		while (sc.hasNextLine())
		{
			lineCount++;
			Punkt point = Punkt.pointFromLine(sc.nextLine());
			if (point != null)
				pointList.add(point);
		}

		System.out.println("Read " + lineCount + " lines");
		System.out.println("Ignored " + (lineCount - pointList.size()) + " lines");
		System.out.println("Found " + pointList.size() + " points");
		System.out.println("Raw table:");
		for (Punkt point : pointList)
			System.out.println(point);

		//noinspection Java8ListSort
		Collections.sort(pointList, Comparator.comparingDouble(Punkt::x));
		System.out.println("\nSorted table:");
		for (Punkt point : pointList)
			System.out.println(point);

		System.out.println("\nMinimum x: " + Collections.min(pointList, Comparator.comparingDouble(Punkt::x)).x());
		System.out.println("Maximum x: " + Collections.max(pointList, Comparator.comparingDouble(Punkt::x)).x());
		System.out.println("Minimum y: " + Collections.min(pointList, Comparator.comparingDouble(Punkt::y)).y());
		System.out.println("Maximum y: " + Collections.max(pointList, Comparator.comparingDouble(Punkt::y)).y());

		// average x, average y
		double avgX = 0;
		double avgY = 0;
		for (Punkt p : pointList)
		{
			avgX += p.x();
			avgY += p.y();
		}
		avgX /= pointList.size();
		avgY /= pointList.size();

		// D
		double d = 0;
		for (Punkt p : pointList)
			d += (p.x() - avgX) * (p.x() - avgX);

		// a
		double a = 0;
		for (Punkt p : pointList)
			a += p.y() * (p.x() - avgX);
		a /= d;

		// b
		double b = avgY - a * avgX;

		// S
		double s = 0;
		for (Punkt p : pointList)
			s += (p.y() - a * p.x() - b) * (p.y() - a * p.x() - b);

		// s_y
		double sy = Math.sqrt(s / (pointList.size() - 2));

		// u(a)
		double ua = sy / Math.sqrt(d);

		// u(b)
		double ub = sy * Math.sqrt(1.0 / pointList.size() + avgX * avgX / d);

		System.out.println("\na = " + a);
		System.out.println("b = " + b);
		System.out.println("u(a) = " + ua);
		System.out.println("u(b) = " + ub);

		BufferedImage myPicture = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = myPicture.createGraphics();

		g.setColor(Color.BLACK);
		g.drawLine(0, 300, 600, 300);
		g.drawLine(300, 0, 300, 600);
		g.translate(300, 300);
		g.setStroke(new BasicStroke(2));

		g.setColor(Color.GREEN);
		drawEquation(g, -a / b, 1.0 / b);

		g.setColor(Color.RED);
		for (Punkt p : pointList)
			g.fillOval((int) p.x() - 4, (int) -p.y() - 4, 8, 8);

		try
		{
			File outputFile = new File("eq.png");
			ImageIO.write(myPicture, "png", outputFile);
		}
		catch (IOException e)
		{
			System.out.println("I/O error while saving eq.png");
		}
	}

	private static void drawEquation(Graphics2D g, double a, double b)
	{
		if (b == 0)
		{
			g.drawLine((int) (1.0 / a),
					-300,
					(int) (1.0 / a),
					300);
		}
		else
		{
			double line1a = -a / b;
			double line1b = -(double) 1 / b;
			g.drawLine(300,
					(int) (line1a * -300 + line1b),
					-300,
					(int) (line1a * 300 + line1b));
		}
	}
}
