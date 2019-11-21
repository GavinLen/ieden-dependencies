package xyz.ieden.core.gson.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * @author lianghongwei01
 * @version 1.0.1
 * @date 2019/11/21 11:18
 */
public class LongSerializer implements JsonSerializer<Long> {
    @Override
    public JsonElement serialize(Long src, Type typeOfSrc, JsonSerializationContext context) {
        if (src != null) {
            final String srcStr = src.toString();
            if (srcStr.length() > 15) {
                return new JsonPrimitive(srcStr);
            }
        }

        return new JsonPrimitive(src);
    }
}
