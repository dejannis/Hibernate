package db;

import main.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Db {

    public void insertWorker(Worker worker){
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(worker);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.close();
        }
    }

    public void deleteWorker(int id) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "delete from Worker w where w.id = " + id;
            Query query = session.createQuery(hql);
            query.executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.close();
        }
    }


    public void updateWorker(Worker worker) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            String hql = "update Worker w set w.name = '" + worker.name + "', w.age = " + worker.age + ", w.address = '" + worker.address + "', w.salary = " + worker.salary + " where w.id = " + worker.id;
            Query query = session.createQuery(hql);
            query.executeUpdate();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.close();
        }
    }

    public List<Worker> getAllWorkers() {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        List<Worker> list = new ArrayList();
      try {
        tx = session.beginTransaction();
        String hql = "from Worker";
        Query query = session.createQuery(hql);
        list = query.list();
        tx.commit();
      } catch (HibernateException e) {
          if (tx != null) {
              tx.rollback();
          }
          e.printStackTrace();
      } finally {
          HibernateUtil.close();
      }
      return list;
    }

    public Worker getWorker(int id) {
        Worker worker = null;
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "from Worker as w where w.id = " + id;
            Query query =  session.createQuery(hql);
            List<Worker> workerList = query.list();
            if(!workerList.isEmpty()) {
                worker = workerList.get(0);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.close();
        }
        return worker;
    }

    public Worker getWorkerByName(String name) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        Worker worker = null;
        try {
            tx = session.beginTransaction();
            String hgl = "from Worker as w where w.name = '" + name + "'";
            Query query =  session.createQuery(hgl);
            List<Worker> workerList = query.list();
            if(!workerList.isEmpty()) {
                worker = workerList.get(0);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.close();
        }
        return worker;
    }

}
