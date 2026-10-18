package pojo;

/**
 * 班级实体，对应数据库里的 t_clazz 表。
 * 添加学生时“班级”下拉框的内容就是从这张表里查出来的。
 */
public class Clazz {
    Integer id;
    String clazz_name;
    String college;
    String major;
    Integer grade;

    public Clazz() {
    }

    public Clazz(Integer id, String clazz_name, String college, String major, Integer grade) {
        this.id = id;
        this.clazz_name = clazz_name;
        this.college = college;
        this.major = major;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClazz_name() {
        return clazz_name;
    }

    public void setClazz_name(String clazz_name) {
        this.clazz_name = clazz_name;
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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", clazz_name='" + clazz_name + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", grade=" + grade +
                '}';
    }
}
