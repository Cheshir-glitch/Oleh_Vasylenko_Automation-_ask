package manager;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.HomePage;
import utils.CapabilityFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class PageFactoryManager {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private final CapabilityFactory capabilityFactory = new CapabilityFactory();


    @Before
    public void setUp() throws MalformedURLException {
        driver.set(new RemoteWebDriver(new URL("http://192.168.1.106:4444/wd/hub"), capabilityFactory.getCapabilities()));
    }

    @After
    public void tearDown() {
        getDriver().close();
    }

    @After
    void terminate() {
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }


    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }
}
