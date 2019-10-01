/** this is how to get items on the javadoc **/



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

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
        //Vector variable to store kNearestHelper objects
        Vector<kNearestHelper> kVector = new Vector<>();

        //creating File instance to reference text file in Java
        File text = new File(file);

        //Creating Scanner instance to read File in Java
        Scanner scan = new Scanner(text);


        //Reading each line of file using Scanner class
        int lineNumber = 1;

        while(scan.hasNextLine()){
            String line = scan.nextLine();
            System.out.println("line " + lineNumber + " :" + line);
            String[] splitLine = line.split(",");

            String csvClass = "";

            //Array of doubles store elements of the String array
            double[] eucildeanDis = new double[splitLine.length-1];
            for(int i = 0; i < splitLine.length-1; i++){
                eucildeanDis[i] = Double.parseDouble(splitLine[i]);
            }
            if(splitLine[splitLine.length-1].contains("1")){
                csvClass = "1";
            }
            else{
                csvClass = "2";
            }

            kVector.add(new kNearestHelper(csvClass, Euclidean_Distance(a, eucildeanDis)));
            lineNumber++;
        }


        //Sorting Algorithm of kVector
        //TODO: Figure out sorting
        Collections.sort(kVector);

        //Printing off kNearestHelper
        for(kNearestHelper i : kVector){
            System.out.println("Dist: " + i.eDist + " Class: " + i.csvClass);
        }

        int numClass1 = 0;
        int numClass2 = 0;

        for(int i =0; i < k; i++){
            if(kVector.get(i).csvClass.equals("1")){
                numClass1++;
            }
            else{
                numClass2++;
            }
        }

        //kVector.sort(kNearestHelper::compareTo);

        if(numClass1 > numClass2){
            return numClass1;
        }
        else if(numClass1 < numClass2){
            return numClass2;
        }
        else{
            return 0;
        }
    }

    /**Helper Class with K Nearest **/


    private static class kNearestHelper implements Comparable{
        private String csvClass = "";
        private double eDist = 0;


        //Constructor of kNearestHelper
        public kNearestHelper(String csvClass, double eDist) {
            this.csvClass = csvClass;
            this.eDist = eDist;
        }
        //Getter of csvClass
        public String getcsvClass(){
            return csvClass;
        }

        //Getter of eDist
        public double geteDist(){
            return eDist;
        }

        //Setter if csvClass
        public void setcsvClass(String csvClass) {
            this.csvClass = csvClass;
        }

        //Setter of eDist
        public void seteDist(double eDist) {
            this.eDist = eDist;
        }

        //Override of the compareTo function
        @Override
        public int compareTo(Object o){
            kNearestHelper compareK = (kNearestHelper) o;
            return Double.compare(this.eDist, compareK.eDist);
        }


        @Override
        public String toString() {
            return "kNearestHelper{" +
                    "csvClass='" + csvClass + '\'' +
                    ", eDist=" + eDist +
                    '}';
        }
    }
}
