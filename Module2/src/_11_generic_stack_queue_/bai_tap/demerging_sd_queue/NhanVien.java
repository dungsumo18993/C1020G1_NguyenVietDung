package _11_generic_stack_queue_.bai_tap.demerging_sd_queue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NhanVien implements Comparable<NhanVien>{
    private String name;
    private String gender;
    private Date birthday;

    public NhanVien(String name, String gender, String ngaysinh) throws ParseException {
        this.name = name;
        this.gender = gender;
        this.birthday = new SimpleDateFormat("dd/MM/yyyy").parse(ngaysinh);
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    @Override
    public int compareTo(NhanVien o) {
        return this.birthday.compareTo(o.birthday);
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday + "\n";
    }
}
