package test;

import org.junit.jupiter.api.Test;

public class SecondCase extends TestBase {

    @Test
    public void SecondTest() throws InterruptedException {
        main.goTo()
                .chooseTask("6");
        taskSix.checkAllElementsOnPagePresent()
                .fillInLogin("tester")
                .fillInPass("123-xyz")
                .logBtnClick()
                .isLoginCorrect();
        int i = 1;
    }
}
