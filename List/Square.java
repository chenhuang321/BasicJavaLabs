/**
* This is a square class
* @author  Chen Huang
* @version 1.0
* @since   2016-09-26 
*/

public class Square implements Shape {
	
	private double l = 0; /** The side length of the square
	*/
	private double perimeter = 0;
	
	public void setLength(double length) {
		l = length;
		perimeter = 4 * l;
	}
	
	public Square(double length) {
		setLength(length);
	}
	
	public double getPerimeter() {
		return perimeter;
	}
	
	@Override
	public String toString() {
		return getClass().toString() + "\nSquare side length: " + l
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
