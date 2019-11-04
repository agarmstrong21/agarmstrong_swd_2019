/*
Name: Addison Armstrong
Name of Project: S27_MachineLearning_Medium
Name of Class: MachineLearningTest
Class Description: A subclass that tests possibilities in all programmed functions including Hamming Distance,
 Cosine Similarity, Euclidean Distance, and K Nearest Neighbor
 */

//Import Test, Assertions, and FileNotFoundException classes to help with testing
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.*;

//Creating MachineLearningTest
/** Machine Learning Test class.*/
public class MachineLearningTest extends MachineLearning {

    // Cosine Similarity Tests
        @Test
        public void allNegativeCS() {
            double[] a = {-1, -2, -3, -4};
            double[] b = {-9, -8, -7, -6};

            assertEquals(0.8427009716003845, Cosine_Similarity(a, b));
        }

        @Test
        void allPositiveCS() {
            double[] a = {1, 2, 3, 4};
            double[] b = {9, 8, 7, 6};

            assertEquals(0.8427009716003845, Cosine_Similarity(a, b));
        }

        @Test void emptySetCS() {
            double[] a = {0, 0, 0, 0, 4};
            double[] b = {};

            try {
                Cosine_Similarity(a, b);
                fail();
            } catch (Exception e) {
                assertEquals("Inputted vectors are not the same length. " +
                        "Please try again", e.getMessage());
            }
        }

        @Test void notEqualSetsCS() {
            double[] a = {10000000};
            double[] b = {1, 0, 0, 0, 0, 0, 0, 0};

            try {
                Cosine_Similarity(a, b);
                fail();
            } catch (Exception e) {
                assertEquals("Inputted vectors are not the same length. " +
                        "Please try again", e.getMessage());
            }
        }

        @Test void largeSetsCS(){
            double[] a = {-1012340, -532, 12389, 39018258, 76832714, -9, 8963710};
            double[] b = {1329859, 2391859, 821834, 223, - 9213, 732157, 888888};

            assertEquals(0.022220197511697185, Cosine_Similarity(a, b));
        }


    // Euclidean Distance Tests
        @Test
        void allNegativeED() {
            double[] a = {-1, -2, -3, -4};
            double[] b = {-9, -8, -7, -6};

            assertEquals(10.954451150103322, Euclidean_Distance(a, b));
        }

        @Test
        void allPositiveED() {
            double[] a = {1, 2, 3, 4};
            double[] b = {9, 8, 7, 6};

            assertEquals(10.954451150103322, Euclidean_Distance(a, b));
        }

        @Test void emptySetED() {
            double[] a = {0, 0, 0, 0, 4};
            double[] b = {};

            try {
                Euclidean_Distance(a, b);
                fail();
            } catch (Exception e) {
                assertEquals("Inputted vectors are not the same length. " +
                        "Please try again", e.getMessage());
            }
        }

        @Test void notEqualSetsED() {
            double[] a = {10000000};
            double[] b = {1, 0, 0, 0, 0, 0, 0, 0};

            try {
                Euclidean_Distance(a, b);
                fail();
            } catch (Exception e) {
                assertEquals("Inputted vectors are not the same length. " +
                        "Please try again", e.getMessage());
            }
        }

        @Test void largeSetsED(){
            double[] a = {-1012340, -532, 12389, 39018258, 76832714, -9, 8963710};
            double[] b = {1329859, 2391859, 821834, 223, - 9213, 732157, 888888};

            assertEquals(8.662962685928124E7, Euclidean_Distance(a, b));
        }

    // Hamming Distance Tests
        @Test
        void allNegativeHD() {
            double[] a = {-1, -2, -3, -4};
            double[] b = {-9, -8, -7, -6};

            assertEquals(10.954451150103322, Euclidean_Distance(a, b));
        }

        @Test
        void allPositiveHD() {
            String a = ("000000001");
            String b = ("101010101");

            assertEquals(4.0, Hamming_Distance(a, b));
        }

        @Test void emptySetHD() {
            String a = ("101");
            String b = ("");

            try {
                Hamming_Distance(a, b);
                fail();
            } catch (Exception e) {
                assertEquals("Inputted vectors are not the same length. " +
                        "Please try again", e.getMessage());
            }
        }

        @Test void notEqualSetsHD() {
            String a = ("101010011");
            String b = ("1");

            try {
                Hamming_Distance(a, b);
                fail();
            } catch (Exception e) {
                assertEquals("Inputted vectors are not the same length. " +
                        "Please try again", e.getMessage());
            }
        }

        @Test void largeSetsHD(){
            String a = ("100101010101010101010101010101010101011");
            String b = ("101010000001010101010111010101010100011");

            assertEquals(8.0, Hamming_Distance(a, b));
        }

        // Kth-Nearest Test
        //TODO: Do i need a test for medium? or just a main?
        @Test void kNearestTest() throws FileNotFoundException {
            String file = "S27-MLMedium.csv";
            double[]a = {1.5, 3.5, 2, 2, 8};
            int k = 5;
            assertEquals("New data point belongs to class1",kNearest(file, a, k));
        }

        @Test void kNearestTest2() throws FileNotFoundException {
            String file = "S27-MLMedium.csv";
            double[] a = {3, 3, 2, 2, 1};
            int k = 5;
            assertEquals("New data point belongs to class2", kNearest(file, a, k));
        }

        // Excluding Hard from this project. Keeping it in for future references.

//        //K-Means Clustering Test
//        //TODO: Make test representing the test used in the prompt
//
//        @Test void kMeansTest() throws FileNotFoundException{
//            String file = "S27-MLHard.csv";
//            int k = 4;
//            assertEquals("cluster1: 20 data points\n" +
//                    "cluster2: 30 data points\n" +
//                    "cluster3: 20 data points\n" +
//                    "cluster4: 50 data points", kMeans(file, k));
//        }
}