 package com.coding.sales.domain;

import com.coding.sales.domain.action.IMemberCard;
import com.coding.sales.utils.ConstantDict;

/**
 * @author hy
 * @date 2019/07/02
 */
public class MemberCard implements IMemberCard{
    private int oldPoint;
    private int point;
    private MemberLevel oldMemberLevel;
    private MemberLevel memberLevel;
    private String memberCardNo;
    
	
	public MemberCard(String memberCardNo,int point,int oldPoint) {
        this.point = point;
        this.oldPoint=oldPoint;
        this.memberLevel = this.electMemberLevel(point);
    }
    
    public int getOldPoint() {
        return oldPoint;
    }
    public void setOldPoint(int oldPoint) {
        this.oldPoint = oldPoint;
    }
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }
    public MemberLevel getOldMemberLevel() {
        return oldMemberLevel;
    }
    public void setOldMemberLevel(MemberLevel oldMemberLevel) {
        this.oldMemberLevel = oldMemberLevel;
    }
    public MemberLevel getMemberLevel() {
        return memberLevel;
    }
    public void setMemberLevel(MemberLevel memberLevel) {
        this.memberLevel = memberLevel;
    }
    public String getMemberCardNo() {
		return memberCardNo;
	}

	public void setMemberCardNo(String memberCardNo) {
		this.memberCardNo = memberCardNo;
	}
    @Override
    public void increasePoint(int point) {
         this.oldPoint = this.point;
         this.point += point;
         this.oldMemberLevel = this.memberLevel;
         this.memberLevel = electMemberLevel(this.point);
    }
    
    public MemberLevel electMemberLevel(int point) {
        if(point < 10000) {
            return MemberLevel.memberLevelStore.get(ConstantDict.COMMON_LEVEL);
        }else if(10000 >= point && point < 50000){
            return MemberLevel.memberLevelStore.get(ConstantDict.GOLD_LEVEL);
        }else if(50000 >= point && point < 100000){
            return MemberLevel.memberLevelStore.get(ConstantDict.WHITE_GOLD_LEVEL);
        }else if(100000 >= point){
            return MemberLevel.memberLevelStore.get(ConstantDict.DIAMOND_LEVEL);
        }
        
        return memberLevel;
    }
}
