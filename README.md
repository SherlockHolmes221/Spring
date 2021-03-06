#Key Points
###`IoC(Inversion of Control)`：
1. IoC就是应用本身不依赖对象的创建和维护
 而是交给外部容器(这里为spring),这要就把应用和对象之间解耦,控制权交给了外部容器。
 即Don't call me ,I'll call you！所以IoC也称DI(依赖注入)对象的创建和维护依赖于外部容器.

2. (1)通过`set`方法注入  
    (2)通过构造函数方法注入

3. `id`可以有特殊字符
   `name`
   
4. 简单属性的注入
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
4. xml

###Spring整合Hibernate
1. Spring DataSource

`<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
        <property name="driverClassName" value="${jdbc.driverClassName}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>`
2.  `  <bean id="SessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
           <property name="dataSource" ref="dataSource"/>
           <property name="annotatedClasses">
               <list>
                   <value>com.example.model.User</value>
               </list>
           </property>
           <property name="hibernateProperties">
               <props>
                   <prop key="hibernate.dialect">
                       org.hibernate.dialect.HSQLDialect
                   </prop>
                   <prop key="hibernate.show_sql">
                       true
                   </prop>
               </props>
           </property>
       </bean>`
3. 事务管理

`<bean id="txManager" class="org.springframework.orm.hibernate5.HibernateTransactionManager">
        <property name="sessionFactory" ref="SessionFactory"/>
    </bean>`
    
   如果之前已有，则不会创建新的
   `@Transactional(propagation = Propagation.REQUIRED)`
   
4. 设计模式
`HibernateTemplate`

第一种方式：

(1)在spring初始化`HibernateTemplate`，注入`sessionFactory`,直接调用save()方法

(2)DAO里面注入HibernateTemplate

(3)save写getHibernateTemplate.save()