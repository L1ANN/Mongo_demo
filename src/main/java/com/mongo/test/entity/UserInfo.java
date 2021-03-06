package com.mongo.test.entity;

import com.sun.javafx.beans.IDProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author:L1ANN
 * @Description:
 *
 * @Date:Created in 上午11:33 2018/9/25
 * @Modified By:
 */
@Document(collection="coll_user")
public class UserInfo implements Serializable {
    private static final long serivalVersionUID =1L;

    @Id
    private String id;

    @Field
    private String name;

    @Field("myage")
    private int age;

    @Field
    @Indexed(name="index_birth",direction = IndexDirection.DESCENDING)
    private Timestamp birth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }
}
