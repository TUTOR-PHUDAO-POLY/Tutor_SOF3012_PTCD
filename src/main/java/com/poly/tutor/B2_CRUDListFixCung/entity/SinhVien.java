package com.poly.tutor.B2_CRUDListFixCung.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // contructor k ts
@AllArgsConstructor // contructor full ts
@Getter
@Setter
@ToString
@Builder // contructor tuy y ts
public class SinhVien {
    //    Khai bao cac thuoc tinh
    // TEN BIEN PHAI DUNG CONVENTION => THUONG
    private String mssv;
    private String ten;
    private int tuoi;
    private String diaChi;
    private boolean gioiTinh;

}
