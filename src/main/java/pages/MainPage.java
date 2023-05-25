package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement editButton = $x("//tr/td/a[@href='?edit=1']");
    private final ElementsCollection tasksColumns = $$x("//tbody/tr/td[@class='text']");

    @Step
    public EditPage clickOnEdit() {
        editButton.click();
        return new EditPage();
    }

    @Step
    public void assertTask(String expectedTask) {
        Assert.assertEquals(tasksColumns.filter(Condition.exactText(expectedTask)).first().getText(), expectedTask);
    }
}
