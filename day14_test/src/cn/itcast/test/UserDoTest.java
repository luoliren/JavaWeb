package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.junit.Test;

public class UserDoTest {

    @Test
    public void testLogin(){
        User loginser = new User();
        loginser.setUsername("superbaby");
        loginser.setPassword("123");

        UserDao dao = new UserDao();
        User user = dao.login(loginser);

        System.out.println(user);
    }
}
