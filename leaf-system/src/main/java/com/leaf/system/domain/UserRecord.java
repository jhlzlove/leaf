package com.leaf.system.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author jhlz
 * @since 2023/2/27 9:09
 */
public record UserRecord(

        String name,
        Integer age,
        LocalDateTime birthday
) implements Serializable {
    public UserRecord(String name, Integer age, LocalDateTime birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public UserRecord(Integer age, LocalDateTime birthday) {
        this(null, age, birthday);
    }

    public Record copy() {
        return this;
    }
}
