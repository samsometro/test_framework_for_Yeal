package tests;

import listener.TestListener;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.DriverFactory;

@Listeners(TestListener.class)
public abstract class TestBase {

    @BeforeSuite
    public void setUpDriver() {
        DriverFactory.setUpDriver();
    }
}
