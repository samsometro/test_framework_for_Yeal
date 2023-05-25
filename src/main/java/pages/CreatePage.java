package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class CreatePage extends AbstractBasePage {

    private final SelenideElement taskField = $x("//textarea");
    private final SelenideElement submitBtn = $x("//input[@type='submit']");

    @Step
    public CreatePage open() {
        openWebSite("/create");
        return this;
    }

    @Step
    public MainPage createTask(String task) {
        taskField.clear();
        taskField.setValue(task);
        submitBtn.click();
        return new MainPage();
    }
}
