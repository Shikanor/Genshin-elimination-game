package Model;

import javax.swing.*;
import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

public class EliminateBox {         //消除区域
    private static List<Brand> Box=new ArrayList<>();   //存放消除牌的数据

    /*迭代器清空集合方法*/
    void deleteByBrandName(String name){
        Iterator<Brand> iterator = Box.iterator();
        while (iterator.hasNext()){     //如果有下一个值
            Brand next=iterator.next(); //获取下一个值
            if (next.getName().equals(name)){
                next.getParent().remove(next);
                iterator.remove();
            }

        }
    }

    public void addBox(Brand brand){        //添加到消除区方法
        Box.add(brand);
        /*牌的排序(根据名称)*/
        Box.sort(Comparator.comparing(Brand::getName));

        /*消除算法*/
        Map<String, List<Brand>> map= Box.stream().collect(Collectors.groupingBy(Brand::getName));//获取牌的名称
        Set<String> key=map.keySet();
        for (String s:key){
            List<Brand> brands=map.get(s);
            if (brands.size()==3){
                deleteByBrandName(s);       //调用迭代器消除方法
                break;
            }

        }


        paint();        //调用方法 绘制到消除区

        over(brand);//调用方法 判断游戏结束
    }


    void paint(){       //绘制到消除区
        for (int i = 0; i < Box.size(); i++) {
            Brand brand = Box.get(i);
            int x=i*brand.getWidth()+10;
            brand.setBounds(x,600,50,50);
        }
    }

    /*消除方法*/
    void over(Brand brand){
        if (Box.size()>=7){             //判断游戏结束
            JOptionPane.showMessageDialog(brand,"游戏失败");
            System.exit(0);
        }
    }

}
