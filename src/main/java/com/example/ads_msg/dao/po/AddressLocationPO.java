package com.example.ads_msg.dao.po;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@Setter
@Getter
@ToString

public class AddressLocationPO implements Serializable {
    private Integer id;
    private String addressName;
    private String longitude;
    private String latitude;
    private String buildingLevel;
    private String dataConfidence;
    private String errorMsg;
    private Byte isValid;
    private Date gmtCreate;
    private Date gmtModified;
    //    序列化ID，相当于身份认证，主要用于程序的版本控制，保持不同版本的兼容性，在程序版本升级时避免程序报出版本不一致的错误。
    private static final long serialVersionUID = 1L;
}
