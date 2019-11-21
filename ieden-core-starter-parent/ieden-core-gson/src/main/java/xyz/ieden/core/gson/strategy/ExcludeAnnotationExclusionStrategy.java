package xyz.ieden.core.gson.strategy;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import xyz.ieden.core.gson.annotation.Exclude;

/**
 * Exclude 注解排除策略
 *
 * @author lianghongwei01
 * @version 1.0.1
 * @date 2019/11/20 20:11
 */
public class ExcludeAnnotationExclusionStrategy implements ExclusionStrategy {

    /**
     * 跳过字段
     *
     * @param f
     * @return
     */
    @Override
    public boolean shouldSkipField(FieldAttributes f) {

        final Exclude annotation = f.getAnnotation(Exclude.class);
        if (annotation == null) {
            return false;
        }
        return annotation.enable();
    }

    /**
     * 跳过类
     *
     * @param clazz
     * @return
     */
    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        final Exclude annotation = clazz.getAnnotation(Exclude.class);
        if (annotation == null) {
            return false;
        }

        return annotation.enable();
    }
}
