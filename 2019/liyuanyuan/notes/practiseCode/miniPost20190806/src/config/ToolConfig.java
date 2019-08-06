package config;

import java.io.UnsupportedEncodingException;

public class ToolConfig {

    public static String getNewString(String str) throws UnsupportedEncodingException {
        return new String(str.getBytes("ISO-8859-1"),"UTF-8");
    }
}
