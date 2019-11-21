package xyz.ieden.core.gson.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * @author lianghongwei01
 * @version 1.0.1
 * @date 2019/11/21 11:23
 */
public class NumberSerializer implements JsonSerializer<Number> {

    public static final Number DEFAULT_NUMBER_VAL = 0;

    @Override
    public JsonElement serialize(Number src, Type typeOfSrc, JsonSerializationContext context) {

        if (src == null) {
            src = DEFAULT_NUMBER_VAL;
        }
        return new JsonPrimitive(src);
    }
}
