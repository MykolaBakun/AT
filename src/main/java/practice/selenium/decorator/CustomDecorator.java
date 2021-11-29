package practice.selenium.decorator;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.*;

import java.lang.reflect.Field;

public class CustomDecorator extends DefaultFieldDecorator {


    public CustomDecorator(SearchContext driver) {
        super(new DefaultElementLocatorFactory(driver));
    }

    public Object decorate(ClassLoader loader, Field field) {
        Class<?> decoratableClass = decoratableClass(field);

        if (decoratableClass != null) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) {
                return null;
            }
            return createElement(loader, locator, decoratableClass);
        }
        return super.decorate(loader, field);
    }

    protected <T> T createElement(ClassLoader loader,
                                  ElementLocator locator, Class<T> clazz) {
        WebElement proxy = proxyForLocator(loader, locator);
        return createInstance(clazz, proxy);
    }

    private <T> T createInstance(Class<T> clazz, WebElement element) {
        try {
            return clazz.getConstructor(WebElement.class)
                    .newInstance(element);
        } catch (Exception e) {
            throw new AssertionError(
                    "WebElement can't be represented as " + clazz
            );
        }
    }

    private Class<?> decoratableClass(Field field) {
        Class<?> clazz = field.getType();

        try {
            clazz.getConstructor(WebElement.class);
        } catch (Exception e) {
            return null;
        }

        return clazz;
    }
}

