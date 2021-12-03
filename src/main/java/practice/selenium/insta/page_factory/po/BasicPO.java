package practice.selenium.insta.page_factory.po;


import org.openqa.selenium.support.PageFactory;
import practice.selenium.decorator.CustomDecorator;
import practice.selenium.parallel_run.BrowserFactory;

public abstract class BasicPO {

    public BasicPO() {
        PageFactory.initElements(new CustomDecorator(BrowserFactory.getDriver()),this);
    }

    boolean isOpen(){ return true; };
    boolean isFollowUser(){ return true; };
    boolean isFollowGroup(){ return true; };
}
