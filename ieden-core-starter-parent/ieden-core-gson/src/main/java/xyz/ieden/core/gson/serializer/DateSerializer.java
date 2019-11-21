package xyz.ieden.core.gson.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lianghongwei01
 * @version 1.0.1
 * @date 2019/11/21 11:18
 */
public class DateSerializer implements JsonSerializer<Date> {

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        if (src != null) {
            return new JsonPrimitive(new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(src));
        }
        return new JsonPrimitive("");
    }
}
