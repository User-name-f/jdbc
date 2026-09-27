package pojo;

public class student {
    Integer id;
    String student_no;
    String name;
    String gender;
    String college;
    String major;
    String clazz_name;
    Integer status;
    Integer enroll_year;
    String phone;

    public Integer getClazz_id() {
        return clazz_id;
    }

    public void setClazz_id(Integer clazz_id) {
        this.clazz_id = clazz_id;
    }

    Integer clazz_id;

    public student() {
    }

    public student(Integer id, String student_no, String name, String gender, String college, String major, String clazz_name, Integer status, Integer enroll_year, String phone) {
        this.id = id;
        this.student_no = student_no;
        this.name = name;
        this.gender = gender;
        this.college = college;
        this.major = major;
        this.clazz_name = clazz_name;
        this.status = status;
        this.enroll_year = enroll_year;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudent_no() {
        return student_no;
    }

    public void setStudent_no(String student_no) {
        this.student_no = student_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClazz_name() {
        return clazz_name;
    }

    public void setClazz_name(String clazz_name) {
        this.clazz_name = clazz_name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEnroll_year() {
        return enroll_year;
    }

    public void setEnroll_year(Integer enroll_year) {
        this.enroll_year = enroll_year;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", student_no=" + student_no +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", clazz_name='" + clazz_name + '\'' +
                ", status='" + status + '\'' +
                ", enroll_year='" + enroll_year + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
