package com.furkanbulut.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Category {
    public static final String Table = "category";
    private static final String COL_ID = "id";
    public static final String COL_NAME ="name";
    public static final String COL_DESCRIPTION="description";
    private static final String COL_CREATE_DATE = "create_date";
    private static final String COL_PRODUCT_ID = "product_id";

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = COL_ID)
    private String id ;

    @Column(name = COL_NAME)
    private  String name;

    @Column(name = COL_DESCRIPTION)
    private String description;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = COL_CREATE_DATE)
    private Date creaDate;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @Column(name = COL_PRODUCT_ID)
    private List<Product> productList;


}
