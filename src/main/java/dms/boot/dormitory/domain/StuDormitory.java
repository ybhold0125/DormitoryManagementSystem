package dms.boot.dormitory.domain;

public class StuDormitory {
    private int id;
    private String studentId;
    private int dorId;
    private int bedNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getDorId() {
        return dorId;
    }

    public void setDorId(int dorId) {
        this.dorId = dorId;
    }

    public int getBedNum() {
        return bedNum;
    }

    public void setBedNum(int bedNum) {
        this.bedNum = bedNum;
    }

    @Override
    public String toString() {
        return "StuDormitory{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", dorId=" + dorId +
                ", bedNum=" + bedNum +
                '}';
    }
}
