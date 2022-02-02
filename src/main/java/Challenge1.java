import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

@Getter
@Setter
public class Challenge1 extends Page{
    private SelenideElement inputField = $("#firstname");
    private SelenideElement submit=$(By.name("formSubmit"));
    private List<SelenideElement> usecases=$$("ul.values-description li");

    public Challenge1(Boolean open){
        open(getMainUrl());
    }
    public Challenge1 submitField(String value){
        inputField.sendKeys(value);
        submit.click();
        return this;
    }

    public boolean checkIfListContainsCase(String usecase){
        for(SelenideElement element:usecases){
            if(element.getOwnText().replaceAll(" ", "").equals(usecase.replaceAll(" ", "")))return true;
        }
        return false;
    }

    public boolean checkIfListContainsCase(List<String> usecase){
        List<String> presentIssues=new ArrayList<>();
        for(SelenideElement element:usecases){
            presentIssues.add(element.getOwnText().replaceAll(" ",""));
        }
        return usecase.containsAll(presentIssues);
    }


}
