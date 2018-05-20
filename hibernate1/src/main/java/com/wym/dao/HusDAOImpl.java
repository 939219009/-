package com.wym.dao;

import com.wym.po.Hus;
import com.wym.po.Wife;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import javax.security.auth.login.AppConfigurationEntry;
import java.util.Iterator;
import java.util.List;


public class HusDAOImpl {
    private Configuration cfg;
    private SessionFactory sf;
    public HusDAOImpl(){
        cfg=new Configuration().configure("hibernate.cfg.xml");
        sf=cfg.buildSessionFactory();
    }
    @Test
    public void addUsers(){
       Session session=sf.openSession();
       Transaction transaction=session.getTransaction();
       transaction.begin();
       Hus hus=new Hus();
       hus.setId(1);
       hus.setHname("wym");

       Wife wife=new Wife();
       wife.setId(1);
       wife.setWname("she");

       hus.setWife(wife);
       wife.setHus(hus);
       session.save(hus);
       transaction.commit();
       System.out.println("添加成功");
       session.close();
    }
    @Test
    public void delUsers(){
        Session session=sf.openSession();
        Transaction trans=session.getTransaction();
        try{
            trans.begin();
            Hus hus=session.load(Hus.class,1);
            session.delete(hus);
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
        Transaction transaction=session.getTransaction();
        transaction.begin();
        Hus hus=session.load(Hus.class,1);
        hus.getWife().setWname("ly");//不可修改主键的内容
        session.update(hus);
        transaction.commit();
        System.out.println("修改成功");
        session.close();
    }
    @Test
    public void queryUsers()  {
        Session session=sf.openSession();

        Hus hus=session.load(Hus.class,1);
        System.out.printf("%s--%s",hus.getHname(),hus.getWife().getWname());
        System.out.println("查询成功");
        session.close();
    }
}
