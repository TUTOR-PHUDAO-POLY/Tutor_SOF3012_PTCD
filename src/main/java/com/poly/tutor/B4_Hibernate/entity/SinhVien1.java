package com.poly.tutor.B4_Hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "sinh_vien")
@NoArgsConstructor // contructor khong ts
@AllArgsConstructor // contructor full ts
@Getter
@Setter
@ToString
public class SinhVien1 {
    /**
     * JDBC -> SQL truy van
     * Hibernate -> Truy van tren thuc the => HQL(Hibernate Query Language)
     * Truy van tren class
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma")
    private String ma1;

    @Column
    private String ten;

    @Column
    private Long tuoi;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

}
