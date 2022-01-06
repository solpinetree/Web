package com.lec.spring.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {  // DTO
    private int uid;  // mb_uid
    private String id;  // mb_id username
    private String pw; // mb_pw password
    private String email; // mb_email
    private String enabled; // mb_enabled
    private LocalDateTime regDate; // mb_regdate
}
