package Config;

public class DataProvider {
    private static final String BASE_URL = "https://demoqa.com/";
    private static final String TEXT_BOX_URL = BASE_URL + "text-box";
    private static final String BUTTONS_URL = BASE_URL + "buttons";
    private static final String BROWSER_WINDOWS_URL = BASE_URL + "browser-windows";
    private static final String ALERTS_URL = BASE_URL + "alerts";
    public static String getBaseUrl(){
        return BASE_URL;
    }
    public static String getTextBoxUrl(){
        return TEXT_BOX_URL;
    }
    public static String getButtonsUrl(){
        return BUTTONS_URL;
    }
    public static String getBrowserWindowsUrl(){
        return BROWSER_WINDOWS_URL;
    }
    public static String getAlertsUrl(){
        return ALERTS_URL;
    }
}