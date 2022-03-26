package com.jing.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jing.mybatis.mapper.EmpMapper;
import com.jing.mybatis.pojo.Emp;
import com.jing.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PageHelperTest {

    @Test
    public void pageHelperTest(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
            SqlSession sqlSession = build.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //根据条件查询
            EmpExample example = new EmpExample();

            //Page<Object> page = PageHelper.startPage(1, 3);
            PageHelper.startPage(2,3);
            List<Emp> list = mapper.selectByExample(null);
            list.forEach(emp -> System.out.println(emp));
            PageInfo<Emp>  page = new PageInfo<>(list,5);
            System.out.println(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
