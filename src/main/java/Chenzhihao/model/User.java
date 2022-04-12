package Chenzhihao.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.FileStore;

public class User {
    private String id;
    private String username;
    private String password;
    private String email;

    HttpServletRequest request;
    HttpServletResponse response;
    public User(){
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getId() {
        id = String.valueOf(request.getAttribute("id"));
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        username = String.valueOf(request.getAttribute("use"));
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        password = String.valueOf(request.getAttribute("pas"));
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String id, String username, String password, String email){
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
