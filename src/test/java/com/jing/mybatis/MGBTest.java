package com.jing.mybatis;

import com.jing.mybatis.mapper.EmpMapper;
import com.jing.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MGBTest {

    @Test
    public void testMBG(){
        //获取配置文件
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
            SqlSession sqlSession = build.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            /*//根据条件查询
            EmpExample example = new EmpExample();
            example.createCriteria().andEmpNameEqualTo("张三");
            List<Emp> list = mapper.selectByExample(example);
            list.forEach(emp -> System.out.println(emp));*/
            /*修改*/
            int i = mapper.updateByPrimaryKeySelective(new Emp(1,"zhangsan",12,null,"123qq.com",2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
