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
 * 功夫表
 * </p>
 *
 * @author lemonwind
 * @since 2023-09-14 13:18:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
@TableName(KongFu.TABLE_NAME)
@ApiModel(value = "KongFu对象", description = "功夫表")
public class KongFu extends LemonwindEntity<KongFu> {
    private static final long serialVersionUID = 2023091401185600048L;
    /** 物理表名称. */
    public static final String TABLE_NAME = "jo_kong_fu";

    @ApiModelProperty("名字")
    private String name;

    @ApiModelProperty("等级")
    private Integer level;

    @ApiModelProperty("创始人")
    private Long inventionUserId;

    @Override
    public Serializable pkVal() {
        return null;
    }
}
