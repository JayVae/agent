package bookTrading.seller;

/**
 * @Author: Jay
 * @Date: Created in 16:19 2018/12/17
 * @Modified By:
 */

public interface BookSellerGui {
    void setAgent(BookSellerAgent a);
    void show();
    void hide();
    void notifyUser(String message);
    void dispose();
}

