package com.qd.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhoujunyu
 * @since 2024-10-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ShoppingCar对象", description="")
public class ShoppingCar implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer tablesId;

    private Integer caipinId;

    private Integer number;

    @TableField(exist = false)
    private String pid;
    @TableField(exist = false)
    private String caipinName;
    @TableField(exist = false)
    private String photo;
    @TableField(exist = false)
    private float price;
    @TableField(exist = false)
    private BigDecimal yuanjia;


}
