package ua.nure.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.nure.entity.Auto;
import ua.nure.sql.Zakaz;
import ua.nure.sql.ZakazView;
import ua.nure.utils.HibernateSessionFactoryUtil;

import java.util.List;

@SuppressWarnings("ALL")
public class ZakazDao {

    public List<Zakaz> readAll(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Zakaz");
        List<Zakaz> list = query.list();
        session.close();
        return list;
    }

    public List<Zakaz> readForUser(int userId){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Zakaz where userId=:userId");
        query.setParameter("userId",userId);
        List<Zakaz> list = query.list();
        session.close();
        return list;
    }

    public List<Zakaz> readForDriver(int driverId){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query readAuto = session.createQuery("from Auto where driverId=:driverId");
        readAuto.setParameter("driverId",driverId);
        Auto auto = (Auto) readAuto.uniqueResult();
        Query query = session.createQuery("from Zakaz where category=:category");
        query.setParameter("category",auto.getCategory());
        List<Zakaz> list = query.list();
        session.close();
        return list;
    }

    public void save(Zakaz zakaz){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(zakaz);
        transaction.commit();
        session.close();
    }

    public void update(Zakaz zakaz){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(zakaz);
        transaction.commit();
        session.close();
    }

    public void delete(Zakaz zakaz){
        Session session =HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(zakaz);
        transaction.commit();
        session.close();
    }

    public List<ZakazView> readSnapshot(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from ZakazView");
        List<ZakazView> list = query.list();
        session.close();
        return list;
    }

    public List<ZakazView> readUserSnapshot(int userId){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from ZakazView where userId=:userId");
        query.setParameter("userId",userId);
        List<ZakazView> list = query.list();
        session.close();
        return list;
    }

    public List<ZakazView> readDriverSnapshot(int driverId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query readAuto = session.createQuery("from Auto where driverId=:driverId");
        readAuto.setParameter("driverId", driverId);
        Auto auto = (Auto) readAuto.uniqueResult();
        Query query = session.createQuery("from ZakazView where autoId=:autoId");
        query.setParameter("autoId", auto.getId());
        List<ZakazView> list = query.list();
        session.close();
        return list;
    }
}
