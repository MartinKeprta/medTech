import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Parameter based test to check if application was able to provide correst validation response
 */
@RunWith(Parameterized.class)
public class ChallengeTestArray {

    String stringInput;
    List<String> expectedResult;


    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
               { "_x _x 3 null alert('sql') <h1> ", "Other chars then alphabetic,Space in the middle,You used html tags,Basic Sql injection,Maximum values" },
                {" test ","Space values at the end,Space values at the beginning"}


        });
    }


    public ChallengeTestArray(String stringInput, String expectedResult) {
        this.stringInput = stringInput;
        this.expectedResult=new ArrayList<String>(Arrays.asList(expectedResult.replace(" ","").split(",")));
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

        new Page()
                .clear()
                .close();
    }
}
