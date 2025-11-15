package com.sb_hobby_2.food_delivery.order.entities;

import com.sb_hobby_2.food_delivery.auth_user.entities.User;
import com.sb_hobby_2.food_delivery.enums.OrderStatus;
import com.sb_hobby_2.food_delivery.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate;

    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    //relationships
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
