import java.util.Scanner;

public class MinimumEditDistance {

    public static int MED(String s1, String s2){
        int med = 0;
        if(s1.length() == s2.length()){
            for(int i = 0; i < s1.length(); i++){
                if(s1.charAt(i) != s2.charAt(i)){
                    med++;
                }
            }
        }else{
            return 0;
        }
        return med;

    }

    public static void main(String[] args){
        Scanner readIn = new Scanner(System.in);
        System.out.println("Please enter first 5-letter string.");
        String s1 = readIn.next();
        System.out.println("Please enter second 5-letter string.");
        String s2 = readIn.next();

        int med = MED(s1,s2);
        System.out.println("Edit Distance: " + med);
    }
}
