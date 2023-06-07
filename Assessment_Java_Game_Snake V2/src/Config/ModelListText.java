package Config;

public class ModelListText {

	int x;
	int y;
	Object value;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public ModelListText(int x, int y, Object value) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
	}

}
