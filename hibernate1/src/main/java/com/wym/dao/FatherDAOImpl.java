package com.wym.dao;

import com.wym.po.Father;
import com.wym.po.Son;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Iterator;

public class FatherDAOImpl {
    private Configuration configuration;
    private SessionFactory sf;
    public FatherDAOImpl(){
        configuration=new Configuration().configure("hibernate.cfg.xml");
        sf=configuration.buildSessionFactory();
    }
    @Test
    public void addUsers(){
        Session session=sf.openSession();
        Transaction transaction=session.getTransaction();
        try{
            transaction.begin();
            Father father=new Father();
            father.setFid(2);
            father.setFname("吴云明");

            Son s1=new Son();
            s1.setSid(3);
            s1.setSname("吴宇");

            s1.setFather(father);

            Son s2=new Son();
            s2.setSid(4);
            s2.setSname("吴妍");

            s2.setFather(father);

            father.getSons().add(s1);
            father.getSons().add(s2);
            session.save(father);
            transaction.commit();

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }

        session.close();
    }
    @Test
    public void delUsers(){
       Session session=sf.openSession();
       Transaction transaction=session.getTransaction();
       try{
           transaction.begin();
           Father father=session.load(Father.class,1);
           session.delete(father);
           transaction.commit();

       }catch (Exception e){
           transaction.rollback();
           e.printStackTrace();
       }

       session.close();
    }
    @Test
    public void updateUsers(){
      Session session=sf.openSession();
      Transaction transaction=session.getTransaction();
      try{
          transaction.begin();
          Father father=session.load(Father.class,1);
          father.setFname("黑龙江");
          Object o[]=father.getSons().toArray();
          ((Son)o[0]).setSname("哈尔滨");
          ((Son)o[1]).setSname("佳木斯");
          session.update(father);
          transaction.commit();

      }catch (Exception e){
          transaction.rollback();
          e.printStackTrace();
      }

      session.close();
    }
    @Test
    public void queryUsers(){
     Session session=sf.openSession();
     Father father=session.load(Father.class,2);
     Iterator<Son> it=father.getSons().iterator();
     System.out.println(father.getFname());
     while(it.hasNext()){
         System.out.println(it.next().getSname());
     }
     session.close();
    }
@Test
public void test(){
    Father father=query();
    System.out.println(father.getFname());
    Iterator<Son> iterator=father.getSons().iterator();
    while(iterator.hasNext()){
          System.out.println(iterator.next().getSname());
     }

}
    public Father query() {
        Session session = sf.openSession();
        Son son = session.load(Son.class,3);
        if (!Hibernate.isInitialized(son.getFather())) {
            Hibernate.isInitialized(son.getFather());
        }
        if (!Hibernate.isInitialized(son.getFather().getSons())) {
            Hibernate.isInitialized(son.getFather().getSons());
        }

        session.close();
        return son.getFather();
    }
}
