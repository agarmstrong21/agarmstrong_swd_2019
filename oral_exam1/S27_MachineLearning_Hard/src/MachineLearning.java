/** this is how to get items on the javadoc **/

import org.w3c.dom.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

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

    public String kNearest(String file, double[] a, int k) throws FileNotFoundException  {
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
            int clusterClass = 0;

            //Array of doubles store elements of the String array
            double[] eucildeanDis = new double[splitLine.length-1];
            for(int i = 0; i < splitLine.length-1; i++){
                eucildeanDis[i] = Double.parseDouble(splitLine[i]);
            }
            if(splitLine[splitLine.length-1].contains("1")){
                clusterClass = 1;
            }
            else{
                clusterClass = 2;
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
            if(kVector.get(i).clusterClass == 1){
                numClass1++;
            }
            else{
                numClass2++;
            }
        }

        //Return statement depending on if which numClass is greater
        //TODO: If tie, return either one, if k is greater than file, then return just class 1
        if(numClass1 > numClass2){ return "New data point belongs to class1"; }
        else if(numClass1 < numClass2){ return "New data point belongs to class2"; }
        else { return "New data point belongs to class1"; }
    }


    /**Helper Class with K Nearest **/
    private static class kNearestHelper implements Comparable{
        private int clusterClass = 0;
        private double eDist = 0;

        //Constructor of kNearestHelper
        public kNearestHelper(int clusterClass, double eDist) {
            this.clusterClass = clusterClass;
            this.eDist = eDist;
        }

        //Getter of clusterClass
        public int getclusterClass(){
            return clusterClass;
        }

        //Getter of eDist
        public double geteDist(){
            return eDist;
        }

        //Setter if clusterClass
        public void setclusterClass(int clusterClass) {
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
        String returnString = "";

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
        double xMax = -9999;
        double xMin = 9999;
        double yMax = -9999;
        double yMin = 9999;

        while(scan.hasNextLine()){

            //Scans in next line, prints it out, then splits it
            String line = scan.nextLine();
//            System.out.println("line " + lineNumber + " :" + line);
            String[] splitLine = line.split(",");
            int clusterClass = 0;

            //Array of doubles store elements of the String array
            double[] cords = new double[2];
            for(int i = 0; i < 2; i++){
                cords[i] = Double.parseDouble(splitLine[i]);
            }

            //Finding mins and maxs and updating them
            if(cords[0] > xMax){
                xMax = cords[0];
            }if(cords[0] < xMin){
                xMin = cords[0];
            }if(cords[1] > yMax){
                yMax = cords[1];
            }if(cords[1] < yMin){
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

        Vector<kMeansHelper> prevTemp = centroids;
        boolean isSame = false;

        int doesWhileWork = 0;
        while(!isSame){
            isSame = false;
            prevTemp = centroids;
            for(int i = 0; i < kVector.size(); i ++){
                Vector<kNearestHelper> Dists = new Vector<>(k);
                for(int j = 0; j < k; j++){
                    Dists.add(new kNearestHelper(j , Euclidean_Distance(kVector.get(i).cordinates, centroids.get(j).cordinates)));
                }
                Dists.sort(kNearestHelper::compareTo);
                kVector.get(i).setclusterClass(Dists.get(0).clusterClass);
                double[] average = kVector.get(i).cordinates;
                average[0] += kVector.get(i).getAverageX();
                average[1] += kVector.get(i).getAverageY();
                centroids.get(kVector.get(i).clusterClass).setAverage(average);
                centroids.get(kVector.get(i).clusterClass).setNumCluster(centroids.get(kVector.get(i).clusterClass).getNumCluster()+1);
            }

            for(int i = 0; i < k; i++){
                double[] newAverage = {0,0};
                newAverage[0] = centroids.get(i).getAverageX()/centroids.get(i).getNumCluster();
                newAverage[1] = centroids.get(i).getAverageY()/centroids.get(i).getNumCluster();
                centroids.get(i).setCordinates(newAverage);

                if(centroids.get(i).getNumCluster() != prevTemp.get(i).getNumCluster()){
                    isSame = false;
                }
            }

            doesWhileWork++;
        }
        System.out.println(doesWhileWork);


        for(int i = 0; i < k; i++){
            returnString += "cluster" + (i+1) + ": " + centroids.get(i).getNumCluster() + " data points\n";
        }
        return returnString;
    }

    private static class kMeansHelper{
        private int clusterClass = 0;
        private double[] cordinates = {0,0};
        private int numCluster = 0;
        private double[] average = {0,0};

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

        public double getCordinatesX() {
            return cordinates[0];
        }

        public double getCordinatesY() {
            return cordinates[1];
        }

        public int getNumCluster() {
            return numCluster;
        }

        public void setNumCluster(int numCluster) {
            this.numCluster = numCluster;
        }

        public double[] getAverage() {
            return average;
        }

        public void setAverage(double[] average) {
            this.average = average;
        }

        public double getAverageX() {
            return average[0];
        }

        public double getAverageY() {
            return average[1];
        }
    }

}
