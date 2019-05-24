package com.gandazhi.test;

import com.gandazhi.test.mapper.MsgTypeMapper;
import com.gandazhi.test.pojo.MsgType;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Auther: gandazhi
 * @Date: 2019-05-16 11:12
 */
public class Test {

  public static void main(String[] args) throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession(); // 里面包含了Executor和configuration

    // 通过接口映射来实现
    MsgTypeMapper mapper = sqlSession.getMapper(MsgTypeMapper.class); //获取到接口的代理对象MapperProxy
    List<MsgType> selectAll = mapper.selectAll();

    // 通过mapper上的namespace来实现 需要依赖传递字符串，相比没通过接口包名相同的namespace映射安全
//    List<MsgType> selectAll = sqlSession.selectList("MsgTypeMapper.selectAll");
    System.out.println(selectAll);
  }
}
