package Tool;

import Model.Brand;
import java.util.Random;

/*
    工具类
    提供 创建牌相关的一些公共方法


 */
public class BrandUtil {
    public static Random random =new Random();
    public  static  String[] brandNames= {"风","岩","雷","草","水","火","冰"};     //牌名数组

    public static String getBrandName(){        //随机获取一个牌的名称
        int a=random.nextInt(brandNames.length);
        return brandNames[a];
    }

    //创建随机牌
    public static Brand[] buildBrands(Integer capcity){      //需要参数(数组大小)

        Brand brands[]=new Brand[capcity];

        for (int i = 0; i < brands.length; i=i+3) {
            String randomBrandName=getBrandName();  //每次循环获取一个随机牌名称

            Brand brand1=new Brand(randomBrandName);     //名称传递，创建新的对象
            Brand brand2=new Brand(randomBrandName);
            Brand brand3=new Brand(randomBrandName);        //创建三个相同的对象，方便删除牌

            brands[i]=brand1;
            brands[i+1]=brand2;
            brands[i+2]=brand3;
        }

//        System.out.println("=====================");
//        for (int i = 0; i < brands.length; i++) {
//            System.out.print(brands[i].getName()+"-");
//        }
//        System.out.println();
//        System.out.println("======打乱顺序=======");

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
        return brands;
    }
}
