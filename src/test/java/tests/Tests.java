package tests;

import org.testng.annotations.Test;
import pages.CreatePage;
import utils.GenerateData;

public class Tests extends TestBase {

    @Test
    public void checkCreateTask() {
        String task = GenerateData.randomTask();
        new CreatePage()
                .open()
                .createTask(task)
                .assertTask(task);
    }

    @Test
    public void checkEditTask() {
        String task = GenerateData.randomTask();
        new CreatePage()
                .open()
                .createTask(GenerateData.randomTask())
                .clickOnEdit()
                .editTask(task)
                .assertTask(task);
    }
}
