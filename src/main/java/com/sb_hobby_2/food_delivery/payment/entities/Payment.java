package com.sb_hobby_2.food_delivery.payment.entities;

import com.sb_hobby_2.food_delivery.auth_user.entities.User;
import com.sb_hobby_2.food_delivery.enums.PaymentGateway;
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
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private String transactionId;

    @Enumerated(EnumType.STRING)
    private PaymentGateway paymentGateway;

    private String failureReason;

    private LocalDateTime paymentDate;

    //relationship

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
