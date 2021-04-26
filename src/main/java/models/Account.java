package models;

import lombok.Data;

@Data
public class Account {
    private String email;
    private String password;
    private String confirmPassword;
    private String pid;
}
