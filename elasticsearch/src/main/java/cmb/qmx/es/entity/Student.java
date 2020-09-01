package cmb.qmx.es.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 80254142
 * @description
 * @date
 */
public class Student implements Serializable {
    private String code;
    private String gender;
    private String interest;
    private String name;
    private Integer age;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "GMT+8")
    private Date es_index_time;

    public Student(String id, String gender,String name, int age, Date date, String interest) {
        this.code = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.es_index_time = date;
        this.interest = interest;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getRegisterTime() {
        return es_index_time;
    }

    public void setRegisterTime(Date registerTime) {
        this.es_index_time = registerTime;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }



    @Override
    public String toString() {
        return "interest:'" + interest + '\'' +
                ", registerTime:" + es_index_time +
                ", gender:'" + gender + '\'' +
                ", age:" + age +
                ", name:'" + name + '\'' +
                ", code:'" + code + '\'';
    }
}
