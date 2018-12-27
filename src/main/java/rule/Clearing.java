package rule;

import Param.ClearingResult;
import entity.Buyer;
import entity.Seller;
import tool.ClearingTool;

import java.util.Collections;
import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 14:17 2018/12/22
 * @Modified By:
 */
public class Clearing {

    public ClearingResult getClearing(List<Buyer> buyerList, List<Seller> sellerList){

//        1.数据有效筛选
        List<Buyer> buyers = filterBuyer(buyerList);
        List<Seller> sellers = filterSeller(sellerList);
//        2.交易排序
        Collections.sort(sellers, new ClearingTool.PriceIncComparator()); // 根据价格排序
        Collections.sort(buyers, new ClearingTool.PriceDecComparator()); // 根据价格排序
//        3.交易竞价

        return null;
    }

    private List<Seller> filterSeller(List<Seller> sellerList) {
        return sellerList;
    }

    private List<Buyer> filterBuyer(List<Buyer> buyerList) {
        return buyerList;
    }


    public static void main(String[] args){

    }



}
