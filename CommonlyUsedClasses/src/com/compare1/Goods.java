package com.compare1;

/**
 * @ Description:商品类
 * @ Author: Jay
 * @ Date: Create in 12:19 2021/4/12
 * @ Version:
 */
public class Goods implements Comparable {
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //如何比较大小的方法,按照从低到高
    @Override
    public int compareTo(Object o) {

        if (o instanceof Goods) {
            //方式一
            Goods goods = (Goods) o;
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else {//相等时，按照name的字母顺序
                return this.name.compareTo(goods.name);
            }
            //方式二
            //return Double.compare(this.price,goods.price);
        }
        throw new RuntimeException("传入数据类型不一致！");
    }
}
