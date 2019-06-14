package com.authentication.businessBO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginByEmailBO {

    private String emailId;
    private String password;

    @Override
    public String toString(){
        return "Emailid: " + getEmailId();
    }

}
