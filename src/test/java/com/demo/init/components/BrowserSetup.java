package com.demo.init.components;

import com.microsoft.playwright.*;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;


@Getter
@Component
public class BrowserSetup {
    private Playwright pw;
    private Browser browser;
    private Page page;

    public BrowserSetup() {
        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setArgs(List.of("--start-maximized")));
        Browser.NewContextOptions options = new Browser.NewContextOptions().setViewportSize(null);
        BrowserContext context = browser.newContext(options);
        page = context.newPage();
    }

}