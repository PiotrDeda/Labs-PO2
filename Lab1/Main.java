import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main
{
	public static void main(String[] args)
	{
		EquationSet eq1 = new EquationSet(7, 2, 10, 3, 1.2, 20);
		eq1.print();

		double[] r1 = eq1.result();
		if (r1 != null)
			System.out.println(r1[0] + " " + r1[1]);
		else
			System.out.println("Nie ma lub nieskonczenie wiele rozwiazan!");

		eq1.makePNG("eq1", 600, 600);

		System.out.println();

		EquationSet eq2 = new EquationSet(1, 0, 30, 0, -1, 20);
		eq2.print();

		double[] r2 = eq2.result();
		if (r2 != null)
			System.out.println(r2[0] + " " + r2[1]);
		else
			System.out.println("Nie ma lub nieskonczenie wiele rozwiazan!");

		eq2.makePNG("eq2", 600, 600);
	}
}

class EquationSet
{
	public double a, b, c, d, e, f;
	public double eps = 1e-12;

	public EquationSet(double a, double b, double c, double d, double e, double f)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
	}

	public void print()
	{
		System.out.println(a + "x + " + b + "y = " + c);
		System.out.println(d + "x + " + e + "y = " + f);
	}

	public double detMain()
	{
		return a * e - d * b;
	}

	public double detX()
	{
		return c * e - f * b;
	}

	public double detY()
	{
		return a * f - d * c;
	}

	public double[] result()
	{
		return Math.abs(detMain()) > eps ? new double[]{detX() / detMain(), detY() / detMain()} : null;
	}

	public void makePNG(String filename, int imageWidth, int imageHeight)
	{
		BufferedImage myPicture = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = myPicture.createGraphics();

		int halfWidth = imageWidth / 2;
		int halfHeight = imageHeight / 2;

		g.setColor(Color.BLACK);
		g.drawLine(0, halfHeight, imageWidth, halfHeight);
		g.drawLine(halfWidth, 0, halfWidth, imageHeight);
		g.translate(halfWidth, halfHeight);
		g.setStroke(new BasicStroke(2));

		g.setColor(Color.GREEN);
		drawEquation(g, halfWidth, halfHeight, a, b, c);

		g.setColor(Color.BLUE);
		drawEquation(g, halfWidth, halfHeight, d, e, f);

		g.setColor(Color.RED);
		double[] r = result();
		if (r != null)
			g.fillOval((int) r[0] - 4, (int) -r[1] - 4, 8, 8);

		filename += ".png";
		try
		{
			ImageIO.write(myPicture, "png", new File(filename));
		}
		catch (IOException e)
		{
			System.out.println("I/O error while saving " + filename);
		}
	}

	private void drawEquation(Graphics2D g, int halfWidth, int halfHeight, double a, double b, double c)
	{
		if (b == 0)
		{
			g.drawLine((int) (c / a),
					-halfHeight,
					(int) (c / a),
					halfHeight);
		}
		else
		{
			double line1a = -a / b;
			double line1b = -c / b;
			g.drawLine(halfWidth,
					(int) (line1a * -halfWidth + line1b),
					-halfWidth,
					(int) (line1a * halfWidth + line1b));
		}
	}
}

