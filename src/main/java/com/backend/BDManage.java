package com.backend;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class BDManage {

    private Session sesion;
    public BDManage() {
        this.sesion=HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        return this.sesion;
    }

}
