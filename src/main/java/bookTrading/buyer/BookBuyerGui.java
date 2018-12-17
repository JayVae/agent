package bookTrading.buyer;

/**
 * @Author: Jay
 * @Date: Created in 16:18 2018/12/17
 * @Modified By:
 */
/**
 * Section 4.1.5, Page 57
 *
 * definition of the BookBuyerGui interface
 **/

public interface BookBuyerGui {
    void setAgent(BookBuyerAgent a);
    void show();
    void hide();
    void notifyUser(String message);
    void dispose();
}

