import lombok.Getter;
import lombok.Setter;

import static com.codeborne.selenide.Selenide.*;

@Getter
@Setter
public class Page {

    private String mainUrl="http://testingchallenges.thetestingmap.org/index.php";

    public Page(Boolean open){
      open(mainUrl);
    }

    public Page(){
    }

    public Page clear(){
        clearBrowserLocalStorage();
        clearBrowserCookies();
        return this;
    }

    public Page close(){
        closeWebDriver();
        return this;
    }
}
