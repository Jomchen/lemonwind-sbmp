package com.lemonwind.sbmp.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <p>
 * 门派
 * </p>
 *
 * @author lemonwind
 * @since 2023-09-18 17:21:12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
@TableName(MenPai.TABLE_NAME)
@ApiModel(value = "MenPai对象", description = "门派")
public class MenPai extends LemonwindEntity<MenPai> {
    private static final long serialVersionUID = 2023091805219090012L;
    /** 物理表名称. */
    public static final String TABLE_NAME = "jo_men_pai";

    @ApiModelProperty("名字")
    private String name;

    @ApiModelProperty("所属地")
    private String area;

    @Override
    public Serializable pkVal() {
        return null;
    }
}
