// package com.leaf.common.util;
//
// import org.springframework.aop.framework.AopContext;
// import org.springframework.beans.BeanWrapper;
// import org.springframework.beans.BeanWrapperImpl;
// import org.springframework.beans.BeansException;
// import org.springframework.beans.factory.NoSuchBeanDefinitionException;
// import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
// import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.ApplicationContextAware;
// import org.springframework.stereotype.Component;
// import org.springframework.util.ObjectUtils;
//
// import java.beans.PropertyDescriptor;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.stream.Collectors;
//
// /**
//  * SpringUtil: 获取 Spring 工厂对象爽歪歪的类
//  *
//  * @author jhlz
//  * @version 1.0.0
//  */
// @Component
// public class SpringUtil implements ApplicationContextAware, BeanFactoryPostProcessor {
//     /**
//      * Spring应用上下文环境
//      */
//     private static ConfigurableListableBeanFactory beanFactory;
//
//     private static ApplicationContext applicationContext;
//
//     @Override
//     public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//         SpringUtil.beanFactory = beanFactory;
//     }
//
//     @Override
//     public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//         SpringUtil.applicationContext = applicationContext;
//     }
//
//     /**
//      * 获取对象
//      *
//      * @param name
//      * @return Object 一个以所给名字注册的bean的实例
//      * @throws BeansException
//      */
//     @SuppressWarnings("unchecked")
//     public static <T> T getBean(String name) throws BeansException {
//         return (T) beanFactory.getBean(name);
//     }
//
//     /**
//      * 获取类型为requiredType的对象
//      *
//      * @param clz
//      * @return
//      * @throws BeansException
//      */
//     public static <T> T getBean(Class<T> clz) throws BeansException {
//         T result = (T) beanFactory.getBean(clz);
//         return result;
//     }
//
//     /**
//      * BeanFactory 是否包含一个与所给名称匹配的bean定义
//      *
//      * @param name
//      * @return boolean
//      */
//     public static boolean containsBean(String name) {
//         return beanFactory.containsBean(name);
//     }
//
//     /**
//      * 判断以给定名字注册的bean定义是一个singleton还是一个prototype。 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
//      *
//      * @param name
//      * @return boolean
//      * @throws NoSuchBeanDefinitionException
//      */
//     public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
//         return beanFactory.isSingleton(name);
//     }
//
//     /**
//      * @param name
//      * @return Class 注册对象的类型
//      * @throws NoSuchBeanDefinitionException
//      */
//     public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {
//         return beanFactory.getType(name);
//     }
//
//     /**
//      * 如果给定的bean名字在bean定义中有别名，则返回这些别名
//      *
//      * @param name
//      * @return
//      * @throws NoSuchBeanDefinitionException
//      */
//     public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
//         return beanFactory.getAliases(name);
//     }
//
//     /**
//      * 获取aop代理对象
//      *
//      * @param invoker
//      * @return
//      */
//     @SuppressWarnings("unchecked")
//     public static <T> T getAopProxy(T invoker) {
//         return (T) AopContext.currentProxy();
//     }
//
//     /**
//      * 获取当前的环境配置，无配置返回null
//      *
//      * @return 当前的环境配置
//      */
//     public static String[] getActiveProfiles() {
//         return applicationContext.getEnvironment().getActiveProfiles();
//     }
//
//     /**
//      * 获取当前的环境配置，当有多个环境配置时，只获取第一个
//      *
//      * @return 当前的环境配置
//      */
//     public static String getActiveProfile() {
//         final String[] activeProfiles = getActiveProfiles();
//         return !ObjectUtils.isEmpty(activeProfiles) ? activeProfiles[0] : null;
//     }
//
//     /**
//      * 获取配置文件中的值
//      *
//      * @param key 配置文件的key
//      * @return 根据 key 获取的配置文件中的 value
//      * @see #getPort()
//      */
//     public static String getRequiredProperty(String key) {
//         return applicationContext.getEnvironment().getRequiredProperty(key);
//     }
//
//     /**
//      * 辅助 Spring 框架中 BeanUtils.copyProperties(Object source, Object target, String... ignoreProperties)
//      * 获取 source 中为 null 的字段数组，复制时忽略
//      *
//      * @param source 源目标
//      * @return null 字段属性数组
//      * @see SpringUtil#getNonNullPropertyNames(Object)
//      */
//     public static String[] getNullPropertyNames(Object source) {
//         final BeanWrapper src = new BeanWrapperImpl(source);
//         PropertyDescriptor[] pds = src.getPropertyDescriptors();
//         return Arrays.stream(pds)
//                 .map(PropertyDescriptor::getName)
//                 .filter(name -> src.getPropertyValue(name) == null)
//                 .collect(Collectors.toCollection(ArrayList::new))
//                 .toArray(String[]::new);
//     }
//
//     /**
//      * 获取 source 中不为 null 的属性
//      *
//      * @param source 源对象
//      * @return 不为 null 的属性数组
//      * @see SpringUtil#getNullPropertyNames(Object)
//      */
//     public static String[] getNonNullPropertyNames(Object source) {
//         final BeanWrapper src = new BeanWrapperImpl(source);
//         PropertyDescriptor[] pds = src.getPropertyDescriptors();
//         return Arrays.stream(pds)
//                 .map(PropertyDescriptor::getName)
//                 .filter(name -> src.getPropertyValue(name) != null)
//                 .collect(Collectors.toCollection(ArrayList::new))
//                 .toArray(String[]::new);
//     }
//
//     /**
//      * 端口号
//      *
//      * @return 系统运行时的端口号
//      * @see #getRequiredProperty(String key)
//      */
//     public static String getPort() {
//         return getRequiredProperty("server.port");
//     }
// }
