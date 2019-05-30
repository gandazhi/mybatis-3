package com.gandazhi.test.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

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
