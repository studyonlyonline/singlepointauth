package com.authentication.beans.businessBO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginByEmailBO {

    private String emailId;
    private String password;
    private String organizationId;

    @Override
    public String toString() {
        return "Emailid: " + getEmailId() + " Organization: "+getOrganizationId();
    }

}
