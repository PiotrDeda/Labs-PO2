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
		if (eq1.result() != null)
		{
			double[] r1 = eq1.result();
			System.out.println(r1[0] + " " + r1[1] + "\n");
		}
		else
		{
			System.out.println("Nie ma lub nieskonczenie wiele rozwiazan!");
		}

		EquationSet eq2 = new EquationSet(1, 0, 30, 0, -1, 20);
		eq2.print();
		if (eq2.result() != null)
		{
			double[] r2 = eq2.result();
			System.out.println(r2[0] + " " + r2[1]);
		}
		else
		{
			System.out.println("Nie ma lub nieskonczenie wiele rozwiazan!");
		}

		eq1.makePNG("eq1", 600, 600);
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

	public double determinantMain()
	{
		return a * e - d * b;
	}

	public double determinantX()
	{
		return c * e - f * b;
	}

	public double determinantY()
	{
		return a * f - d * c;
	}

	public double[] result()
	{
		double w = determinantMain();
		if (Math.abs(w) < eps)
			return null;

		double[] r = new double[2];
		r[0] = determinantX() / w;
		r[1] = determinantY() / w;
		return r;
	}

	public void makePNG(String filename, int imageWidth, int imageHeight)
	{
		BufferedImage myPicture = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = myPicture.createGraphics();

		g.setColor(Color.BLACK);
		g.drawLine(0, imageHeight / 2, imageWidth, imageHeight / 2);
		g.drawLine(imageWidth / 2, 0, imageWidth / 2, imageHeight);
		g.translate(imageWidth / 2, imageHeight / 2);
		g.setStroke(new BasicStroke(2));

		final int halfWidth = imageWidth / 2;
		final int halfHeight = imageHeight / 2;

		g.setColor(Color.GREEN);
		drawEquation(g, halfWidth, halfHeight, a, b, c);

		g.setColor(Color.BLUE);
		drawEquation(g, halfWidth, halfHeight, d, e, f);

		g.setColor(Color.RED);
		if (result() != null)
		{
			double[] r = result();
			g.fillOval((int) r[0] - 4, (int) -r[1] - 4, 8, 8);
		}

		filename += ".png";
		try
		{
			File outputFile = new File(filename);
			ImageIO.write(myPicture, "png", outputFile);
		} catch (IOException e)
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

