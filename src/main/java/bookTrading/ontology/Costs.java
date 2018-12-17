package bookTrading.ontology;

/**
 * @Author: Jay
 * @Date: Created in 16:14 2018/12/17
 * @Modified By:
 */
/**
 * Section 5.1.3.2 Page 85
 * Java class representing a Costs
 **/

// Class associated to the COSTS schema


        import jade.content.Predicate;

public class Costs implements Predicate {
    private Book item;
    private int price;

    public Book getItem() {
        return item;
    }

    public void setItem(Book item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
