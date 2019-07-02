 package com.coding.sales.domain;

import com.coding.sales.domain.action.IMemberCard;

/**
 * @author hy
 * @date 2019/07/02
 */
public class Member {
    private String name;
    private IMemberCard memberCard; 
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public IMemberCard getMemberCard() {
        return memberCard;
    }
    public void setMemberCard(IMemberCard memberCard) {
        this.memberCard = memberCard;
    }
    
}
