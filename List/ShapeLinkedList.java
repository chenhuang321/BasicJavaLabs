/**
* Link list containing geometrical Shapes
*/

public class ShapeLinkedList {
    
	public Node head; // Head is first node in linked list
    
	public ShapeLinkedList() { }
    
	public ShapeLinkedList(Node head) {
	    this.head = head;
    }

    public boolean isEmpty() {
        return length() == 0;
    }

    public void insertAtEnd(Shape data) {
        // TODO to be implemented
        if( head == null)
        	insertAtBeginning(data);
        else {
            Node tmpShapeNode = head;
            for(;tmpShapeNode.next != null;) 
            	tmpShapeNode = tmpShapeNode.next;
            tmpShapeNode.next = new Node(data, null);
         }
    }
    
    public void insertAtBeginning(Shape data) {
        // TODO to be implemented
    	final int firstIndexNo = 0;
    	if(data == null)
    		return;
    	if(head == null) {
            head = new Node(data, head);
    	}
    	else {
    		insertAtIndex(firstIndexNo, data);
    	}
    }
    
    public Node tail() {
        // TODO to be implemented
        // returns the last node
        if(head == null) 
        	System.err.println("No such item exist!");;
        	
        Node tmpShapeNode = head;
        while(tmpShapeNode.next != null) 
        	tmpShapeNode = tmpShapeNode.next;
        return tmpShapeNode;
    }

    public int length() {
        // TODO to be implemented
    	int i;
    	for(i = 0; findAtIndex(i) != null; i ++);
    	return i; // Returns the length of the linked list
    }
    
    void insertAtIndex(int idx, Shape data) {
        // TODO to be implemented
    	Node tmpNode = findAtIndex(idx);
    	Shape key = tmpNode.data;
        if(head == null) return;
        if(head.data.equals(key)) {
        	head = new Node(data, head);
           return;
        }
        Node previousNode = null;
        Node currentNode = head;
        for(;currentNode != null && !currentNode.data.equals(key);) {
        	previousNode = currentNode;
           currentNode = currentNode.next;
        }
        //insert between current and previous Shape
        if(currentNode != null)
        	previousNode.next = new Node(data, currentNode);
    }

    Node findAtIndex(int indexPosition) {
        // TODO to be implemented
        if (head == null)
        	System.err.println("Null object");
        Node result = head;
        for (int k = 0; k < indexPosition; k++) 
        	result = result.next;
        //if( result == null)
        	//System.err.println("Nothing is found in this case!");
        return result;
    }
    
    void deleteAtIndex(int indexNumber) {
        // TODO to be implemented
        Node newNode = new Node();
        newNode = findAtIndex(indexNumber);
        Shape indexShapeObject = newNode.data;
        deleteData(indexShapeObject);
        //System.out.println("Delete completed!");
    }

    @Override
    public String toString() {
        String result = new String();
        for(int i = 0; findAtIndex(i) != null; i ++) {
            result += findAtIndex(i).toString();
            result += "\n";
        }
        return result.toString();
    }

    void deleteData(Shape indexShape) {
        // TODO to be implemented
    	// boolean isDelete = true; // Set listener for the deleted data
    	if(head == null) {
             System.err.println("cannot delete null head");
             //isDelete = false;
    	}
        if( head.data.equals(indexShape) ) {
             head = head.next;
             return;
        } // Equals method to find node data
        Node currentNode  = head;
        Node previousNode = null;
        while(currentNode != null && !currentNode.data.equals(indexShape)) {
        	previousNode = currentNode;
        	currentNode = currentNode.next;
        }
        if(currentNode == null) {
             System.err.println("cannot delete current data");
             //isDelete = false;
        }
        //delete current node
        previousNode.next = currentNode.next;
        /** <h3>Debug if the function can delete the data</h3>
        if(isDelete) {
            System.out.println("Delete completed!");
        }
        */
    }
    
    @Override
    public int hashCode() {
        // TODO to be implemented
    	return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO to be implemented
    	return head.equals(obj);
    }
    
// Node is nested class because it only exists along with linked list
    public static class Node {
    	
        private Shape data;
        private Node next;
        // TODO develop all the methods that are needed
        // such as constructors, setters, getters
        // toString, equals, hashCode
        public Node() {}
        
        public Node(Shape data, Node next) {
        	setData(data);
        	setNext(next);
        }
        
        public void setData(Shape data) {
        	this.data = data;
        }
        
        public void setNext(Node next) {
        	this.next = next;
        }
        
        public Shape getData() {
        	return data;
        }
        
        public Shape getNext() {
            if (next == null) 
            	System.err.println("No such node item!");
            Shape shapeResource = next.data;
            next = next.next;
            return shapeResource;
             
        }
        
        public String toString() {
        	return data.toString();
        }
        
        public boolean equals(Shape data) {
        	return this.data.equals(data);
        }
        
        public int hashCode() {
        	return data.hashCode();
        }
    }
}
