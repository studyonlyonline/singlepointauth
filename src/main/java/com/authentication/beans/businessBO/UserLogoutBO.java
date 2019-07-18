package com.authentication.beans.businessBO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLogoutBO {
    private String emailId;
    private String ssoToken;
}
