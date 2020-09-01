import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class UserPurchase{

    /**
     * 当前商品列表
     */
    private List<Product> currentStore;

    /**
     * 当前商品种类数量
     */
    private static Integer CURRENT_STORE_SIZE;

    /**
     * 用户数量
     */
    private Integer usernum;

    /**
     * 单用户购买数量
     */
    private static final Integer PURCHASE_TIMES = 2500;

    /**
     * 单次操作购买数量
     */
    private static final Integer PURCHASE_NUM = 1;

    /**
     * 初始化商品列表与用户数量
     */
    public UserPurchase(List<Product> currentStore,Integer num) {
        this.currentStore = currentStore;
        CURRENT_STORE_SIZE = currentStore.size() ;
        this.usernum = num;
    }

    /**
     * 模拟购物主入口
     */
    public void OnlinePurchase() throws InterruptedException {
        if (currentStore.isEmpty()) {
            System.out.println("商店是空的！");
            return;
        }
        Random random = new Random();
        for (int i = 0; i < usernum; ++i) {
            new Thread(() -> {
                File recordFile = new File(String.format("./data/user_%s_purchase_record.txt",
                        Thread.currentThread().getName().toCharArray()[7]));
                try {
                    FileOutputStream fos = new FileOutputStream(recordFile, true);
                    if (!recordFile.exists() && !recordFile.createNewFile()) {
                        return;
                    }
                    for (int i1 = 0; i1 < PURCHASE_TIMES; ++i1) {
                        int index = random.nextInt(CURRENT_STORE_SIZE) ;
                        // 临界区
                        synchronized (currentStore.get(index)) {
                            if (purchase(index)) {
                                record(fos, index);
                            }
                        }
                    }
                    fos.close();
                }
                catch (IOException IOError) {
                    IOError.printStackTrace();
                    return;
                }
            }).start();
        }
        return;
    }

    /**
     * 购买操作接口
     */
    private Boolean purchase(Integer indexOfList) {
        Product currentProduct = currentStore.get(indexOfList);
        if (null == currentProduct) {
            System.out.println(indexOfList);
            return false;
        }
        currentProduct.setNum(currentProduct.getNum() - PURCHASE_NUM);
        currentStore.set(indexOfList, currentProduct);
        return true;
    }

    /**
     * 写入购买记录接口
     */
    private Boolean record(FileOutputStream fos, Integer indexOfList) throws IOException {
        Product currentProduct = currentStore.get(indexOfList);
        String recordStr = "用户" + Thread.currentThread().getName()
                + "花费" + currentProduct.getPoints()
                + "积分购买了" + PURCHASE_NUM + "个<" + currentProduct.getId()
                + ">。 剩余库存：" + currentProduct.getNum() + "件。"
                + "广告词：" + currentProduct.getDescription() + "\n";
        try {
            fos.write(recordStr.getBytes("utf-8"));
            fos.flush();
        } catch (FileNotFoundException fileError) {
            return false;
        }
        return true;
    }
}
