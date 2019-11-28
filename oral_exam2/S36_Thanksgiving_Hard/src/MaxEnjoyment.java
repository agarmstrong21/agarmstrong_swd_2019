/*
Name: Addison Armstrong
Name of Project: S36_ThanksGiving_Hard
Name of Class: MaxEnjoyment
Class Description: This is the MaxEnjoyment Class. This contains the algorithm to find the best case of under the
    capacity with the highest enjoyment.
Warnings: If you wish to use ManualInput class, you must run it in that class. Not here.
*/

// Importing ArrayList Tools
import java.util.ArrayList;

// Creating MaxEnjoyment class
/** Creating the MaxEnjoyment Class that contains the Algorithm to find the high enjoyment under the capacity. */
class MaxEnjoyment {
    static int MaxEnjoyment(ArrayList<Food> f, int c){

        // Initializing MaxE and preC
        int MaxE = 0;
        int preC;

        // Copying f into a temp ArrayList of Food
        ArrayList<Food> temp = f;

        // If c is 0, then return MaxE
        if(c == 0){
            return MaxE;
        }

        // If c is less than ALL weights, then return MaxE
        int validCap = 0;
        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i).getWeight() > c){
                validCap++;
            }
        }if(validCap == temp.size()){
            return MaxE;
        }

        // Getting the Ratio of Enjoyment/Weight of all foods.
        double[] ratio = RatioMaker(temp);

        // Finding Max Ratio
        double BestRatio = MaxRatio(ratio);

        // Finding where the Max Ratio is within f
        int BestRatioLocation = MaxRatioLocation(BestRatio, temp);

        // Depleting c with the weight of the highest ratio. Then adding enjoyment to MaxE
            // Also checking to see if there is a change in c. If not, set c to 0 and continue on, if there is,
                // print what food it was.
        while(c >= temp.get(BestRatioLocation).getWeight()){
            preC = c;
            MaxE += temp.get(BestRatioLocation).getEnjoyment();
            c -= temp.get(BestRatioLocation).getWeight();
            if(preC == c){
                c = 0;
            }else{
                System.out.println("Ate one " + temp.get(BestRatioLocation).getName());
            }
        }

        // Once c is depleted to less than the bestRatio weight, then it will remove that food item, and call the
            // Algorithm again. Only when c is greater than 0. If not, then it will return MaxE.
        temp.remove(BestRatioLocation);
        if(c > 0){
            return MaxE + MaxEnjoyment(temp, c);
        }else{
            return MaxE;
        }
    }

    // Helper function to create the ratios of Enjoyment/Weight of each food item
    static double[] RatioMaker(ArrayList<Food> f){
        double[] result = new double[f.size()];
        for(int i = 0; i < f.size(); i++){
            double temp = f.get(i).getEnjoyment();
            double temp2 = f.get(i).getWeight();
            temp = temp/temp2;
            result[i] = temp;
        }
        return result;
    }

    // Finding the Max Ratio of the ratio array
    static double MaxRatio(double[] r){
        double max = 0.0;
        for(int i = 0; i < r.length; i++){
            if(r[i] > max){
                max = r[i];
            }
        }
        return max;
    }

    // Finding the location of the Max Ratio, r, in f.
    static int MaxRatioLocation(double r, ArrayList<Food> f){
        for(int i = 0; i < f.size(); i++){
            double temp = f.get(i).getEnjoyment();
            double temp2 = f.get(i).getWeight();
            temp = temp/temp2;
            if(r == temp){
                return i;
            }
        }
        return 0;
    }
}
