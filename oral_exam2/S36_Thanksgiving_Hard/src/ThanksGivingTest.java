import org.junit.Test;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThanksGivingTest extends ThanksGiving{

    @Test
    public void Test1(){
        //Test 1
        //----------
        //Input:
        //Turkey - weight: 3, enjoyment: 4
        //Pie - weight: 2, enjoyment: 2
        //Potatoes - weight: 4, enjoyment: 5
        //Gravy - weight: 10, enjoyment: 10
        //Stuffing - weight: 2, enjoyment: 3
        //Cranberries - weight: 7, enjoyment: 5
        //Casserole - weight: 12, enjoyment: 17
        //Capacity = 20
        //
        //Output:
        //Optimal enjoyment: 30
        ArrayList<ThanksGivingFood> f = new ArrayList<>();
        f.add(new ThanksGivingFood("Turkey", 3, 4));
        f.add(new ThanksGivingFood("Pie", 2,2));
        f.add(new ThanksGivingFood("Potatoes", 4, 5));
        f.add(new ThanksGivingFood("Gravy", 10,10));
        f.add(new ThanksGivingFood("Stuffing", 2,3));
        f.add(new ThanksGivingFood("Cranberries",7,5));
        f.add(new ThanksGivingFood("Casserole", 12,17));
        System.out.println("Test 1\n----------\nInput:");
        for(int i = 0; i < f.size(); i++){
            f.get(i).print();
        }
        int c = 20;
        System.out.println("Capacity = " + c + "\n\nOutput:\nOptimal enjoyment: ");
        int result = MaxEnjoyment(f, c);
        System.out.print(result);
        assertEquals(30, result);
    }

    @Test
    public void Test2(){

    }

    @Test
    public void Test3(){

    }

    @Test
    public void Test4(){

    }

    @Test
    public void Test5(){

    }

}
