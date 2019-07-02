 package com.coding.sales.metal;

import java.util.List;


/**
 * @author hy
 * @date 2019/07/02
 */
public class MetalProduct {
    private String productNo;
    private String productName;
    private MetalUnit unit;
    private List<String> allowsDiscountTickets;
    private List<String> allowsReductionTickets;
    public String getProductNo() {
        return productNo;
    }
    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public MetalUnit getUnit() {
        return unit;
    }
    public void setUnit(MetalUnit unit) {
        this.unit = unit;
    }
    public List<String> getAllowsDiscountTickets() {
        return allowsDiscountTickets;
    }
    public void setAllowsDiscountTickets(List<String> allowsDiscountTickets) {
        this.allowsDiscountTickets = allowsDiscountTickets;
    }
    public List<String> getAllowsReductionTickets() {
        return allowsReductionTickets;
    }
    public void setAllowsReductionTickets(List<String> allowsReductionTickets) {
        this.allowsReductionTickets = allowsReductionTickets;
    }
    
}
