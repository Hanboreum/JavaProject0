package kr.excel.entity;

public class MemberVO {

    private String name;
    private int age;
    private String birthday;
    private boolean isMarried;

    public MemberVO(){}
    public MemberVO(String name, int age, String birthday, boolean isMarried) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.isMarried = isMarried;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    @Override
    public String toString() {
        return "MemberVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                ", isMarried=" + isMarried +
                '}';
    }
}
