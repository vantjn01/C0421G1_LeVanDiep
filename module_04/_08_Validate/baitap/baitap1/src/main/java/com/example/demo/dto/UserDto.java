package com.example.demo.dto;

import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {
    private int id;
    @NonNull
    @Size(min = 2, max = 45, message = "Tối thiểu 2 ký tự, tối đa 45 kí tự")
    private String firstName;

    @NonNull
    @Size(min = 2, max = 45, message = "Tối thiểu 2 ký tự, tối đa 45 kí tự")
    private String lastName;

    @Pattern(regexp = "^(0)[0-9]{9}$", message = "SĐT gồm 10 số, bắt đầu bằng số 0")
    private String phoneNumber;

    @Min(value = 18, message = "Bạn đã đủ 18")
    private int age;

    @Email(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$", message = "địa chỉ email phải bắt đầu bằng 1 ký tự + địa chỉ email là tập hợp của các ký tự a-z, 0-9 và có thể có các ký tự như dấu chấm, dấu gạch dưới + độ dài tối thiểu của email là 5, độ dài tối đa là 32 + tên miền của email có thể là tên miền cấp 1 or tên miền cấp 2")
    private String email;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
