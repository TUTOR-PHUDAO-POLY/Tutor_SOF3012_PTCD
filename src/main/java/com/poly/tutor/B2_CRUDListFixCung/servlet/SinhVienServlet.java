package com.poly.tutor.B2_CRUDListFixCung.servlet;

import com.poly.tutor.B2_CRUDListFixCung.entity.SinhVien;
import com.poly.tutor.B2_CRUDListFixCung.repository.SinhVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",   // GET
        "/sinh-vien/search",     // GET
        "/sinh-vien/remove",    // GET
        "/sinh-vien/detail",    // GET
        "/sinh-vien/view-update", // GET
        "/sinh-vien/view-add",    // GET
        "/sinh-vien/add",   // POST: lam viec voi form
        "/sinh-vien/update",    // POST
})
public class SinhVienServlet extends HttpServlet {
    /**
     * GET & POST
     */
    private SinhVienRepository repository = new SinhVienRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 6 duong dan => do get
        // value => uri cua 1 duong dan
        // B1: Lay ra uri
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            //Hien thi du lieu
            this.hienThiDanhSachSinhVien(request, response);
        } else if (uri.contains("search")) {
            //Search
            this.searchSinhVien(request, response);
        } else if (uri.contains("remove")) {
            //Xoa
            this.xoaSinhVien(request, response);
        } else if (uri.contains("detail")) {
            //detail
            this.detailSinhVien(request, response);
        } else if (uri.contains("view-update")) {
            // view update
            this.viewUpdate(request, response);
        } else {
            // view add
            this.viewAdd(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 2 duong dan => do post
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            //add
            this.addSinhVien(request, response);
        } else {
            //update
            this.updateSinhVien(request, response);
        }
    }

    private void updateSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void xoaSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiDanhSachSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Goi ra list get all trong repository
        List<SinhVien> listSinhVien = repository.getListSinhVien();
        // B2: Truyen gia tri tu servlet => jsp : request.setAttribute
        request.setAttribute("a1", listSinhVien);
        // B3: Chuyen trang
        request.getRequestDispatcher("/view/buoi2/sinhviens.jsp").forward(request, response);
    }
}
