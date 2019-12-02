/*
Name: Addison Armstrong
Name of Project: 21-26_InsertDelete_Medium
Name of Class: ListTest
Class Description: This class tests the implemented new methods, insertAt and removeAt. Look at lines 31 and 46. This
    code is given via the textbook.
*/

// Fig. 21.5: ListTest.java
// ListTest class to demonstrate List capabilities.

import com.deitel.datastructurs.EmptyListException;
import com.deitel.datastructurs.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new List<>();

        // insert integers in list
        list.insertAtFront(-1);
        list.print();
        list.insertAtFront(0);
        list.print();
        list.insertAtBack(1);
        list.print();
        list.insertAtBack(5);
        list.print();

        /**
         *      Adding new tests that I implemented. Below are the insertAt method
         */
        list.insertAt(2, 2);
        list.print();
        list.insertAt(3, 10);
        list.print();
        /**
         *      Done with new insertAt methods.
         */

        // remove objects from list; print after each removal
        try {
            int removedItem = list.removeFromFront();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();

            /**
             *      Adding new tests that I implemented. Below are the removeAt method
             */

            removedItem = list.removeAt(2);
            System.out.printf("%n%d removed%n", removedItem);
            list.print();

            removedItem = list.removeAt(3);
            System.out.printf("%n%d removed%n", removedItem);
            list.print();

            /**
             *      Done with new removeAt methods.
             */

            removedItem = list.removeFromFront();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();

            removedItem = list.removeFromBack();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();

            removedItem = list.removeFromBack();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();
        } catch (EmptyListException emptyListException) {
            emptyListException.printStackTrace();
        }
    }
} // end class ListTest


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
