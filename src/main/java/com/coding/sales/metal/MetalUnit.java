 package com.coding.sales.metal;

import java.math.BigDecimal;

/**
 * @author hy
 * @date 2019/07/02
 */
public class MetalUnit {
    private String unit;
    private BigDecimal price;
    public MetalUnit(String unit,BigDecimal price) {
        this.unit = unit;
        this.price = price;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
}
