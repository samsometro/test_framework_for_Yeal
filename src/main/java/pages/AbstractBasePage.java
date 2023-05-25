package pages;

import com.codeborne.selenide.Selenide;

public abstract class AbstractBasePage {

    public void openWebSite(String url) {
        Selenide.open(url);
    }
}
