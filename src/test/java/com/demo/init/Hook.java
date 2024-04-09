package com.demo.init;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.demo.init.components.BrowserSetup;
import com.demo.page.Search;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ScreenshotType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;


@Slf4j
@CucumberContextConfiguration
@SpringBootTest(classes = {BrowserSetup.class, Search.class})
public class Hook extends BaseTest {

    public Hook() {
    }

    @Autowired
    private BrowserSetup browserSetup;


    @Before(order = 0)
    public void setComponents(Scenario scenario) {
        super.setComponents(browserSetup.getPw(), browserSetup.getPage(), scenario);
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshotBytes = page.screenshot(new Page.ScreenshotOptions().setType(ScreenshotType.PNG));
            String png = Base64.getEncoder().encodeToString(screenshotBytes);
            ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(png).build());
        }

    }

    @Before("@start")
    public void beforeScenario(Scenario scenario) {
        System.out.println("Before hook for @MyTag is executed");
    }

    @After("@end")
    public void endScenario(Scenario scenario) {
        System.out.println("End hook for @MyTag is executed");
    }

}
