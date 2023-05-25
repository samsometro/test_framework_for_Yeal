package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class EditPage {

    private final SelenideElement textField = $x("//div/form/textarea[@name='tasks']");
    private final SelenideElement submitBtn = $x("//form/p/input[@class='big']");

    @Step
    public void clickOnSubmitBtn() {
        submitBtn.click();
    }

    @Step
    public MainPage editTask(String task) {
        textField.clear();
        textField.setValue(task);
        clickOnSubmitBtn();
        return new MainPage();
    }


}
