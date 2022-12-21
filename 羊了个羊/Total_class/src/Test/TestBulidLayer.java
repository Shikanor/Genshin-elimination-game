package Test;

import Model.Brand;
import Model.Cell;
import Model.Layer;

import java.util.Random;

/*
    测试图层的创建(Layer)

*/
public class TestBulidLayer {
    public static Random random =new Random();
    public  static  String[] brandNames= {"风","岩","雷","草","水","火","冰"};     //牌名数组

    public static String getBrandName(){        //随机获取一个牌的名称
        int a=random.nextInt(brandNames.length);
        return brandNames[a];
    }
    public static void main(String[] args) {
        Layer layer=null;
        try {
            layer=new Layer(3,5);     //容量需要为3的倍数，不然下面for循环因为i=i+3时，数组越界会报错
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(getBrandName());

        Brand brands[]=new Brand[layer.getCapacity()];      //数组容量等于图层的容量

        for (int i = 0; i < brands.length; i=i+3) {
            String randomBrandName=getBrandName();  //每次循环获取一个随机牌名称

            Brand brand1=new Brand(randomBrandName);     //名称传递，创建新的对象
            Brand brand2=new Brand(randomBrandName);
            Brand brand3=new Brand(randomBrandName);        //创建三个相同的对象，方便删除牌

            brands[i]=brand1;
            brands[i+1]=brand2;
            brands[i+2]=brand3;
        }

        System.out.println("=====================");
        for (int i = 0; i < brands.length; i++) {
            System.out.print(brands[i].getName()+"-");
        }
        System.out.println();
        System.out.println("======打乱顺序=======");

        for (int i = 0; i < brands.length; i++) {
            //当前位置A的变量拿到
            Brand brandA = brands[i];

            //随机交换位置
            int randomIndex=random.nextInt(brands.length);
            Brand brandB=brands[randomIndex];

            Brand temp=brandA;
            brands[i]= brandB;
            brands[randomIndex]=temp;       //交换

        }
        for (int i = 0; i < brands.length; i++) {
            System.out.print(brands[i].getName()+"-");
        }

        System.out.println();
        System.out.println("==============");

        int flag=0;

        Cell cells[][]=layer.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {

        //        System.out.println(row+"-"+col);

                Cell cell=new Cell();       //初始化单元格对象
                cell.setState(1);
                cell.setBrand(brands[flag++]);

                cells[row][col]=cell;       //把之前空的图层设置了值
            }

        }



        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                Brand brands1= cells[row][col].getBrand();
                System.out.print(brands1.getName()+"-");
            }
            System.out.println();

        }
    }
}
