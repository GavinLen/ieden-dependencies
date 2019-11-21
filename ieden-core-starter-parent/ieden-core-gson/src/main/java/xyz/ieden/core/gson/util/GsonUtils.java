package xyz.ieden.core.gson.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;
import xyz.ieden.core.gson.serializer.DateSerializer;
import xyz.ieden.core.gson.serializer.LongSerializer;
import xyz.ieden.core.gson.strategy.ExcludeAnnotationExclusionStrategy;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/**
 * @author lianghongwei01
 * @version 1.0.1
 * @date 2019/11/20 20:10
 */
public class GsonUtils {


    /**
     * 通过 @Exclude List 序列化
     *
     * @param list
     * @param type
     * @param <T>
     * @return
     */
    public static <T> String toJsonStrByExcludeAnnotation(List<T> list, Type type) {
        return excludeAnnotationGson().toJson(list, type);
    }

    /**
     * 通过 @Exclude List 序列化
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> String toJsonStrByExcludeAnnotation(List<T> list) {
        return excludeAnnotationGson().toJson(list);
    }

    /**
     * 通过 @Exclude 对象序列化
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String toJsonStrByExcludeAnnotation(T t) {
        return excludeAnnotationGson().toJson(t, t.getClass());
    }

    /**
     * List 序列化
     *
     * @param list
     * @param type
     * @param <T>
     * @return
     */
    public static <T> String toJsonStr(List<T> list, Type type) {
        final Gson gson = gson();
        return gson.toJson(list, type);
    }

    /**
     * List 序列化
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> String toJsonStr(List<T> list) {
        final Gson gson = gson();
        return gson.toJson(list);
    }

    /**
     * 对象序列化
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String toJsonStr(T t) {
        final Gson gson = gson();
        return gson.toJson(t, t.getClass());
    }

    /**
     * Json 反序列化
     *
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String jsonStr, Class<T> clazz) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        final Gson gson = gson();
        return gson.fromJson(jsonStr, clazz);
    }


    /**
     * 获取 @Exclude Gson
     *
     * @return
     */
    private static Gson excludeAnnotationGson() {
        return gsonBuilder().setExclusionStrategies(new ExcludeAnnotationExclusionStrategy()).serializeNulls().create();
    }

    /**
     * 获取 Gson
     *
     * @return
     */
    private static Gson gson() {
        final GsonBuilder gsonBuilder = gsonBuilder();
        final Gson gson = gsonBuilder.create();
        return gson;
    }

    /**
     * 获取 GsonBuilder
     *
     * @return
     */
    private static GsonBuilder gsonBuilder() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateSerializer())
                .registerTypeAdapter(long.class, new LongSerializer())
                .registerTypeAdapter(Long.class, new LongSerializer());
        return gsonBuilder;
    }

}