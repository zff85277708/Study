package ioc.overview.dependency.injection;

import ioc.overview.annotation.Super;
import ioc.overview.domian.User;
import ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖注入示例
 */
public class DenpendencyInjectionDemo {
    public static void main(String[] args) {
        //配置XML配置文件
        //启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "classpath:/META-INF/denpendency-injection-context.xml");
        UserRepository users = beanFactory.getBean("userRepository", UserRepository.class);
//        System.out.println(users.getUsers());

        //依赖注入
        System.out.println(users.getBeanFactory());

//        System.out.println(beanFactory);
//        System.out.println(users.getBeanFactory() == beanFactory);

        //依赖查找(错误)
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        ObjectFactory userFactory = users.getUserObjectFactory();
        System.out.println(userFactory.getObject() == beanFactory);
    }
}
