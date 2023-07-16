package tst.investing.hooks.Infrastructure;

import tst.investing.hooks.SelenideConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utilities {

    public static String logAndGetString(LogLevel logLevel, String logMessage) {
        switch (logLevel) {
            case ERROR -> Log.error(logMessage);
            case WARN -> Log.warn(logMessage);
            case DEBUG -> Log.debug(logMessage);
            default -> Log.info(logMessage);
        }
        return logMessage;
    }

    public static void setSelenideProperties() {
        Properties props = new Properties();
        InputStream inputStream = SelenideConfiguration.class
                .getClassLoader()
                .getResourceAsStream("selenide.properties");
        try {
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!props.isEmpty()) {
            for (Object propObj : props.keySet()) {
                String prop = String.valueOf(propObj);

                if (!System.getProperties().containsKey(prop))
                    System.setProperty(prop, props.getProperty(prop));
            }
        }
    }


}
