package demo.entity;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class User implements Serializable {

    private static final long serialVersionUID = 8905506791424484890L;

    @Value("${test.user.id}")
    private int id;

    @Value("${test.user.name}")
    private String name;

    @Value("${test.user.username}")
    private String username;

    @Value("${test.user.password}")
    private String password;

    @Value("${test.other.sax}")
    private String sax;

    @Value("${test.other.height}")
    private double height;

    @Value("${test.other.weight}")
    private double weight;

    private Boolean gander;


    public User(Integer id, String username, Boolean gander) {
        this.id = id;
        this.username = username;
        this.gander = gander;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSax() {
        return sax;
    }

    public void setSax(String sax) {
        this.sax = sax;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public User(int id, String name, String username, String password, String sax, double height, double weight){
        this.id=id;
        this.name=name;
        this.username=username;
        this.password=password;
        this.sax=sax;
        this.height=height;
        this.weight=weight;
    }
    public User(int id,String name,String username,String password){
        this.id=id;
        this.name=name;
        this.username=username;
        this.password=password;
    }

    public User(){}

}
