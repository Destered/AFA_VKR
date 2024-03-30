package com.destered.afa_vkr.generator.core

object CoreGenerator {

    fun generateTestHeader() =
        """
            import io.appium.java_client.AppiumDriver;
            import io.appium.java_client.MobileElement;
            import io.appium.java_client.remote.MobileCapabilityType;
            import org.junit.After;
            import org.junit.Before;
            import org.junit.Test;
            import org.openqa.selenium.remote.DesiredCapabilities;
            import java.net.URL;
             
              public class GeneratedTest {
            
                private AppiumDriver<MobileElement> driver;
            
                @Before
                public void setUp() throws Exception {
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
                    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
                    driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                }
        """.trimIndent()

    fun generateTestFooter() = """
        
        @After
                public void tearDown() {
                    if (driver != null) {
                        driver.quit();
                    }
                }
            }
            ""${'"'};
    """.trimIndent()

}