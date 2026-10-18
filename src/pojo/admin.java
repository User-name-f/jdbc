package pojo;

public class admin {
    Integer id;
    String username;
    String password;
    String real_name;
    String dept_name;

    public admin() {
    }

    public admin(Integer id, String username, String password, String real_name, String dept_name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.real_name = real_name;
        this.dept_name = dept_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
}
