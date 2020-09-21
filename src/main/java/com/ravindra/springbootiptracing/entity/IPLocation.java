package com.ravindra.springbootiptracing.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity(name="IP_LOCATION_TB")
@TypeDef(name="json", typeClass = JsonBinaryType.class)
@ApiModel(value ="Response Api Details")
public class IPLocation {
    //http://ipinfo.io/148.252.133.137?token=a15ef167286cfc
    @Id
    @GeneratedValue
    private long id;
    private String ip;
    private String city;
    private String region;
    private String country;
    private String loc;
    private String postal;
    private String org;
    private String timezone;
}
