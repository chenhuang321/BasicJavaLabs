/**
* This is a triangle class
* @author  Chen Huang
* @version 1.0
* @since   2016-09-26 
*/

public class Triangle implements Shape {
	
	private double[] sides = { 0,  0,  0}; /** The 3-side length of the triangle
	*/
	private double perimeter = 0;
	
	public void setSides(double a, double b, double c) {
		sides[0] = a;
		sides[1] = b;
		sides[2] = c;
		for(double side : sides) {
			perimeter += side;
		}
	}
	
	public Triangle(double a, double b, double c) {
		setSides(a, b, c);
	}
	
	public double getPerimeter() {
		return perimeter;
	}
	
	@Override
	public String toString() {
		String information = new String(); /** Information of each length of the triangle
		*/
		for(double side : sides) {
			information += side;
			information += " ";
		}
		return getClass().toString() + "\nTriangle side length: {" + information + "}" 
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