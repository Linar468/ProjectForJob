import org.testng.annotations.Test;

public class TestNGCase extends TestBase{

    @Test()
    public void first(){
        System.out.println("Test1 start");
        getDriver().get("http://www.google.com");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle());
        System.out.println("Test1 end");
    }

    @Test()
    public void second(){
        System.out.println("Test2 start");
        getDriver().get("http://www.google.com");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle());
        System.out.println("Test2 end");
    }

    @Test()
    public void third(){
        System.out.println("Test3 start");
        getDriver().get("http://www.google.com");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle());
        System.out.println("Test3 end");
    }

    @Test()
    public void fourth(){
        System.out.println("Test4 start");
        getDriver().get("http://www.google.com");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle());
        System.out.println("Test4 end");
    }

    @Test()
    public void fifth(){
        System.out.println("Test5 start");
        getDriver().get("http://www.google.com");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle());
        System.out.println("Test5 end");
    }
    /*@Test(alwaysRun = true, groups = {"group1"})
    public void first(){
        System.out.println("Test1 start");
        getDriver().get("http://www.google.com");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle());
        System.out.println("Test1 end");
    }

    @Test(enabled = false, groups = {"group1"})
    public void second(){
        System.out.println("Test2 start");
        getDriver().get("http://www.google.com");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle());
        System.out.println("Test2 end");
    }

    @Test(dependsOnMethods = {"fourth"}, groups = {"group2"})
    public void third(){
        System.out.println("Test3 start");
        getDriver().get("http://www.google.com");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle());
        System.out.println("Test3 end");
    }

    @Test(priority = 1, groups = {"group2"})
    public void fourth(){
        System.out.println("Test4 start");
        getDriver().get("http://www.google.com");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle());
        System.out.println("Test4 end");
    }

    @Test(groups = {"group3"})
    public void fifth(){
        System.out.println("Test5 start");
        getDriver().get("http://www.google.com");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle());
        System.out.println("Test5 end");
    }*/
}
