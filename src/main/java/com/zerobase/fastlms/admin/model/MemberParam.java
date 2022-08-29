package com.zerobase.fastlms.admin.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberParam extends CommonParam {
    
    String userId;
    LocalDate lastLoggedIn;
    
}
