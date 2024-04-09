package com.demo.page;

import com.demo.init.BaseTest;
import com.demo.utils.XpathBuilder;
import org.springframework.stereotype.Component;

@Component
public class Search extends BaseTest {

    public void openUrl(String url) {
        page.navigate(url);
    }

    public void inputText(String keyWord) {
        page.locator(XpathBuilder.xpathGenerator("@name->q")).fill(keyWord);
    }

    public void clickSearchButton() {
        page.click(XpathBuilder.xpathGenerator("@type->submit"));
    }

    public void verifyOnResultsPage(){
        page.title();
    }
}
