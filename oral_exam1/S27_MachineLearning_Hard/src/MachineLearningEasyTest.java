import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineLearningEasyTest extends MachineLearning {

    // Cosine Similarity Tests
        @Test
        void allNegativeCS() {
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
}