package com.demo.runner;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setArgs(List.of("--start-maximized")));
        Browser.NewContextOptions options = new Browser.NewContextOptions().setViewportSize(null);
        BrowserContext context = browser.newContext(options);

        Page page = context.newPage();
        page.navigate("https://www.google.com/");
        page.locator("xpath=//*[@name='q']").fill("abc");
        page.click("xpath=//*[@type='submit']");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        page.close();
        pw.close();

    }

}
