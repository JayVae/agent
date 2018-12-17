package bookTrading.ontology;

/**
 * @Author: Jay
 * @Date: Created in 16:14 2018/12/17
 * @Modified By:
 */
/** Class associated to the SELL schema
 **/

        import jade.content.AgentAction;

public class Sell implements AgentAction {
    private Book item;

    public Book getItem() {
        return item;
    }

    public void setItem(Book item) {
        this.item = item;
    }

}

