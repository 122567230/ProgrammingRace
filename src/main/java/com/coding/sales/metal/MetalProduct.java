 package com.coding.sales.metal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.coding.sales.coupon.action.IDiscount;
import com.coding.sales.coupon.action.IReduction;



/**
 * @author hy
 * @date 2019/07/02
 */
public class MetalProduct {
    public static final String P001001 = "001001";
    public static final String P001002 = "001002";
    public static final String P003001= "003001";
    public static final String P003002= "003002";
    public static final String P002002= "002002";
    public static final String P002001= "002001";
    public static final String P002003= "002003";
    public static Map<String,MetalProduct> metalProducts = new HashMap<String,MetalProduct>();
    static {
        MetalProduct product = new MetalProduct(P001001,"世园会五十国钱币册","册",new BigDecimal("998.00"),
        		new ArrayList<String>(),
        		new ArrayList<String>());
        metalProducts.put(P001001, product);
        
         product = new MetalProduct(P001002,"2019北京世园会纪念银章大全40g","盒",new BigDecimal("1380.00"),
            new ArrayList<String>(Arrays.asList(new String[]{"9折券"})),
            new ArrayList<String>());
        metalProducts.put(P001002, product);
        
        product = new MetalProduct(P003001,"招财进宝","条",new BigDecimal("1580.00"),
        		new ArrayList<String>(Arrays.asList(new String[]{"95折券"})),
        		new ArrayList<String>());
        metalProducts.put(P003001, product);
        
        product = new MetalProduct(P003002,"水晶之恋","条",new BigDecimal("980.00"),
        		new ArrayList<String>(),
        		new ArrayList<String>(Arrays.asList(new String[]{"REDUCTION_FOUL_FREE_TICKET","REDUCTION_THIRD_HALF_TICKET"})));
        metalProducts.put(P003002, product);
        
        product = new MetalProduct(P002002,"中国经典钱币套装","套",new BigDecimal("998.00"),
        		new ArrayList<String>(),
        		new ArrayList<String>(Arrays.asList(new String[]{"REDUCTION_FULL_1000_MINUS_10_TICKET","REDUCTION_FULL_2000_MINUS_30_TICKET"})));
        metalProducts.put(P002002, product);
        
        product = new MetalProduct(P002001,"守扩之羽比翼双飞4.8g","条",new BigDecimal("1080.00"),
        		new ArrayList<String>(),
        		new ArrayList<String>(Arrays.asList(new String[]{"REDUCTION_FOUL_FREE_TICKET","REDUCTION_THIRD_HALF_TICKET"})));
        metalProducts.put(P002001, product);
        
        product = new MetalProduct(P002003,"中国银象棋12g","套",new BigDecimal("698.00"),
        		new ArrayList<String>(),
        		new ArrayList<String>(Arrays.asList(new String[]{"REDUCTION_FULL_1000_MINUS_10_TICKET","REDUCTION_FULL_2000_MINUS_30_TICKET","REDUCTION_FULL_3000_MINUS_350_TICKET"})));
        metalProducts.put(P002003, product);
    }
    
    private String productNo;
    private String productName;
    private MetalUnit unit;
    private List<String> allowsDiscountTickets;
    private List<String> allowsReductionTickets;
    
    private IDiscount usedDiscountTickets = null;
    
    private IReduction usedReductionTickets = null;
    
    public IDiscount getUsedDiscountTickets() {
        return usedDiscountTickets;
    }

    public void setUsedDiscountTickets(IDiscount usedDiscountTickets) {
        this.usedDiscountTickets = usedDiscountTickets;
    }

    public IReduction getUsedReductionTickets() {
        return usedReductionTickets;
    }

    public void setUsedReductionTickets(IReduction usedReductionTickets) {
        this.usedReductionTickets = usedReductionTickets;
    }

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
