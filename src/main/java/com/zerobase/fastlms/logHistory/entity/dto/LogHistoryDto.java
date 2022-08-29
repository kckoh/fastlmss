package com.zerobase.fastlms.logHistory.entity.dto;


import com.zerobase.fastlms.logHistory.entity.LogHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LogHistoryDto {

    String id;
    Long logID;
    LocalDateTime loggedInDate;
    String clientIP;
    String userAgent;

    public static LogHistoryDto of(LogHistory logHistory) {
       return LogHistoryDto.builder()
                .id(logHistory.getId())
//                .logID(logHistory.getLogID())
                .loggedInDate(logHistory.getLoggedInDate())
                .clientIP(logHistory.getClientIP())
                .userAgent(logHistory.getUserAgent())
                .build();
    }

}