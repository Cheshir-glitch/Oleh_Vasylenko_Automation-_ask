package utils;

import org.openqa.selenium.Capabilities;

public class CapabilityFactory {

    private Capabilities capabilities;

    public Capabilities getCapabilities() {

        capabilities = OptionsManager.getChromeOptions();

        return capabilities;
    }

}
