import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputOutput {
    private static final String CHARSET_NAME = "utf-8";
    /***
     *
     * 将商品数据存储到10个txt文件中
     */
    public void storageProductData() throws IOException {
        tryWriteFile(new Product("001：苹果", "多吃苹果有益于身体健康！", 10000, 10), "./data/p1.txt");
        tryWriteFile(new Product("002：手机", "华为手机！", 10000, 1500), "./data/p2.txt");
        tryWriteFile(new Product("003：冰箱", "格力冰箱", 10000, 2000), "./data/p3.txt");
        tryWriteFile(new Product("004：空调", "美的空调，一晚一度电！", 10000, 2300), "./data/p4.txt");
        tryWriteFile(new Product("005：雷碧", "比雪碧更受欢迎的雷碧！", 10000, 12), "./data/p5.txt");
        tryWriteFile(new Product("006：六个核弹", "多喝补脑", 10000, 20), "./data/p6.txt");
        tryWriteFile(new Product("007：游戏机", "玩玩游戏，放松心情", 10000, 350), "./data/p7.txt");
        tryWriteFile(new Product("008：笔记本", "纸上得来终觉浅", 10000, 13), "./data/p8.txt");
        tryWriteFile(new Product("009：手表", "年轻人要有时间观念", 10000, 150), "./data/p9.txt");
        tryWriteFile(new Product("010：康帅傅", "越吃越帅的泡面", 10000, 12), "./data/p10.txt");
    }

    /***
     *
     * 将txt文件中存储的商品数据读入到内存中
     */
    public List<Product> loadProductData() throws IOException {
        List<Product> prolist = new ArrayList<>();
        Integer i = 1;
        while(i<=10){
            File file = new File(String.format("./data/p%d.txt", i));
            prolist.add(tryLoadFile(file));
            i++;
        }
        return prolist;
    }

    public Product tryLoadFile(File file) throws IOException {
        Product pro = null;
        if (file.exists()) {
            FileInputStream fis = null;
            BufferedReader reader;
            try {
                fis = new FileInputStream(file);
                reader = new BufferedReader(new InputStreamReader(fis));
                String line = reader.readLine();
                String temp[] = line.trim().split("\t");
                pro = new Product(temp[0],temp[1],Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    fis.close();
                }
            }
        }
        return pro;
    }

    public void tryWriteFile(Product pro, String path) throws IOException {
        File file = new File(path);
        FileOutputStream fos = null;
        if (!file.exists()) {
            String[] arr = {pro.getId(), pro.getDescription(), pro.getNum().toString(), pro.getPoints().toString()};
            try {
                fos = new FileOutputStream(file, true);
                String text = String.format("%s\t%s\t%s\t%s", arr[0], arr[1], arr[2], arr[3]);
                fos.write(text.getBytes(CHARSET_NAME));
                fos.flush();
            } catch (IOException e) {
                System.out.println("异常");
            } finally {
                if (fos != null) {
                    fos.close();
                }
            }
        }
    }
}

