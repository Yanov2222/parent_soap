package ua.nure.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.nure.entity.Auto;
import ua.nure.utils.HibernateSessionFactoryUtil;

import java.util.List;


@SuppressWarnings("ALL")
public class AutoDao {

    public List<Auto> findAll(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Auto");
        List<Auto> list = query.list();
        return list;
    }

    public List<Auto> findFilter(String category){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Auto where category=:category",Auto.class);
        query.setParameter("category",category);
        List<Auto> list = query.list();
        session.close();
        return list;
    }

    public void save(Auto auto){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(auto);
        transaction.commit();
        session.close();
    }

    public void update(Auto auto){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(auto);
        transaction.commit();
        session.close();
    }

    public void delete(Auto auto){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(auto);
        transaction.commit();
        session.close();
    }
}
