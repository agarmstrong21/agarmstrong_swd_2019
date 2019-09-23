import jdk.internal.jline.internal.TestAccessible;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {
    private Student myStudent;
    @Test

    @BeforeEach
    void createStudent () {
        myStudent = new Student("Test", 90);
    }

    @TestAccessible void setName(){
        myStudent.setName("Hello");
        assertEquals("Hello", myStudent.getName());
    }

    @Test
    void setAverage(){
        myStudent.setAverage(69);
        assertEquals(69, myStudent.getAverage());
    }

    @ParameterizedTest(name="run #{index} with [{arguments}]")
    @CsvSource({"95,A" , "90,A" , "89,B" , "-13,F"})
    void getLetterGrade(double grade, String letter) {
        myStudent.setAverage(grade);
        assertEquals(letter, myStudent.getLetterGrade());
    }
}
