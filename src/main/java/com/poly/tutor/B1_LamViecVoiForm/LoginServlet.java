package com.poly.tutor.B1_LamViecVoiForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = {
        // LIET KE CAC DUONG DAN TRONG DE BAI
        "/login1",
        "/ket-qua",
})
// ctrl D => duplicate nhanh cac dong
public class LoginServlet extends HttpServlet {
    /**
     * servlet -> java class: duoc cau hinh de co the chua duoc cac duong dan
     * jsp -> GIONG HTML( CAC THE DE LAM GIAO DIEN): <table> ..<a></a></table>
     * servlet :
     * 1. Name : ten servlet: CO THE CO HOAC KHONG
     * 2. value: day la noi chua duong dan cua trinh duyet : BAT BUOC PHAI CO 1 SERVLET
     * value => LIET KE TAT CA CAC DUONG DAN CO TRONG DE BAI
     * 2 duong dan => value
     * CHU Y:
     * 1. DUONG DAN BAT DAU BANG DAU /
     * 2. DUONG DAN LA DUY NHAT (UNIQUE - DUY NHAT TRONG 1 PROJECT)
     * <p>
     * Lam the nao de servlet trao doi duoc vs jsp (Lam the nao BE & FE)
     * => HTTP METHOD: GET, POST, PUT, DELETE
     * (Read- Select , Create - Insert into, Update, Delete)
     * J4, J5: CHI DUNG 2 PHUONG THUC GET & POST:
     * + GET: HIEN THI, LAY DU LIEU RA TRONG SQL , SEARCH... => doGet
     * + POST: XU LY FORM => doPost
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // /login -> hien thi giao dien nhu hinh
        // CHUYEN SANG TRANG MOI
        // C1: request.getRequestDispatcher
        request.getRequestDispatcher("form-login1.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Do post
        // B1: Lay GIÁ TRỊ TỪ CÁC Ô INPUT (JSP) - SERVLET
        //  => LẤY THÔNG QUA THUỘC TINH NAME CỦA CÁC Ô INPUT
        // request.getParameter(ten cua o input ben phia jsp)
        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        // Co bn o input => request.getParameter bang day lan
        // B2: Day du lieu tu phia servlet -> ve phia jsp
        // request.setAttribute
        int number = 5;
        // number : ten bien do cac ban dat <=> a
        request.setAttribute("a",name);
        request.setAttribute("b1",pass);
        // B3: Chuyen trang
        request.getRequestDispatcher("ket-qua-login.jsp").forward(request, response);
    }
}
