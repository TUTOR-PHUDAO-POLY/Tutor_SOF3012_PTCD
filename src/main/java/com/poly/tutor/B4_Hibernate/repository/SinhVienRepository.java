package com.poly.tutor.B4_Hibernate.repository;

import com.poly.tutor.B4_Hibernate.entity.SinhVien1;
import com.poly.tutor.B4_Hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class SinhVienRepository {

    // J3: Mo cong ket noi Connection
    // J4: Mo 1 phien Session
    private Session session;

    public SinhVienRepository() {
        // mo phien session tai day
        session = HibernateUtil.getFACTORY().openSession();
    }

    // CRUD
    // getall
    // => ds
    public List<SinhVien1> getAll() {
        return session.createQuery("FROM SinhVien1 ").list();
    }

    // SELECT * FROM sinh_vien WHERE id = 1
    public SinhVien1 getOne(Integer id) {
        return session.find(SinhVien1.class, id);
    }

    // transation
    public void add(SinhVien1 sv){
        try{
            session.getTransaction().begin();
            // add : save, saveOrUpdate, persist
            session.persist(sv);
            // commit
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace(); // Loi
            session.getTransaction().rollback(); // quay ve trang thai ban dau
        }
    }

    public void update(SinhVien1 sv){
        try{
            session.getTransaction().begin();
            // update : saveOrUpdate, merge
            session.merge(sv);
            // commit
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace(); // Loi
            session.getTransaction().rollback(); // quay ve trang thai ban dau
        }
    }

    public void delete(SinhVien1 sv){
        try{
            session.getTransaction().begin();
            // delete : delete
            session.delete(sv);
            // commit
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace(); // Loi
            session.getTransaction().rollback(); // quay ve trang thai ban dau
        }
    }

    public static void main(String[] args) {
        System.out.println(new SinhVienRepository().getAll());

//        System.out.println(new SinhVienRepository().getOne(1));
    }
}
