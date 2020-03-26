package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Peng.lv on 2017/6/28.
 * 我们使用了@interface声明了Test注解，并使用@Target注解传入ElementType.METHOD参数来标明@Test只能用于方法上，@Retention(RetentionPolicy.RUNTIME)则用来表示该注解生存期是运行时，从代码上看注解的定义很像接口的定义，确实如此，毕竟在编译后也会生成Test.class文件。对于@Target和@Retention是由Java提供的元注解，所谓元注解就是标记其他注解的注解，下面分别介绍
 *
 * @Retention用来约束注解的生命周期，分别有三个值，源码级别（source），类文件级别（class）或者运行时级别（runtime），其含有如下：

SOURCE：注解将被编译器丢弃（该类型的注解信息只会保留在源码里，源码经过编译后，注解信息会被丢弃，不会保留在编译好的class文件里）

CLASS：注解在class文件中可用，但会被VM丢弃（该类型的注解信息会保留在源码里和class文件里，在执行的时候，不会加载到虚拟机中），请注意，当注解未定义Retention值时，默认值是CLASS，如Java内置注解，@Override、@Deprecated、@SuppressWarnning等

RUNTIME：注解信息将在运行期(JVM)也保留，因此可以通过反射机制读取注解的信息（源码、class文件和执行的时候都有注解的信息），如SpringMvc中的@Controller、@Autowired、@RequestMapping等。
 */
//声明Test注解
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {

}
