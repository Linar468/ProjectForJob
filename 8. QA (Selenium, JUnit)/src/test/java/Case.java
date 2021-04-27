import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;

public class Case {
    WebDriver driver;
    WebDriverWait wait;
    final String URL = "https://buggy-testingcup.pgs-soft.com/";


    //Параметры GoogleChrome
    @Before
    public void initialization() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.get(URL);
    }


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    //Выбор задания №1, ввод числа в форму, проверка корректного ввода,
    // очистка поля, проверка корректной очистки
    @Test
    public void inputNumberAndClearField() throws InterruptedException {
        selectTask("1");
        WebElement input = driver.findElement
                (By.xpath("//button[@data-product-name='Okulary']/../following-sibling::input"));
        input.clear();
        sleep(2000);
        input.sendKeys("2");
        sleep(2000);
        driver.findElement(By.xpath("//button[@data-product-name='Okulary']")).click();
        sleep(2000);
        WebElement sum = driver.findElement(By.className("summary-quantity"));
        Assert.assertEquals("Should Be Equal", "2", sum.getText());
        sleep(2000);
        driver.findElement(By.xpath("//button[.='Usuń']")).click();
        Assert.assertEquals("Should Be Equal", "0", sum.getText());
        int a = 0;
    }


    //Выборка в выпадающем списке по видимому тексту
    @Test
    public void checkSelectByVisibleText() {
        selectTask("8");
        Select select = new Select(driver.findElement(By.id("task8_form_cardType")));
        select.selectByVisibleText("MasterCard");
        WebElement option = select.getFirstSelectedOption();
        Assert.assertEquals("MasterCard", option.getText());
        int i = 1;
    }


    //Выборка в выпадающем списке по индексу
    @Test
    public void checkSelectById() {
        selectTask("8");
        Select select = new Select(driver.findElement(By.id("task8_form_cardType")));
        select.selectByIndex(4);
        WebElement option = select.getFirstSelectedOption();
        Assert.assertEquals("Discover" , option.getText());
        int i = 1;
    }


    //Выборка в выпадающем списке по ключу
    @Test
    public void checkSelectByValue() {
        selectTask("8");
        Select select = new Select(driver.findElement(By.id("task8_form_cardType")));
        select.selectByValue("dc");
        WebElement option = select.getFirstSelectedOption();
        Assert.assertEquals("Diners Club" , option.getText());
        int i = 1;
    }


    // Переход на страницу №3, проверка что поля ввода отключены,
    // клик по кнопке активации полей и последующая проверка успешной активации
    @Test
    public void checkEnabledAndDisabledFields() throws InterruptedException {
        selectTask("3");
        isElementDisabled("in-name");
        isElementDisabled("in-surname");
        isElementDisabled("in-notes");
        isElementDisabled("in-phone");
        isElementDisabled("in-file");
        allowEdit();
        isElementEnabled("in-name");
        isElementEnabled("in-surname");
        isElementEnabled("in-notes");
        isElementEnabled("in-phone");
        isElementEnabled("in-file");
        int i = 1;
    }


    // Перетаскивание объекта в корзину и последующая проверка
    @Test
    public void addProductWithDragAndDrop() throws InterruptedException {
        selectTask("7");
        WebElement fieldProductNumber = driver.findElement(By.xpath("//h4[.='Aparat']/following-sibling::div/input"));
        fieldProductNumber.clear();
        fieldProductNumber.sendKeys("1");
        sleep(5000);
        WebElement productImage = driver.findElement(By.xpath("//div[h4='Aparat']/preceding-sibling::div/img"));
        WebElement basket = driver.findElement(By.cssSelector(".panel-body"));
        Actions action = new Actions(driver);
        action.dragAndDrop(productImage, basket).perform();
        sleep(5000);
        WebElement basketAmountForProduct = driver.findElement(By.xpath("//span[@data-quantity-for='Aparat']"));
        Assert.assertEquals("1", basketAmountForProduct.getText());
    }


    //Загрузка фото профиля и проверка корректного отображения
    @Test
    public void checkUploadFile() throws InterruptedException {
        selectTask("3");
        allowEdit();
        driver.findElement(By.id("in-file")).
                sendKeys(System.getProperty("user.dir") + "\\123.png");
        sleep(10000);
        driver.findElement(By.id("save-btn")).click();
        sleep(5000);
        WebElement element = driver.findElement(By.cssSelector(".preview-photo"));
        Assert.assertTrue(element.isDisplayed());
        int i = -1;
    }


    //Ввод логина, пароля, переход дальше по ссылке
    @Test
    public void isCorrectLogin() throws InterruptedException {
        selectTask("6");
        sleep(1000);
        driver.findElement(By.id("LoginForm__username")).sendKeys("tester");
        sleep(1000);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("LoginForm__password")).sendKeys("123-xyz");
        sleep(1000);
        driver.findElement(By.id("LoginForm_save")).click();
        sleep(1000);
        driver.findElement(By.linkText("Pobierz plik")).click();
        sleep(1000);
        int i = 1;
    }


    //Скачивание файла и проверка соответствия
    @Test
    public void checkDownloadingFile() throws InterruptedException {
        driver.get("https://cloud.mail.ru/public/iH4E/gKhZ22N5v");
        sleep(5000);
        driver.findElement(By.className("ViewerToolbar__download--3R6Ry")).click();
        sleep(5000);
        isFileDownloaded("EYGGvYOERKSs.pdf");
    }


    // Переключение между окнами браузера с помощью итератора
    @Test
    public void newWindowHandling() {
        driver.get("http://the-internet.herokuapp.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        waitForSecondWindow();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        String parentWindow = itr.next();
        String childWindow = itr.next();
        driver.switchTo().window(childWindow);
        Assert.assertEquals(driver.getTitle(), "New Window");
        driver.switchTo().window(parentWindow);
        Assert.assertEquals(driver.getTitle(), "The Internet");
    }

    // Метод перехода на нужную страницу
    private void selectTask(String num) {
        driver.findElement(By.xpath("//h2[.='Zadanie " + num + "']")).click();
    }

    // Переключение между окнами браузера при помощи динамических списков
    @Test
    public void newWindowHandlingWithList() {
        driver.get("http://the-internet.herokuapp.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        waitForSecondWindow();
        Set<String> windows = driver.getWindowHandles();
        List<String> winds = new ArrayList<>(windows);
        String parentWindow = winds.get(0);
        String childWindow = winds.get(1);
        driver.switchTo().window(childWindow);
        Assert.assertEquals(driver.getTitle(), "New Window");
        driver.switchTo().window(parentWindow);
        Assert.assertEquals( driver.getTitle(), "The Internet");
    }

    //Метод проверки неактивности полей
    private void isElementDisabled(String element) {
        Assert.assertFalse(driver.findElement(By.id(element)).isEnabled());
    }

    //Метод проверки активности полей
    private void isElementEnabled(String element) {
        Assert.assertTrue(driver.findElement(By.id(element)).isEnabled());
    }


    // Активация полей при нажатии на соответствующую кнопку
    private void allowEdit() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.className("caret"))).build().perform();
        sleep(500);
        actions.moveToElement(driver.findElement(By.className("caret-right"))).build().perform();
        sleep(500);
        driver.findElement(By.id("start-edit")).click();
    }

    // Ожидание подгрузки всех окон браузера
    public void waitForSecondWindow() {
        wait.until(((ExpectedCondition<Boolean>) d -> driver.getWindowHandles().size() > 1));
    }

    // Проверка успешной загрузки файла
    private void isFileDownloaded(String file) {
        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f1 = null;
        for (File randomFile : listOfFiles) {
            if (randomFile.isFile()) {
                String fileName = randomFile.getName();
                if (fileName.matches(file)) {
                    f1 = new File(fileName);
                    found = true;
                }
            }
        }
        Assert.assertTrue("File not found", found);
        f1.deleteOnExit();
    }
}
