package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的DAO
 */
public interface UserDao {
    public List<User> findAll();
    public User findUserByUsernameAndPassword (String username,String password);

    public void addUser(User user);


    public void delete(int id);

    public User findByid(int parseInt);

    public void update(User user);

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    public int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页的记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}

