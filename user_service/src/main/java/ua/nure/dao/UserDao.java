package ua.nure.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.nure.entity.User;
import ua.nure.utils.HibernateSessionFactoryUtil;

import java.util.List;


@SuppressWarnings("Duplicates")
public class UserDao {

    public User findByLogin(String login){
        Session session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from User where login=:login");
        query.setParameter("login", login);
        User user = (User) query.uniqueResult();
        session.close();
        return user;
    }

    public void save(User user){
        Session session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void update(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public List<User> findAll(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from User");
        List<User> list = query.list();
        session.close();
        return list;
    }
}
