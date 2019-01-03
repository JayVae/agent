package rule;

import Param.ClearingResult;
import Param.ResultPair;
import entity.Buyer;
import entity.Seller;
import tool.ClearingTool;

import java.util.ArrayList;
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
        ClearingResult clearingResult = bid(buyers,sellers);
        return clearingResult;
    }

    private ClearingResult bid(List<Buyer> buyers, List<Seller> sellers){

        ClearingResult cr = new ClearingResult();
        ArrayList<ResultPair> resultPairs = new ArrayList<ResultPair>();
        Double clearPrice = 0.0;
        while(!buyers.isEmpty() && !sellers.isEmpty()){
            Buyer buyer = buyers.get(0);
            Seller seller = sellers.get(0);
            Double quantityNow = 0.0;
            quantityNow = Math.min(buyer.getQuantity()-buyer.getFinalQuantity(),seller.getQuantity()-seller.getFinalQuantity());
            buyer.setFinalQuantity(buyer.getFinalQuantity()+quantityNow);
            seller.setFinalQuantity(seller.getFinalQuantity()+quantityNow);
            ResultPair resultPair = new ResultPair(quantityNow,buyer,seller);
            resultPairs.add(resultPair);
            clearPrice = (buyer.getPrice()+seller.getPrice())/2;
            if (buyer.getFinalQuantity() == buyer.getQuantity() || seller.getFinalQuantity() == seller.getQuantity()){
                if (buyer.getFinalQuantity() == buyer.getQuantity()){
                    buyers.remove(buyer);
                }
                if (seller.getFinalQuantity() == seller.getQuantity()){
                    sellers.remove(seller);
                }
            }
        }
        cr.setClearPrice(clearPrice);
        cr.setResultPairList(resultPairs);
        return cr;
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
