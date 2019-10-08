/** this is how to get items on the javadoc **/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
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

    public int kNearest(String file, double[] a, int k) throws FileNotFoundException  {
        //Vector variable to store kNearestHelper objects
        Vector<kNearestHelper> kVector = new Vector<>();

        //creating File instance to reference text file
        File text = new File(file);

        //Creating Scanner instance to read File
        Scanner scan = new Scanner(text);

        //Reading each line of file using Scanner class
        int lineNumber = 1;

        while(scan.hasNextLine()){

            //Scans in next line, prints it out, then splits it
            String line = scan.nextLine();
            System.out.println("line " + lineNumber + " :" + line);
            String[] splitLine = line.split(",");
            String clusterClass = "";

            //Array of doubles store elements of the String array
            double[] eucildeanDis = new double[splitLine.length-1];
            for(int i = 0; i < splitLine.length-1; i++){
                eucildeanDis[i] = Double.parseDouble(splitLine[i]);
            }
            if(splitLine[splitLine.length-1].contains("1")){
                clusterClass = "1";
            }
            else{
                clusterClass = "2";
            }

            //Adds new object of kNearestHelper to the kVector
            kVector.add(new kNearestHelper(clusterClass, Euclidean_Distance(a, eucildeanDis)));
            lineNumber++;
        }


        //Sorting Algorithm of kVector
        kVector.sort(kNearestHelper::compareTo);

        //Printing off kNearestHelper
        for(kNearestHelper i : kVector){
            System.out.println("Euclidean Distance: " + i.eDist + " CSV Class: " + i.clusterClass);
        }

        //Finding all classes of the nearest terms
        int numClass1 = 0;
        int numClass2 = 0;
        for(int i =0; i < k; i++){
            if(kVector.get(i).clusterClass.equals("1")){
                numClass1++;
            }
            else{
                numClass2++;
            }
        }

        //Return statement depending on if which numClass is greater
        //TODO: If tie, return either one, if k is greater than file, then return just class 1
        if(numClass1 > numClass2){ return 1; }
        else if(numClass1 < numClass2){ return 2; }
        else { return 1; }
    }

    /**Helper Class with K Nearest **/
    private static class kNearestHelper implements Comparable{
        private String clusterClass = "";
        private double eDist = 0;

        //Constructor of kNearestHelper
        public kNearestHelper(String clusterClass, double eDist) {
            this.clusterClass = clusterClass;
            this.eDist = eDist;
        }

        //Getter of clusterClass
        public String getclusterClass(){
            return clusterClass;
        }

        //Getter of eDist
        public double geteDist(){
            return eDist;
        }

        //Setter if clusterClass
        public void setclusterClass(String clusterClass) {
            this.clusterClass = clusterClass;
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
    }

    public String kMeans(String file, int k)throws FileNotFoundException{
        //Random Class initialized
        Random rdm = new Random();

        //Vector variable to store kMeansHelper objects
        Vector<kMeansHelper> kVector = new Vector<>();

        //creating File instance to reference text file
        File text = new File(file);

        //Creating Scanner instance to read File
        Scanner scan = new Scanner(text);

        //Reading each line of file using Scanner class
        int lineNumber = 1;

        //Initializing a xMax, xMin, yMax, and yMin to use for random ranges
        double xMax = 0;
        double xMin = 0;
        double yMax = 0;
        double yMin = 0;

        while(scan.hasNextLine()){

            //Scans in next line, prints it out, then splits it
            String line = scan.nextLine();
            System.out.println("line " + lineNumber + " :" + line);
            String[] splitLine = line.split(",");
            int clusterClass = 0;

            //Array of doubles store elements of the String array
            double[] cords = new double[splitLine.length-1];
            for(int i = 0; i < splitLine.length-1; i++){
                cords[i] = Double.parseDouble(splitLine[i]);
            }

            //Finding mins and maxs and updating them
            if(cords[0] > xMax){
                xMax = cords[0];
            }else if(cords[0] < xMin){
                xMin = cords[0];
            }else if(cords[1] > yMax){
                yMax = cords[1];
            }else if(cords[1] < yMin){
                yMin = cords[1];
            }

            //Adds new object of kNearestHelper to the kVector
            kVector.add(new kMeansHelper(clusterClass, cords));

            lineNumber++;
        }

        //Creates new k number of centroids
        Vector<kMeansHelper> centroids = new Vector<>();
        for(int i = 0; i < k; i++){
            centroids.add(new kMeansHelper(i+1, new double[]{rdm.nextDouble() * (xMax - xMin) + xMin,
                    rdm.nextDouble() * (yMax - yMin) + yMin  }));
        }

        //TODO: Figure out a way to compare old results and new results
        //TODO: How to make k number of vectors and use euclidean to compare results and figure out which class it goes to
        while(0==0){
            for(kMeansHelper i : kVector){
                double eDist1 = 0;

            }
            break;

        }


        return "";
    }

    private static class kMeansHelper{
        private int clusterClass = 0;
        private double[] cordinates = {0,0};
        private int numCluster = 0;

        public kMeansHelper(int clusterClass, double[] cordinates) {
            this.clusterClass = clusterClass;
            this.cordinates = cordinates;
        }

        public int getclusterClass() {
            return clusterClass;
        }

        public void setclusterClass(int clusterClass) {
            this.clusterClass = clusterClass;
        }

        public double[] getCordinates() {
            return cordinates;
        }

        public void setCordinates(double[] cordinates) {
            this.cordinates = cordinates;
        }

        public int getNumCluster() {
            return numCluster;
        }

        public void setNumCluster(int numCluster) {
            this.numCluster = numCluster;
        }
    }

}
