package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库...
        //1.定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select *from user where username = ? and password = ?";
            User user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username,password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        //1.定义sql语句
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        //2.执行sql语句
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());

    }

    @Override
    public void delete(int id) {
        //1.定义Sql
        String sql = "delete from user where id = ?";
        //2.执行sql
        template.update(sql,id);
    }

    @Override
    public User findByid(int id) {
        String sql = "select *from user where id = ?";

        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void update(User user) {
        String sql = "update user set name =? , gender = ? , age = ? , address = ?, qq = ? ,email = ? where id = ?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());

    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化
        String sql = "select count(*) from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keyset = condition.keySet();
        //定义参数集合
        List<Object> params = new ArrayList<Object>();
        for (String key: keyset) {

            //排除分页条件的参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取values
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append("and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);
        System.out.println(params.toArray());

        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select *from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keyset = condition.keySet();
        //定义参数集合
        List<Object> params = new ArrayList<Object>();
        for (String key: keyset) {

            //排除分页条件的参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取values
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append("and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
            //添加分页的查询
        sb.append("limit ? , ?");
            //添加分页查询的参数值
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        System.out.println(sql);
        System.out.println(params.toArray());
        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }
}
