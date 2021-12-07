package com.example.demo.config_security;





import java.util.List;

public class JwtResponse {
    // UsernamePasswordAuthenticationToken {tên người dùng, mật khẩu} từ Yêu cầu đăng nhập,
    // AuthenticationManager sẽ sử dụng nó để xác thực tài khoản đăng nhập.

    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String userTime;
//    private Employee employee;
    private List<String> roles;

    public JwtResponse() {
    }

    public JwtResponse(String token, Long id, String username, String userTime, List<String> roles) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.userTime = userTime;

        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserTime() {
        return userTime;
    }

    public void setUserTime(String userTime) {
        this.userTime = userTime;
    }


    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}