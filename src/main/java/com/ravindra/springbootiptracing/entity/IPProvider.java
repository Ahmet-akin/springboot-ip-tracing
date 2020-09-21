package com.ravindra.springbootiptracing.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IPProvider {
    private String loc;
    private String postal;
    private String org;
    private String timeZone;
}
