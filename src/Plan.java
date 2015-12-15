
public class Plan {
	private int pixWidth;
	private int pixHeight;
	private double left;
	private double up;
	private double width;
	private double height;
	
	public Plan(int pixWidth, int pixHeight, double left, double up, double width, double height) {
		this.pixHeight = pixHeight;
		this.pixWidth = pixWidth;
		this.left = left;
		this.up = up;
		this.width = width;
		this.height = height;
	}
	
	public Plan() {
		this.pixHeight = 0;
		this.pixWidth = 0;
		this.left = 0.0;
		this.up = 0.0;
		this.width = 0.0;
		this.height = 0.0;
	}

	public Imaginary pointAt(int pixX, int pixY) {
		double x = ((double)pixX/(double)this.pixWidth) * this.width + this.left;
		double y = ((double)pixY/(double)this.pixHeight) * this.height + this.up;
		return new Imaginary(x, y);
	}
	
	public void setSize(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public void setCorner(double left, double up) {
		this.up = up;
		this.left = left;
	}
	
	public int getPixelWidth() {
		return this.pixWidth;
	}
	
	public void setPixelWidth(int pixWidth) {
		this.pixWidth = pixWidth;
	}
	
	public int getPixelHeight() {
		return this.pixHeight;
	}
	
	public void setPixelHeight(int pixHeight) {
		this.pixHeight = pixHeight;
	}
	
	public void setUp(double up) {
		this.up = up;
	}
	
	public void setLeft(double left) {
		this.left = left;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
}
