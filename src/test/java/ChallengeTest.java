import org.junit.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

/**
 * Parameter based test to check if application was able to provide correst validation response
 */
@RunWith(Parameterized.class)
public class ChallengeTest {

    String stringInput;
    String expectedResult;


    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
               { " ", "Space " },
                {"Martin ","Space values at the end "},
                {" Martin","Space values at the beginning "},
                {"x","Minimum value "},
                {"alert('Hello')","Basic Sql injection "},
               {"Gheorghe_asdfaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","More than maximum values "},
                {"<b>test</b>","You used html tags "},
                {"##@@","Other chars then alphabetic "}



        });
    }


    public ChallengeTest(String stringInput, String expectedResult) {
        this.stringInput = stringInput;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testIfContains(){

        Assertions.assertTrue(
        new Challenge1(true)
                .submitField(stringInput)
                .checkIfListContainsCase(expectedResult)
        );

    }

    @AfterEach
    public void cleanUp(){
        System.out.println("clearing up");
        new Page()
                .clear();
    }
}
