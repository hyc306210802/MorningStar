import java.io.IOException;

public class PresentHouseRun {
    public static void main(String[] args) throws IOException, InterruptedException {
        InputOutput iop = new InputOutput();
        /***
         * 输入商品数据并存储到txt文件
         */
        iop.storageProductData();
        /***
         * 初始化，输入商品列表和用户数量
         */
        UserPurchase up = new UserPurchase(iop.loadProductData(),20);
        /***
         * 用户在线通过积分购买商品
         */
        up.OnlinePurchase();

    }
}
