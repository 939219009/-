package com.wym.service;

import com.wym.model.Company;
import com.wym.model.Emp;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class CompanyService {
    SqlSessionFactory ssf=null;
    public CompanyService(){
        InputStream is=this.getClass().getClassLoader().getResourceAsStream("mybatis.cfg.xml");
        ssf=new SqlSessionFactoryBuilder().build(is);
    }
    @Test
    public void queryCompany(){
        SqlSession session=ssf.openSession();
        Company c=new Company();
        c.setCid(2);
        Company com=session.selectOne("com.wym.mapper.CompanyMapper.selectByPrimaryKey",c);
        System.out.println(com.getName());
        List<Emp> list= (List<Emp>) com.getElist();
        for(Emp emp : list){
            System.out.println(emp.getName());
        }
        session.close();
    }
    @Test
    public void queryEmp(){
        SqlSession session =ssf.openSession();
        Emp emp=new Emp();
        emp.setEid(1);
        Emp e=session.selectOne("com.wym.mapper.EmpMapper.selectByPrimaryKey",emp);
        System.out.println(e.getName());
        List<Company> com= (List) e.getCompany();
        System.out.println(com.get(0).getName());
        session.close();
    }

}
