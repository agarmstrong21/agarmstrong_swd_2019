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


}
