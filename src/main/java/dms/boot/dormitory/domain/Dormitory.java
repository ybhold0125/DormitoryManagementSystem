package dms.boot.dormitory.domain;

public class Dormitory {
    private int id;
    private String dormitoryNum;
    private int bed;
    private int peopleNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDormitoryNum() {
        return dormitoryNum;
    }

    public void setDormitoryNum(String dormitoryNum) {
        this.dormitoryNum = dormitoryNum;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    @Override
    public String toString() {
        return "Dormitory{" +
                "id=" + id +
                ", dormitoryNum='" + dormitoryNum + '\'' +
                ", bedNum=" + bed +
                ", peopleNum=" + peopleNum +
                '}';
    }
}
