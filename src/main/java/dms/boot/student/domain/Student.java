package dms.boot.student.domain;

public class Student {
    private Integer id;
    private String name;
    private String gender;
    private String birthday;
    private String address;
    private String phone;
    private String studentId;
    private String college;
    private String profession;
    private String classes;
    private String dormitoryNum;
    private Integer bedNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getDormitoryNum() {
        return dormitoryNum;
    }

    public void setDormitoryNum(String dormitoryNum) {
        this.dormitoryNum = dormitoryNum;
    }

    public int getBedNum() {
        return bedNum;
    }

    public void setBedNum(int bedNum) {
        this.bedNum = bedNum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", studentId='" + studentId + '\'' +
                ", college='" + college + '\'' +
                ", profession='" + profession + '\'' +
                ", classes='" + classes + '\'' +
                ", dormitoryNum='" + dormitoryNum + '\'' +
                ", bedNum=" + bedNum +
                '}';
    }
}
