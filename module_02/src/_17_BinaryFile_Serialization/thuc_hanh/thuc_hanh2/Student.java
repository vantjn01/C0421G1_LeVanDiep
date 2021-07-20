package _17_BinaryFile_Serialization.thuc_hanh.thuc_hanh2;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String add;
    public Student(){

    }

    public Student(int id, String name, String add) {
        this.id = id;
        this.name = name;
        this.add = add;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", add='" + add + '\'' +
                '}';
    }
}
