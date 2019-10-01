/** this is how to get items on the javadoc **/



import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class MachineLearning {

    public double Cosine_Similarity(double[] a, double[] b){
        if(a.length != b.length){
            throw new IllegalArgumentException("Inputted vectors are not the same length. Please try again");
        }
        double sumA = 0.0;
        double sumB = 0.0;
        double sumTop = 0.0;
        double sumBottom = 0.0;
        for(int i = 0; i < a.length; i++){
            sumA += (a[i] * a[i]);
            sumB += (b[i] * b[i]);
            sumTop += (a[i] * b[i]);
        }
        sumA = Math.sqrt(sumA);
        sumB = Math.sqrt(sumB);
        sumBottom = sumA * sumB;


        return (sumTop/sumBottom);
    }

    public int Hamming_Distance(String a, String b){
        if(a.length() != b.length()){
            throw new IllegalArgumentException("Inputted vectors are not the same length. Please try again");
        }
        int countError = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                countError++;
            }
        }
        return countError;
    }

    public double Euclidean_Distance(double[] a, double[] b){
        if(a.length != b.length){
            throw new IllegalArgumentException("Inputted vectors are not the same length. Please try again");
        }
        double distance = 0;
        for(int i = 0; i < a.length; i++){
            distance += Math.pow(b[i] - a[i], 2);
        }
        return Math.sqrt(distance);
    }

    public double kNearestNeighbor(String file, double[] a, int k) throws FileNotFoundException  {
        //Checking if csv array length is same as double[] a length
        if(a.length != 5){ //TODO figure out how to get length of readin strings
            throw new IllegalArgumentException("Inputted vectors are not the same length. Please try again");
        }

        //creating File instance to reference text file in Java
        File text = new File(file);

        //Creating Scanner instance to read File in Java
        Scanner scan = new Scanner(text);

        //Counting how many rows there are
        int rows = 0;
        while(scan.hasNextLine()){
            rows++;
        }

        //Array to hold all Euclidean Distances
        double[] eucildeanDisClass1 = new double[rows/2];
        double[] eucildeanDisClass3 = new double[rows/2];

        //Creating a 3D array with Double[] and string
        Double[][] twoD1 = new Double[rows/2][5]; //TODO find how to figure out length of array from readin file (String.token)
        Double[][] twoD2 = new Double[rows/2][5];

        //Reading each line of file using Scanner class
        int lineNumber = 1;
        int lineNumber1 = 1;
        int lineNumber2 = 1;

        while(scan.hasNextLine()){
            String line = scan.nextLine();
            System.out.println("line " + lineNumber + " :" + line);

            if(line.contains("class1")) {
                for (int i = 0; i < 5; i++) {
                    String[] splitLine = line.split(",");
                    twoD1[lineNumber2][i] = Double.parseDouble(splitLine[i]);
                }
                lineNumber1++;
            }

            if(line.contains("class2")){
                for(int i = 0; i < 5; i++){
                    String[] splitLine = line.split(",");
                    twoD2[lineNumber1 ][i] = Double.parseDouble(splitLine[i]);
                }
                lineNumber2++;
            }
            lineNumber++;
        }


        //For loop to find all euclidean distances

        a[1] = twoD1[1];

        for(int i = 0; i < rows/2; i++){
            eucildeanDisClass1[i] = Euclidean_Distance(twoD1[i], a);
        }


        return 0;
    }


    class doubleObject{
        int size = 0;

    }

}
