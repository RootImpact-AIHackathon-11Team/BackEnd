package com.culture.BAEUNDAY.domain.refresh;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table(name = "refresh_tb")
public class Refresh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; //Refresh 토큰이 발급된 유저명
    private String refresh;  //Refresh 토큰
    private String expiration; //Refresh 토큰 유효 기간

    @Builder
    public Refresh(String username, String refresh, String expiration) {
        this.username = username;
        this.refresh = refresh;
        this.expiration = expiration;
    }

    public Refresh() {

    }
}
