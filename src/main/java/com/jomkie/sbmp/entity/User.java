package com.jomkie.sbmp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jomkie
 * @since 2022-09-22 14:39:44
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Accessors(chain = true)
@TableName(User.TABLE_NAME)
@ApiModel(value = "User对象", description = "")
public class User extends JomkieEntity<User> {
    private static final long serialVersionUID = 2022092202393840044L;
    /** 物理表名称. */
    public static final String TABLE_NAME = "jo_user";

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("性别：0：女 | 1：男")
    private Integer sex;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("真实名字")
    private String realName;

    @Override
    public Serializable pkVal() {
        return null;
    }
}
