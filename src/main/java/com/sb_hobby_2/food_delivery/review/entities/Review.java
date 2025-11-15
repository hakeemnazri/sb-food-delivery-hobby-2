package com.sb_hobby_2.food_delivery.review.entities;

import com.sb_hobby_2.food_delivery.auth_user.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rating;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @Column(name = "order_id")
    private Long orderId;

    //relationships
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //timing
    private LocalDateTime createdAt;
}
