package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {


    private static Map<String, Object> propertyMap ;
    Properties prop = new Properties();

    public PropertyUtil() {
        initProperty();
    }

    public Object getProperty(String key){
        return propertyMap.get(key);
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    private void initProperty() {

        propertyMap=new HashMap<>();
        try {
            prop.load(new FileInputStream(
                    "src/main/resources/config.properties"));
            prop.stringPropertyNames().forEach(key-> propertyMap.put(key,prop.getProperty(key)));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
