package ftn.jwd.web.dto;

import javax.validation.constraints.Pattern;

public class UserChangePasswordDto {

    private String UserName;

    private String oldPassword;

    @Pattern(regexp = "^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$")
    private String password;

    private String repeatedPassword;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getStaraPassword() {
        return oldPassword;
    }

    public void setStaraPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPonovljenaPassword() {
        return repeatedPassword;
    }

    public void setPonovljenaPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
}
