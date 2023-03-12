import java.util.LinkedList;
import java.util.List;

public class Vector3D<T>
{
	private final Object x;
	private final Object y;
	private final Object z;

	public Vector3D(T x, T y, T z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public String toString()
	{
		return "(" + x + "," + y + "," + z + ")";
	}

	public T x()
	{
		return (T) x;
	}

	public T y()
	{
		return (T) y;
	}

	public T z()
	{
		return (T) z;
	}

	public Vector3D<?> add(Vector3D<T> v)
	{
		if (x().getClass() == Integer.class)
			return new Vector3D<>((Integer) x() + (Integer) v.x(), (Integer) y() + (Integer) v.y(), (Integer) z() + (Integer) v.z());
		else if (x().getClass() == Double.class)
			return new Vector3D<>((Double) x() + (Double) v.x(), (Double) y() + (Double) v.y(), (Double) z() + (Double) v.z());
		else
			return null;
	}

	public List<T> getList()
	{
		List<T> result = new LinkedList<>();
		result.add(x());
		result.add(y());
		result.add(z());
		return result;
	}
}
