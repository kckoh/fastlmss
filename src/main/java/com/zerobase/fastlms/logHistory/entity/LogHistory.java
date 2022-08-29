package com.zerobase.fastlms.logHistory.entity;


import com.zerobase.fastlms.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class LogHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;


    private String logId;

    LocalDateTime loggedInDate;
    String clientIP;
    String userAgent;

}
