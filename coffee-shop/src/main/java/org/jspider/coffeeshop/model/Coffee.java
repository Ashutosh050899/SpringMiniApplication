package org.jspider.coffeeshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="coffee_shop")

public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_no")
    private int orderNo;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_order")
    private String customerOrder;
    @Column(name = "total_bill")
    private double totalBill;

}
