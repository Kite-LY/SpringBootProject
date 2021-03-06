package cn.kitey.jpa.entity;

import javax.persistence.*;

/**
 * 编写一个实体类
 * 使用JPA注解配置映射关系
 */
@Entity   //告诉JPA这是一个实体类
@Table(name = "tb1_user")
public class User {

    @Id  //表明这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //表明为自增主键
    private Integer id;


    @Column(name = "last_name", length = 50)
    private String lastName;


    @Column  //省略默认列名就是属性名
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
