package com.culture.BAEUNDAY.domain.post;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post_tb")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @Column(nullable = false)
    private Long user_id;

    @Column
    private String imgURL;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String goal;

    @Column(nullable = false)
    private String outline;

    @Column(nullable = false)
    private String targetStudent;

    @Column(nullable = false)
    private String level;

    @Column(nullable = false)
    private String contactMethod;

    @Column(nullable = false)
    private Integer fee;

    @Column(nullable = false)
    private LocalDateTime startDate ;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Province province;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private int minP;

    @Column(nullable = false)
    private int maxP;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private LocalDateTime createdDate ;

    @Column(nullable = false)
    private LocalDateTime deadline;

    @Column()
    private Long numsOfHeart;

    public void update(String title, String imgURL, String subject, String goal, String outline,
                       String targetStudent, String level, String contactMethod, Integer fee,
                       LocalDateTime startDate, LocalDateTime endDate, Province province, String city,
                       String address, int minP, int maxP, String content, Status status,
                       LocalDateTime createdDate, LocalDateTime deadline, Long numsOfHeart) {

        this.title = title;
        this.imgURL = imgURL;
        this.subject = subject;
        this.goal = goal;
        this.outline = outline;
        this.targetStudent = targetStudent;
        this.level = level;
        this.contactMethod = contactMethod;
        this.fee = fee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.province = province;
        this.city = city;
        this.address = address;
        this.minP = minP;
        this.maxP = maxP;
        this.content = content;
        this.status = status;
        this.createdDate = createdDate;
        this.deadline = deadline;
        this.numsOfHeart = numsOfHeart;
    }




}
