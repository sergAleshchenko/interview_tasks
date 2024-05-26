package evgeny_borisov.spring_puzzlers.part_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 *
 * @author Sergei Aleshchenko
 */
@Component
public class PostInitInvokerListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        String[] names = context.getBeanDefinitionNames();

        for (String name : names) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();

            try {
                Class<?> originaBeanClass = Class.forName(beanClassName);
                Method[] methods = originaBeanClass.getMethods();

                for (Method method : methods) {
                    if (method.isAnnotationPresent(PostInitialize.class)) {
                        Object bean = context.getBean(name);
                        Class<?> proxyClass = bean.getClass();
                        Method proxyClassMethod = proxyClass.getMethod(method.getName());
                        proxyClassMethod.invoke(bean);
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
