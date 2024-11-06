package com.poly.tutor.B2_CRUDListFixCung.repository;

import com.poly.tutor.B2_CRUDListFixCung.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienRepository {

    private List<SinhVien> listSinhVien = new ArrayList<>();

    public SinhVienRepository() {
        // add cac doi tuong
        // lombox => thu contructor full ts => thu tu khai bao bien
        listSinhVien.add(new SinhVien("HE130461", "Nguyen Van A", 10, "Ha noi", true));
        listSinhVien.add(new SinhVien("HE130462", "Nguyen Van B", 11, "Ha noi1", false));
        listSinhVien.add(new SinhVien("HE130463", "Nguyen Van C", 12, "Ha noi2", true));
        listSinhVien.add(new SinhVien("HE130464", "Nguyen Van D", 15, "Ha noi3", false));
        listSinhVien.add(new SinhVien("HE130465", "Nguyen Van E", 16, "Ha noi4", true));
    }

    public List<SinhVien> getListSinhVien() {
        return listSinhVien;
    }

    public void removeSinhVien(String mssv) {
//        listSinhVien.removeIf(s -> s.getMssv().equalsIgnoreCase(mssv));
        listSinhVien.removeIf(sv -> sv.getMssv().equalsIgnoreCase(mssv));
//        for (SinhVien sv:listSinhVien) {
//
//        }
    }

    public SinhVien detailSinhVien(String mssv) {
        // C1: for bt
//        for (SinhVien sv : listSinhVien) {
//            if (sv.getMssv().equalsIgnoreCase(mssv)) {
//                return sv;
//            }
//        }
//        return null;
        // C2: lamda
        return listSinhVien.stream()
                .filter(sv -> sv.getMssv().equalsIgnoreCase(mssv))
                .findFirst() // lay ra gia tri cua phan tu dau tien
                .orElse(null);
    }

    public void addSinhVien(SinhVien sv) {
        listSinhVien.add(sv);
    }

    public static void main(String[] args) {
//        for(SinhVien sv:lists){
//
//        }
    }
}
