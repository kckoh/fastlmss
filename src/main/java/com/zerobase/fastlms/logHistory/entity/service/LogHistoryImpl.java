package com.zerobase.fastlms.logHistory.entity.service;

import com.zerobase.fastlms.logHistory.entity.LogHistory;
import com.zerobase.fastlms.logHistory.entity.dto.LogHistoryDto;
import com.zerobase.fastlms.logHistory.entity.repository.LogHistoryRepository;
import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.repository.MemberRepository;
import com.zerobase.fastlms.util.RequestUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class LogHistoryImpl implements LogHistoryService {

    private final LogHistoryRepository logHistoryRepository;
    private final MemberRepository memberRepository;

    @Override
    public void add(Member member, HttpServletRequest request) {
        List<String> memberId = Arrays.asList(member.getUserId());
        LocalDateTime loggedTime = LocalDateTime.now();
        member.setLastLoggedIn(loggedTime);
        memberRepository.save(member);
        logHistoryRepository.save(
                LogHistory.builder()
                        .logId(member.getUserId())
                        .loggedInDate(loggedTime)
                        .clientIP(RequestUtils.getClientIP(request))
                        .userAgent(RequestUtils.getUserAgent(request))
                        .build()
        );

        List<LogHistoryDto> dtos = new ArrayList<>();
//        return dtos;
    }

    @Override
    public List<LogHistoryDto> findList(Member member) {
        List<LogHistoryDto> dtos = new ArrayList<>();

        Optional<Member> userId = memberRepository.findById(member.getUserId());
        if (!userId.isPresent()) {
            return dtos;
        }
        List<String> memberIDs = Arrays.asList("23");
        log.info(memberIDs.toString());
//        log.info(member.getUserId());
        List<LogHistory> allById = logHistoryRepository.findAllById(memberIDs);
//        log.info("====== LogHistory all by id " + allById.toString() + " size checking");
//        log.info(allById.toString());
        allById.stream().forEach((x) -> dtos.add(
                LogHistoryDto.of(x)
        ));
        log.info(allById.toString());
//        log.info(dtos.toString());

        return dtos;
    }

}
