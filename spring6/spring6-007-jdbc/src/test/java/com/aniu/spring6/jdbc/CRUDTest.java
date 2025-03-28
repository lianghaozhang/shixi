package com.aniu.spring6.jdbc;

import com.aniu.com.aniu.spring6.jdbc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CRUDTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);

//    测试连接
    @Test
    public void testConnection() {
        System.out.println(jdbcTemplate);
    }

//    测试插入数据
    @Test
    public void testInsert() {
        String sql = "insert into t_user(real_name, age) values(?,?)";
        int insert = jdbcTemplate.update(sql, "赵六", 26);
        System.out.println(insert);
    }

//    测试修改数据
    @Test
    public void testUpdate() {
        String sql = "update t_user set age=? where real_name=?";
        int update = jdbcTemplate.update(sql, 99, "张三");
        System.out.println(update);
    }

//    测试插入数据
    @Test
    public void testDelete() {
        String sql = "delete from t_user where real_name=?";
        int delete = jdbcTemplate.update(sql, "赵六");
        System.out.println(delete);
    }

//    查询一个对象
    @Test
    public void testSelectOneObject() {
        String sql = "select * from t_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
        System.out.println(user);
    }

//    查询所有对象
    @Test
    public void testSelectAll() {
        String sql = "select * from t_user";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        for (User user : list) {
            System.out.println(user);
        }
    }
}
