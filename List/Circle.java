/**
* This is a circle class
* @author  Chen Huang
* @version 1.0
* @since   2016-09-26 
*/

public class Circle implements Shape {
	
	private double d = 0; /** diameter of the circle
	*/
	private double perimeter = 0;
	
	public void setDiameter(double index) {
		d = index;
		perimeter = Math.PI * d;
	}
	
	public Circle(double diameter) {
		setDiameter(diameter);
	}
	
	public double getPerimeter() {
		return perimeter;
	}
	
	@Override
	public String toString() {
		return getClass().toString() + "\nDiameter: " + String.format("%.1f", d)
		+ "\nPerimeter: " + String.format("%.6f", perimeter);
	}
	
	public boolean equals(Circle another) {
		return this.toString().equals(another.toString());
	}
	
	
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	
}
