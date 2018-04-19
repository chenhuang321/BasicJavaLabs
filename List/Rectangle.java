/**
* This is a rectangle class
* @author  Chen Huang
* @version 1.0
* @since   2016-09-26 
*/

public class Rectangle implements Shape {
	
	private double l = 0;
	private double w = 0;
	
	/** The length and wide of the rectangle
	*/
	private double perimeter = 0;
	
	public void setLengthWide(double length, double wide) {
		l = length;
		w = wide;
		perimeter = ( l + w) * 2;
	}
	
	public Rectangle(double length, double wide) {
		setLengthWide(length, wide);
	}
	
	public double getPerimeter() {
		return perimeter;
	}
	
	@Override
	public String toString() {
		return getClass().toString() + "\nLength(" + l + ") Wide(" + w + ")"
		+ "\nPerimeter: " + perimeter;
	}
	
	public boolean equals(Square another) {
		return this.toString().equals(another.toString());
	}
	
	
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
}