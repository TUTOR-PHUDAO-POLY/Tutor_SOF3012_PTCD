package com.poly.tutor.B4_Hibernate.servlet;

import com.poly.tutor.B4_Hibernate.repository.SinhVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SinhVien1Servlet", value = {
        "/sinh-vien1/hien-thi",      //get
        "/sinh-vien1/search",        //get
        "/sinh-vien1/remove",        //get
        "/sinh-vien1/detail",        //get
        "/sinh-vien1/view-update",   //get
        "/sinh-vien1/view-add",      //get
        "/sinh-vien1/update",        //post
        "/sinh-vien1/add"            //post
})
public class SinhVien1Servlet extends HttpServlet {

    private SinhVienRepository repository = new SinhVienRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
