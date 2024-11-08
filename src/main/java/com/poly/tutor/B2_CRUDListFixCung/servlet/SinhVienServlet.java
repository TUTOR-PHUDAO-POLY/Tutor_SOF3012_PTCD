package com.poly.tutor.B2_CRUDListFixCung.servlet;

import com.poly.tutor.B2_CRUDListFixCung.entity.SinhVien;
import com.poly.tutor.B2_CRUDListFixCung.repository.SinhVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

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

    @SneakyThrows
    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // B1: Tao ra 1 doi tuong
        // beanutil => dat nam input trung name thuoc tinh entity
        SinhVien sv = new SinhVien();
        // B2: Mapping toan bo cac thuoc tinh cho doi tuong sv
        BeanUtils.populate(sv,request.getParameterMap());
        // B3: goi ham add
        repository.addSinhVien(sv);
        // B4: Quay ve trang chu
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // chuyen trang
        request.getRequestDispatcher("/view/buoi2/add-sinh-vien.jsp").forward(request,response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maSV = request.getParameter("id1");
        SinhVien sv = repository.detailSinhVien(maSV);
        request.setAttribute("sv1",sv);
        request.getRequestDispatcher("/view/buoi2/update-sinh-vien.jsp").forward(request,response);
    }

    private void detailSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maSV = request.getParameter("a");
        SinhVien sv = repository.detailSinhVien(maSV);
        request.setAttribute("sv1",sv);
        request.getRequestDispatcher("/view/buoi2/detail-sinh-vien.jsp").forward(request,response);
    }

    private void xoaSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // B1: Lay ra cai id ma muon xoa
        // (Lay gia tri tu jsp -> servlet): getParameter
        String maSV = request.getParameter("id2");
        // B2: Goi ham ben repo
        repository.removeSinhVien(maSV);
        // B3: Quay lai trang chu
        response.sendRedirect("/sinh-vien/hien-thi");
//        List<SinhVien> listSinhVien = repository.getListSinhVien();
//        request.setAttribute("a1", listSinhVien);
//        request.getRequestDispatcher("/view/buoi2/sinhviens.jsp").forward(request, response);
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
