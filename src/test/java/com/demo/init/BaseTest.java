package com.demo.init;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.Scenario;
import org.springframework.beans.factory.annotation.Value;

public class BaseTest {

    @Value("${portal.url}")
    private String url;

    @Value("${portal.port}")
    private String  port;

    @Value("${portal.username}")
    private String userName;

    @Value("${portal.password}")
    private String passWord;

    protected Scenario scenario;

    public static Page page;
    public Playwright pw;



    protected void setComponents(Playwright pw, Page page, Scenario scenario) {
        this.pw = pw;
        BaseTest.page = page;
        this.scenario = scenario;
    }


}
