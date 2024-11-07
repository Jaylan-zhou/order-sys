package com.qd.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.Date;
import java.util.List;

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
@ApiModel(value="Dingdan对象", description="")
public class Dingdan implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer tableId;

    private Integer personNumber;

    private String beizhu;

    private float price;

    @ApiModelProperty(value = "0待支付，1已取消 2已完成")
    private Integer status;

    private Date orderTime;

    private Date payTime;

    private Date completeTime;

    private Date concelTime;

    //额外的属性
    @TableField(exist = false)
    private  String tableName;

    @TableField(exist = false)
    private List<OrderDetail> orderDetailList;

}
