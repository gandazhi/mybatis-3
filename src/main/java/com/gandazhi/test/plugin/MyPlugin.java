package com.gandazhi.test.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Statement;
import java.util.Properties;

/**
 * @Auther: gandazhi
 * @Date: 2019-05-29 20:36
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "parameterize", args = Statement.class)})
public class MyPlugin implements Interceptor {

  /**
   * 拦截目标对象的目标方法
   * @param invocation
   * @return
   * @throws Throwable
   */
  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    System.out.println("intercept:" + invocation.getMethod());
    Object target = invocation.getTarget();
    System.out.println("拦截到的对象是:" + target);

    MetaObject metaObject = SystemMetaObject.forObject(target);
    Object value = metaObject.getValue("parameterHandler.parameterObject");
    System.out.println("sql语句用的参数是" + value);
    //更改SQL语句要用的参数
    metaObject.setValue("parameterHandler.parameterObject", 1);

    Object proceed = invocation.proceed(); //执行目标方法
    //返回执行后的返回值
    return proceed;
  }

  /**
   * 包装目标对象（为目标对象创建一个代理对象）
   * @param target
   * @return
   */
  @Override
  public Object plugin(Object target) {
    System.out.println("plugin:" + target);
    Object wrap = Plugin.wrap(target, this);
    return wrap; // 返回为当前target创建的动态代理
  }

  /**
   * 将插件注册时的property属性设置进来
   * @param properties
   */
  @Override
  public void setProperties(Properties properties) {
    System.out.println("插件配置的信息" + properties);
  }
}
