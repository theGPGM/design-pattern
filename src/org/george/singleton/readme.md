## 单例模式
#### 介绍
单例模式属于创建型设计模式，该模式只有唯一一个实例对象，不能 new 一个新的对象，只能通过类方法访问，在框架中有着广泛的应用
#### 应用
在 Spring 框架中，依赖注入 Bean 默认是单例的，在 AbstractBeanFactory 中调用 getSingleton 进行 bean 的创建
```java
 public Object getSingleton(String beanName){
     //参数true设置标识允许早期依赖
     return getSingleton(beanName,true);
 }
/**
* Bean 的创建使用了双重校验锁
*/
 protected Object getSingleton(String beanName, boolean allowEarlyReference) {
     //检查缓存中是否存在实例
     Object singletonObject = this.singletonObjects.get(beanName);
     //如果缓存不存在实例，或并不是正在创建，就进入创建阶段
     if (singletonObject == null && isSingletonCurrentlyInCreation(beanName)) {
         //锁定全局变量进行处理
         synchronized (this.singletonObjects) {
             //如果此bean正在加载，则不继续创建
             singletonObject = this.earlySingletonObjects.get(beanName);
             if (singletonObject == null && allowEarlyReference) {
                 //当某些方法需要提前初始化的时候则会调用addSingleFactory 方法将对应的ObjectFactory初始化策略存储在singletonFactories
                 ObjectFactory<?> singletonFactory = this.singletonFactories.get(beanName);
                 if (singletonFactory != null) {
                     //调用预先设定的getObject方法
                     singletonObject = singletonFactory.getObject();
                     //记录在缓存中，earlysingletonObjects和singletonFactories互斥
                     this.earlySingletonObjects.put(beanName, singletonObject);
                     this.singletonFactories.remove(beanName);
                 }
             }
         }
     }
     return (singletonObject != NULL_OBJECT ? singletonObject : null);
 }
```

## 实现
在此我实现了单例模式的六种写法：饿汉式、懒汉式、加锁、静态内部类、双重校验锁、枚举，其中静态内部类和双重校验锁较为常用