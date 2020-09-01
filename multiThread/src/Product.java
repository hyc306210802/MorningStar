public class Product {
    /***
     * 商品id
     */
    private String id;
    /***
     *商品描述
     */
    private String description;
    /***
     * 商品库存
     */
    private Integer num;
    /***
     * 购买该商品所需积分
     */
    private Integer points;

    public Product(String id,String description,Integer num,Integer points){
        setId(id);
        setDescription(description);
        setNum(num);
        setPoints(points);
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId(){return this.id;}

    public Integer getPoints(){return this.points;}

    public Integer getNum(){return this.num;}

    public String getDescription(){return this.description;}
}
