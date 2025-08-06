package com.jungmo.mission1.membership;

public class Member {
    String name;
    String phoneNumber;
    int point;
    Member(String name,String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.point = 0;
    }
    Member(String name, String phoneNumber, int point){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.point = point;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point += point;
    }
}
