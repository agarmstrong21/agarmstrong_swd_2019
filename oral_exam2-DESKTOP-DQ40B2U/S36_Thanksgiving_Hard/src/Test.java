/*
Name: Addison Armstrong
Name of Project: S36_ThanksGiving_Hard
Name of Class: Test
Class Description: This is the Test Class. This class runs all tests that are given in thanksgiving_test_cases.txt.
Warnings: If you wish to use ManualInput class, you must run it in that class. Not here.
*/

// Importing ArrayList and Testing tools
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

// Creating the Test class that extends MaxEnjoyment class.
/** Creating the Test class that extends MaxEnjoyment class. This class tests all test cases given.*/
public class Test extends MaxEnjoyment {

    // Test 1 Case
    @org.junit.Test
    public void Test1() {
        ArrayList<Food> f = new ArrayList<>();
        f.add(new Food("Turkey", 3, 4));
        f.add(new Food("Pie", 2, 2));
        f.add(new Food("Potatoes", 4, 5));
        f.add(new Food("Gravy", 10, 10));
        f.add(new Food("Stuffing", 2, 3));
        f.add(new Food("Cranberries", 7, 5));
        f.add(new Food("Casserole", 12, 17));
        System.out.println("Test 1\n----------\nInput:");
        for (int i = 0; i < f.size(); i++) {
            f.get(i).print();
        }
        int c = 20;
        System.out.println("Capacity = " + c + "\n\nOutput:\nOptimal enjoyment: ");
        int result = MaxEnjoyment(f, c);
        System.out.print(result);
        assertEquals(30, result);
    }

    // Test 2 Case
    @org.junit.Test
    public void Test2() {
        ArrayList<Food> f = new ArrayList<>();
        f.add(new Food("Turkey", 3, 4));
        f.add(new Food("Pie", 2, 2));
        f.add(new Food("Potatoes", 4, 5));
        f.add(new Food("Gravy", 1, 1));
        f.add(new Food("Stuffing", 2, 3));
        f.add(new Food("Cranberries", 10, 14));
        f.add(new Food("Casserole", 15, 24));
        System.out.println("Test 2\n----------\nInput:");
        for (Food food : f) {
            food.print();
        }
        int c = 41;
        System.out.println("Capacity = " + c + "\n\nOutput:\nOptimal enjoyment: ");
        int result = MaxEnjoyment(f, c);
        System.out.print(result);
        assertEquals(64, result);
    }

    // Test 3 Case
    @org.junit.Test
    public void Test3() {
        ArrayList<Food> f = new ArrayList<>();
        f.add(new Food("Turkey", 3, 5));
        f.add(new Food("Pie", 4, 12));
        f.add(new Food("Potatoes", 1, 1));
        f.add(new Food("Gravy", 2, 5));
        f.add(new Food("Stuffing", 1, 1));
        f.add(new Food("Cranberries", 2, 2));
        f.add(new Food("Casserole", 3, 3));
        System.out.println("Test 3\n----------\nInput:");
        for (Food food : f) {
            food.print();
        }
        int c = 7;
        System.out.println("Capacity = " + c + "\n\nOutput:\nOptimal enjoyment: ");
        int result = MaxEnjoyment(f, c);
        System.out.print(result);
        assertEquals(18, result);
    }

    // Test 4 Case
    @org.junit.Test
    public void Test4() {
        ArrayList<Food> f = new ArrayList<>();
        f.add(new Food("Turkey", 3, 6));
        f.add(new Food("Pie", 4, 9));
        f.add(new Food("Potatoes", 1, .5));
        f.add(new Food("Gravy", 2, 4));
        f.add(new Food("Stuffing", 1, 1));
        f.add(new Food("Cranberries", 2, 2));
        f.add(new Food("Casserole", 3, 3));
        System.out.println("Test 4\n----------\nInput:");
        for (Food food : f) {
            food.print();
        }
        int c = 9;
        System.out.println("Capacity = " + c + "\n\nOutput:\nOptimal enjoyment: ");
        int result = MaxEnjoyment(f, c);
        System.out.print(result);
        assertEquals(19, result);
    }

    //Test 5 Case
    @org.junit.Test
    public void Test5() {
        ArrayList<Food> f = new ArrayList<>();
        f.add(new Food("Turkey", 6, 7));
        f.add(new Food("Pie", 7, 8));
        f.add(new Food("Potatoes", 8, 9));
        f.add(new Food("Gravy", 9, 10));
        f.add(new Food("Stuffing", 10, 11));
        f.add(new Food("Cranberries", 11, 12));
        f.add(new Food("Casserole", 12, 13));
        System.out.println("Test 5\n----------\nInput:");
        for (Food food : f) {
            food.print();
        }
        int c = 5;
        System.out.println("Capacity = " + c + "\n\nOutput:\nOptimal enjoyment: ");
        int result = MaxEnjoyment(f, c);
        System.out.print(result);
        assertEquals(0, result);
    }
}
