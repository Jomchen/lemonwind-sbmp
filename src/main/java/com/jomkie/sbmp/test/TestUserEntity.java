package com.jomkie.sbmp.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class TestUserEntity {

    private String name;
    private Integer age;
    private Integer level;

    public Object execute() {
        return this;
    }

}
