package com.zerobase.fastlms.member.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberUserPasswordInput {

    private String username;
    private String password;
}
