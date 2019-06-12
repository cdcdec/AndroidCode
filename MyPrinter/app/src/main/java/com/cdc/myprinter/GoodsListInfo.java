package com.cdc.myprinter;

import java.util.List;

public class GoodsListInfo {
    /**优惠补贴*/
    private String subsidy;
    /**金额总计*/
    private String  amount;
    /**还需支付*/
    private String orderAmount;

    private List<GoodInfo> listGoodInfo;

    public String getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(String subsidy) {
        this.subsidy = subsidy;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public List<GoodInfo> getListGoodInfo() {
        return listGoodInfo;
    }

    public void setListGoodInfo(List<GoodInfo> listGoodInfo) {
        this.listGoodInfo = listGoodInfo;
    }
}
