package evgeny_borisov.spring_puzzlers.part_1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergei Aleshchenko
 */
@Component
public class SelfAutowiredBeanPostProcessor implements BeanPostProcessor, Ordered {

    private Map<String, Object> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(SelfAutowired.class)) {
                map.put(beanName, bean);
                break;
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Object o = map.get(beanName);
        
        if (o != null) {
            Field[] fields = o.getClass().getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(SelfAutowired.class)) {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, o, bean);
                }
            }
        }


        return bean;
    }

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }
}
