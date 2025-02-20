package fpl.asm_java5.Beans;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginBean {
    private String username;
    private String password;


    // Kiểm tra lỗi khi đặt username
    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username không được để trống");
        }
        this.username = username.trim();
    }

    // Kiểm tra lỗi khi đặt password
    public void setPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password không được để trống");
        }
        if (password.length() < 6) {
            throw new IllegalArgumentException("Password phải hơn 6 ký tự");
        }
        this.password = password;
    }
}
