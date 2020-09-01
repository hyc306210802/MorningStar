package com.cmbroot.entity;

public class User {
    /***
     * 用户年龄
     */
    private Integer age;
    /***
     * 用户性别
     */
    private String gender;
    /***
     * 退休年龄
     */
    private Integer retiredYear;

    /***
     * 身高
     */
    private Float Height;

    /***
     * 体重
     */
    private Float Weight;


    public Float getHeight() {
        return Height;
    }

    public Float getWeight() {
        return Weight;
    }

    public void setHeight(Float height) {
        Height = height;
    }

    public void setWeight(Float weight) {
        Weight = weight;
    }

    public Integer getRetiredYear() {
        return retiredYear;
    }

    public void setRetiredYear(Integer retiredYear) {
        this.retiredYear = retiredYear;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }
}
