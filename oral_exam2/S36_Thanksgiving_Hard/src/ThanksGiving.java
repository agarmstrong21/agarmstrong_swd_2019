import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


class ThanksGiving {
    int MaxEnjoyment(ArrayList<ThanksGivingFood> f, int c){
        int MaxE = 0;
        int MaxETemp = 0;
        if(c == 0){
            return MaxE;
        }
        ArrayList<ThanksGivingFood> temp = f;
        double[] ratio = RatioMaker(temp);
        System.out.println(ratio.toString());
        double BestRatio = MinRatioFinder(ratio);
        System.out.println(BestRatio);
        int BestRatioLocation = MinRatioLocation(ratio, temp);
        System.out.println(BestRatioLocation);
        while(c > temp.get(BestRatioLocation + 1).getWeight()){
            MaxETemp += temp.get(BestRatioLocation).getEnjoyment();
            c -= temp.get(BestRatioLocation).getWeight();
        }
        temp.remove(BestRatioLocation);
        if(MaxETemp != MaxE){
            return MaxE + MaxEnjoyment(temp, c);
        }else{
            return MaxE;
        }
    }

    double[] RatioMaker(ArrayList<ThanksGivingFood> f){
        double[] result = new double[f.size()];
        for(int i = 0; i < f.size(); i++){
            result[i] = (f.get(i).getEnjoyment()/f.get(i).getWeight());
        }
        return result;
    }

    double MinRatioFinder(double[] r){
        double min = 0.0;
        for(int i = 0; i < r.length; i++){
            if(r[i] < min){
                min = r[i];
            }
        }
        return min;
    }

    int MinRatioLocation(double[] r, ArrayList<ThanksGivingFood> f){
        for(int i = 0; i < r.length; i++){
            if(r[i] == f.get(i).getEnjoyment()/f.get(i).getWeight()){
                return i;
            }
        }
        return 0;
    }
}
