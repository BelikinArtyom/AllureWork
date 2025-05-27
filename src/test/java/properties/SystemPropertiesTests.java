package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.browser;

public class SystemPropertiesTests {

    @Test
    void systemPropertiesTest1() {
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }
    @Test
    void systemPropertiesTest2() {
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }

    @Test
    void systemPropertiesTest3() {
        String browser =  System.getProperty("browser", "mozilla");
        System.out.println(browser);
    }

    @Test
    void systemPropertiesTest4() {
        System.setProperty("browser", "chrome");
        String browser =  System.getProperty("browser", "mozilla");
        System.out.println(browser);
    }

    @Test
    @Tag("property")
    void systemPropertiesTest5() {
        String browser =  System.getProperty("browser", "mozilla");
        System.out.println(browser);
    }


}
