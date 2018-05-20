package com.wym.dao;

import com.wym.po.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class UserDAOImpl implements IUserDAO {

    private Configuration conf=null;
    private SessionFactory sf=null;

    public UserDAOImpl(){
        conf=new Configuration().configure("/hibernate.cfg.xml");
        sf=conf.buildSessionFactory();

    }
    @Test
    public void addUsers() {
        Session session=sf.openSession();
        Transaction trans=session.getTransaction();

        trans.begin();
        User user =new User();
        user.setUser("沈杰");
        user.setPassword("14250");
        session.save(user);
        trans.commit();
        System.out.println("添加成功");
        session.close();
}
    @Test
    public void delUsers() {
        Session session=sf.openSession();
        Transaction trans=session.getTransaction();

        trans.begin();
        User user=session.load(User.class,3);
        session.delete(user);
        trans.commit();
        System.out.println("删除成功");
        session.close();
    }
    @Test
    public void updateUsers() {
        Session session=sf.openSession();
        Transaction trans=session.getTransaction();

        trans.begin();
        User user=session.load(User.class,4);

        user.setUser("邢子一");
        user.setPassword("123456789");
        session.update(user);
        trans.commit();
        System.out.println("修改成功");
        session.close();
    }
@Test
    public void queryUsers() {
        Session session=sf.openSession();

        Query q=session.createQuery("from User");
        List<User> list=q.list();
        Iterator<User> iterator=list.iterator();
        while(iterator.hasNext()){
            User user=iterator.next();
            System.out.printf("%s--%s\n",user.getUser(),user.getPassword());
        }
        System.out.println("查询成功");
        session.close();
    }
}
