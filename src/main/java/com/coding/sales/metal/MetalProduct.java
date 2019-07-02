 package com.coding.sales.metal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @author hy
 * @date 2019/07/02
 */
public class MetalProduct {
    public static final String P001001 = "001001";
    public static final String P001002 = "001002";
    public static final String P003001= "";
    public static final String P003002= "";
    public static final String P002002= "";
    public static final String P002001= "";
    public static final String P002003= "";
    public static Map<String,MetalProduct> metalProducts = new HashMap<String,MetalProduct>();
    static {
        MetalProduct product = new MetalProduct(P001001,"世园会五十国钱币册","册",new BigDecimal("998.00"),new ArrayList<String>(),new ArrayList<String>());
        metalProducts.put(P001001, product);
        
        product = new MetalProduct(P001002,"2019北京世园会纪念银章大全40g","盒",new BigDecimal("1380.00"),
            new ArrayList<String>(Arrays.asList(new String[]{"add","d"})),
            new ArrayList<String>());
        metalProducts.put(P001001, product);
    }
    
    private String productNo;
    private String productName;
    private MetalUnit unit;
    private List<String> allowsDiscountTickets;
    private List<String> allowsReductionTickets;
    
    public MetalProduct(String productNo,String productName,String unit,
        BigDecimal price,List<String> allowsDiscountTickets,List<String> allowsReductionTickets) {
        this.productNo = productNo;
        this.productName = productName;
        this.unit = new MetalUnit(unit,price);
        this.allowsDiscountTickets = allowsDiscountTickets;
        this.allowsReductionTickets = allowsReductionTickets;
    }
    
    public MetalProduct() {
    }
    
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
