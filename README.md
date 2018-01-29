#Key Points
###`IoC(Inversion of Control)`：
1. IoC就是应用本身不依赖对象的创建和维护
 而是交给外部容器(这里为spring),这要就把应用和对象之间解耦,控制权交给了外部容器。
 即Don't call me ,I'll call you！所以IoC也称DI(依赖注入)对象的创建和维护依赖于外部容器.

2. (1)通过`set`方法注入  
    (2)通过构造函数方法注入

3. `id`可以有特殊字符
   `name`
   
4. 简单属``性的注入
   `name`
   `value`
   
5. `bean`的`scope`：`prototype` 按照原型造新的
    `request`
    `session`
    `singleton` 默认 单例

6. 集合注入
   ` map list set`
   
7. 自动装配
    `autowire` 默认为`byType`
    `byName`

8. bean的生命周期
    `lazy-init="true" `什么时候用，什么时候初始化
    `init-method=""` 创建的时候执行的方法
    `destroy-method=""` 销毁的时候执行的方法

9. `AOP`
   ` Annotation based config
    xmlns:context="http://www.springframework.org/schema/context"
    <context:annotation-config></context:annotation-config>
    xsi:schemaLocation="http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd"`
    xsd元数据文件，定义xml文件语法，一个xml文件可由多个xsd文件指定

10. ` @Autowired` 可以不写配置  放在`set`方法和构造方法等，成员变量 任意方法 默认byType
    当有两个bean时`@Autowired`和@`Qualifier("bean的名称")`写在参数上，一起使用 bean name可以当作一个Qualifier的值
       ` @Autowired (requred=false)`

11. `@Required`初始化的时候一定要注入

12. `@Resource` 可以指定特定bean的名称,默认`byName`

13. `@Component` `@Service` `@Controller` `@Repository`
     类可以当作一个bean使用，初始化的名字默认为首字母，可以指定初始化的bean的名称

14. `@Scope`同5

15. `@PostConstruct and @PreDestroy`同8

###AOP(Aspect-Oriented-Programming)
1. 面向切面编程
2. some definitions:
    `JoinPoint`
    `PointCut`
    `Aspect`
    `Advice`
    `Target`
    `Weave`
3. execution(public * com.example.impl.*.*(..))