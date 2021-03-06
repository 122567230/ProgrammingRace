 package com.coding.sales.member;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.coding.sales.utils.ConstantDict;


/**
 * @author hy
 * @date 2019/07/02
 */
public class MemberLevel {
	

	public static Map<String,MemberLevel> memberLevelStore ;
    static{
        memberLevelStore = new HashMap<String,MemberLevel>();
        memberLevelStore.put(ConstantDict.COMMON_LEVEL, new MemberLevel(ConstantDict.COMMON_LEVEL,"普卡",new BigDecimal(ConstantDict.COMMON_RATIO)));
        memberLevelStore.put(ConstantDict.GOLD_LEVEL, new MemberLevel(ConstantDict.GOLD_LEVEL,"金卡",new BigDecimal(ConstantDict.GOLD_RATIO)));
        memberLevelStore.put(ConstantDict.WHITE_GOLD_LEVEL, new MemberLevel(ConstantDict.WHITE_GOLD_LEVEL,"白金卡",new BigDecimal(ConstantDict.WHITE_GOLD_RATIO)));
        memberLevelStore.put(ConstantDict.DIAMOND_LEVEL, new MemberLevel(ConstantDict.DIAMOND_LEVEL,"钻石卡",new BigDecimal(ConstantDict.DIAMOND_RATIO)));
    }
    String level ;
    String levelName;
    BigDecimal ratio;
    
    public MemberLevel() {};
    
    public MemberLevel(String level,String levelName,BigDecimal ratio) {
        this.level = level;
        this.levelName = levelName;
        this.ratio = ratio;
    }
    public MemberLevel(String level) {
        MemberLevel memberLevel = new MemberLevel();
        memberLevel = memberLevelStore.get(level);
        this.level = memberLevel.level;
        this.levelName = memberLevel.levelName;
        this.ratio = memberLevel.ratio;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }
    
    
}
