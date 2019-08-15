package me.spring_boot_init.demo.domain;

import lombok.Data;
//lombok이 user쓸 대 getters setters를 많이 쓴다.
//왜냐면 데이터를 클래스로 담어서 입력하고 뽑기도 하고 그러니까
//lombok annotation은 자동으로 해준다

@Data
public class User{
    private String UUID;
    private String USERNAME;
    private String SSN;
    private String PW;
    private String JOB;
    private int MONEY;
    private int F_NUM;
}