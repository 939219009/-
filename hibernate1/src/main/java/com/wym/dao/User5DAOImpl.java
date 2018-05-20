package com.wym.dao;

import com.wym.po.User5;
import com.wym.po.User5PK;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;


public class User5DAOImpl {
    private Configuration conf;
    private SessionFactory sf;

    public User5DAOImpl() {
        conf=new Configuration().configure("hibernate.cfg.xml");
        sf=conf.buildSessionFactory();
    }
    @Test
    public void addUsers(){
        Session session=sf.openSession();
        Transaction trans=session.getTransaction();

        try{
            trans.begin();
            User5 user =new User5();
            user.setUsername("gmy");
            user.setSex("M");
            user.setAge(22);
            session.save(user);
            System.out.println("插入成功");
            trans.commit();

        }catch (Exception e){
           trans.rollback();
           e.printStackTrace();
        }
        session.close();
    }
    @Test
    public void delUsers(){
        Session session=sf.openSession();
        Transaction trans=session.getTransaction();
        try{
            trans.begin();
            User5PK pk=new User5PK();
            pk.setUsername("ly");
            pk.setSex("M");
            User5 user=session.load(User5.class,pk);
            session.delete(user);
            System.out.println("删除成功");
            trans.commit();

        }catch (Exception e){
            trans.rollback();
            e.printStackTrace();
        }
        session.close();
    }
    @Test
    public void updateUsers(){
        Session session=sf.openSession();
        Transaction trans=session.getTransaction();

        try{
            trans.begin();
            User5PK pk=new User5PK();
            pk.setUsername("ly");
            pk.setSex("M");
            User5 user=session.load(User5.class,pk);
            user.setAge(21);
            session.update(user);
            trans.commit();
            System.out.println("修改成功");

        }catch (Exception e){
            trans.rollback();
            e.printStackTrace();
        }

        session.close();

    }
   @Test
    public void queryUsers(){
        Session session=sf.openSession();
        Query q=session.createQuery("from User5");
        List<User5> list=q.list();
        Iterator<User5> it=list.iterator();
        while(it.hasNext()){
            User5 user=it.next();
            System.out.printf("%s--%s--%s\n",
                    user.getUsername(),user.getSex(),user.getAge());
        }
        System.out.println("查询成功");
        session.close();
    }
}
