/**
* This is the main class
* @author  Chen Huang
* @version 1.0
* @since   2016-09-26 
*/

public class MainTask {
	
	
    public static void main(String[] args) {
		/** <h3>3 Tasks of the JAC444 Assignment 1</h3>
		 *  <ol>
		 *    <li>Try to create the following shapes and store them in ShapeLinkedList .</li>
		 *    <li>Delete the list tail and print the list.</li>
		 *    <li>Delete the shape called sq2 and print the list.</li>
		 *  </ol>
		 */
		// Task 1
		int[] values = {2,1,3,5,1,4,5,3,5,7,1,2,8,9};
		
		ShapeLinkedList sll = new ShapeLinkedList();
		
		Circle c1 = new Circle(values[0]);
		Circle c2 = new Circle(values[1]);
		
		Square sq1 = new Square(values[2]);
		Square sq2 = new Square(values[3]);
		
		Triangle t1 = new Triangle(values[4],values[5],values[6]);
		Triangle t2 = new Triangle(values[7],values[8],values[9]);
		
		Rectangle r1 = new Rectangle(values[10],values[11]);
		Rectangle r2 = new Rectangle(values[12],values[13]);
		
		sll.insertAtBeginning(r1);
		sll.insertAtBeginning(r2);
		sll.insertAtBeginning(c1);
		sll.insertAtBeginning(c2);
		sll.insertAtEnd(sq1);
		sll.insertAtEnd(sq2);
		sll.insertAtEnd(t1);
		sll.insertAtEnd(t2);
		
		System.out.println("Task1 Output\n" + sll.toString());
		
		// TODO: Task 2
		sll.deleteAtIndex(sll.length() - 1);
		System.out.println("Task2 Output\n" + sll.toString());
		
		// TODO: Task 3
		sll.deleteData(sq2);
		System.out.println("Task3 Output\n" + sll.toString());
    }
}
