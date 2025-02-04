package com.culture.BAEUNDAY.service;

import com.culture.BAEUNDAY.domain.Refresh;
import com.culture.BAEUNDAY.repository.RefreshRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshRepository refreshRepository;

    //사용자에게 발급한 refresh 토큰을 저장하는 화이트리스트
    @Transactional
    public void saveRefresh(String username, String refresh, Integer expireS) {
        Refresh refreshEntity = Refresh.builder()
                .username(username)
                .refresh(refresh)
                .expiration(new Date(System.currentTimeMillis() + expireS * 1000L).toString())
                .build();

        refreshRepository.save(refreshEntity);
    }

}
