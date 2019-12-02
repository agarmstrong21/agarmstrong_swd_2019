/*
Name: Addison Armstrong
Name of Project: 21-26_InsertDelete_Medium
Name of Class: List
Class Description: This class was given to us already via textbook. But there are added methods with comments around
    line 120. These methods are insertAt and removeAt. These methods insert and remove at given locations.
*/


// Fig. 21.3: List.java
// ListNode and List class declarations.
package com.deitel.datastructurs;

// class to represent one node in a list
class ListNode<T> {
    // package access members; List can access these directly
    T data; // data for this node
    ListNode<T> nextNode; // reference to the next node in the list

    // constructor creates a ListNode that refers to object
    ListNode(T object) {
        this(object, null);
    }

    // constructor creates ListNode that refers to the specified
    // object and to the next ListNode
    ListNode(T object, ListNode<T> node) {
        data = object;
        nextNode = node;
    }

    // return reference to data in node
    T getData() {
        return data;
    }

    // return reference to next node in list
    ListNode<T> getNext() {
        return nextNode;
    }
} // end class ListNode<T>

// class List definition
public class List<T> {
    private ListNode<T> firstNode;
    private ListNode<T> lastNode;
    private String name; // string like "list" used in printing

    // constructor creates empty List with "list" as the name
    public List() {
        this("list");
    }

    // constructor creates an empty List with a name
    public List(String listName) {
        name = listName;
        firstNode = lastNode = null;
    }

    // insert item at front of List
    public void insertAtFront(T insertItem) {
        if (isEmpty()) // firstNode and lastNode refer to same object
            firstNode = lastNode = new ListNode<T>(insertItem);
        else // firstNode refers to new node
            firstNode = new ListNode<T>(insertItem, firstNode);
    }

    // insert item at end of List
    public void insertAtBack(T insertItem) {
        if (isEmpty()) // firstNode and lastNode refer to same object
            firstNode = lastNode = new ListNode<T>(insertItem);
        else // lastNode's nextNode refers to new node
            lastNode = lastNode.nextNode = new ListNode<T>(insertItem);
    }

    // remove first node from List
    public T removeFromFront() throws EmptyListException {
        if (isEmpty()) // throw exception if List is empty
            throw new EmptyListException(name);

        T removedItem = firstNode.data; // retrieve data being removed

        // update references firstNode and lastNode
        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else
            firstNode = firstNode.nextNode;

        return removedItem; // return removed node data
    } // end method removeFromFront

    // remove last node from List
    public T removeFromBack() throws EmptyListException {
        if (isEmpty()) // throw exception if List is empty
            throw new EmptyListException(name);

        T removedItem = lastNode.data; // retrieve data being removed

        // update references firstNode and lastNode
        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else // locate new last node
        {
            ListNode<T> current = firstNode;

            // loop while current node does not refer to lastNode
            while (current.nextNode != lastNode)
                current = current.nextNode;

            lastNode = current; // current is new lastNode
            current.nextNode = null;
        }

        return removedItem; // return removed node data
    }

    /**
     *      Added insertAt and removeAt methods below
     * @param atNode
     * @param Node
     *
     *      Below is insertAt method. This method takes in a position and a data. Then creates a new node and finds where
     *          the user asked to put in the node, then inserts and changes the List accordingly.
     */
    public void insertAt(int atNode, T Node){
        ListNode<T> temp = firstNode;
        ListNode<T> place = new ListNode<T>(Node);
        for(int i = 0; i < atNode - 1; i++){
            temp = temp.nextNode;
        }
        place.nextNode = temp.nextNode;
        temp.nextNode = place;
    }

    /**
     *      Below is removeAt method. This method takes in the position of the node and finds the node before the node.
     *          Then removes the nextNode, then sets the previous node's nextNode to the nextNode's nextNode. Returns
     *          the node data.
     * @param atNode
     * @return
     */
    public T removeAt(int atNode){
        ListNode<T> temp = firstNode;
        for(int i = 0; i < atNode - 1; i++){
            temp = temp.nextNode;
        }
        ListNode<T> returned = temp.nextNode;
        temp.nextNode = temp.nextNode.nextNode;
        returned.nextNode = null;
        return returned.data;
    }

    /**
     *      Ending of the new implemented classes.
     */

    // determine whether list is empty
    public boolean isEmpty() {
        return firstNode == null; // return true if list is empty
    }

    // output list contents
    public void print() {
        if (isEmpty()) {
            System.out.printf("Empty %s%n", name);
            return;
        }

        System.out.printf("The %s is: ", name);
        ListNode<T> current = firstNode;

        // while not at end of list, output current node's data
        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }

        System.out.println();
    }
} // end class List<T>

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
