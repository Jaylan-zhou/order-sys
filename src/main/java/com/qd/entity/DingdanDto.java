package com.qd.entity;

import lombok.Data;



//为了实现接收参数和订单状态：餐桌id,时间等
@Data
public class DingdanDto extends Dingdan{
    private String timeMin;
    private String timeMax;
    private Integer page;
    private Integer limit;
}
