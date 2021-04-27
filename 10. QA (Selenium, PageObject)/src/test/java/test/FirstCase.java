package test;

import org.junit.jupiter.api.Test;

public class FirstCase extends TestBase {

    @Test
    public void firstTest() {
        main.goTo()
                .chooseTask("1");
        taskOne
                .checkPageIsCorrect();
        taskOne
                .scrollToElement("Kostka");
    }
}

