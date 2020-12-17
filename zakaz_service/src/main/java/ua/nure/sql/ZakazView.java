package ua.nure.sql;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Immutable
@Table(name = "zakaz_snapshot")
//@NamedNativeQuery(name = "zakaz_snapshot", query = "select * from zakaz_snapshot", resultClass = ua.nure.entity.ZakazView.class)
public class ZakazView {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "zakaz_id")
    protected int zakazId;
    @Column(name = "user_id")
    protected int userId;
    @Column(name = "user_fullname")
    protected String userFullname;
    @Column(name = "telephone")
    protected String telephone;
    @Column(name = "create_date_time")
    protected Timestamp createDateTime;
    @Column(name = "Address1")
    protected String address1;
    @Column(name = "Address2")
    protected String address2;
    @Column(name = "category")
    protected String category;
    @Column(name = "assign_date_time")
    protected Timestamp assignDateTime;
    @Column(name = "auto_id")
    protected int autoId;
    @Column(name = "order_status")
    protected String orderStatus;
    @Column(name = "sign_number")
    protected String signNumber;
    @Column(name = "driver_fullname")
    protected String driverFullname;
    @Column(name = "auto_name")
    protected String autoName;

}
