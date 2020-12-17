package ua.nure.sql;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "zakaz")
@Data
public class Zakaz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(name = "Address1")
    protected String address1;
    @Column(name = "Address2")
    protected String address2;
    @Column(name = "category")
    protected String category;
    @Column(name = "create_date_time")
    protected Timestamp createDateTime;
    @Column(name = "assign_date_time")
    protected Timestamp assignDateTime;
    @Column(name = "auto_id")
    protected int autoId;
    @Column(name = "order_status")
    protected String orderStatus;
    @Column(name = "user_id")
    protected int userId;

}