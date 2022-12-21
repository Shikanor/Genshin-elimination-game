package Tool;

import Model.Brand;
import Model.Cell;
import Model.Layer;
import Model.Map;

import java.awt.*;

public class MapUtil {
    public static Map build(Integer floorHeight){
        Map map=new Map();
        map.setFloorHeight(floorHeight);

        Layer layer1= LayerUtil.build(3,5);
        Layer layer2= LayerUtil.build(9,4);
        Layer layer3= LayerUtil.build(6,4);
        Layer layer4= LayerUtil.build(6,9);
        Layer layer5= LayerUtil.build(3,3);
        Layer layer6= LayerUtil.build(10,9);
        Layer layer7= LayerUtil.build(3,8);
        Layer layer8= LayerUtil.build(9,6);
        Layer layer9= LayerUtil.build(6,9);
        Layer layer10= LayerUtil.build(6,12);
        Layer layer11= LayerUtil.build(6,5);
        Layer layer12= LayerUtil.build(4,9);
        Layer layer13= LayerUtil.build(5,9);
        Layer layer14= LayerUtil.build(7,9);
        Layer layer15= LayerUtil.build(9,9);
        Layer layer16= LayerUtil.build(2,9);
        Layer layer17= LayerUtil.build(5,9);
        Layer layer18= LayerUtil.build(4,9);



        layer1.setParent(null);     //parent为null时已经是最后一层了 是循环递归结束的条件
        layer2.setParent(layer1);
        layer3.setParent(layer2);       //用链式关系把图层锁起来
        layer4.setParent(layer3);
        layer5.setParent(layer4);
        layer6.setParent(layer5);
        layer7.setParent(layer6);
        layer8.setParent(layer7);
        layer9.setParent(layer8);
        layer10.setParent(layer9);
        layer11.setParent(layer10);
        layer12.setParent(layer11);
        layer13.setParent(layer12);
        layer14.setParent(layer13);
        layer15.setParent(layer14);
        layer16.setParent(layer15);
        layer17.setParent(layer16);
        layer18.setParent(layer17);


//        layer1.setOffsetx(30);
//        layer2.setOffsetx(20);
//        layer3.setOffsetx(10);

        map.getList().add(layer1);
        map.getList().add(layer2);
        map.getList().add(layer3);
        map.getList().add(layer4);
        map.getList().add(layer5);
        map.getList().add(layer6);
        map.getList().add(layer7);
        map.getList().add(layer8);
        map.getList().add(layer9);
        map.getList().add(layer10);
        map.getList().add(layer11);
        map.getList().add(layer12);
        map.getList().add(layer13);
        map.getList().add(layer14);
        map.getList().add(layer15);
        map.getList().add(layer16);
        map.getList().add(layer17);
        map.getList().add(layer18);


        return map;
    }

    public static boolean compare(Brand brand, Layer layer){            //判断当前牌和某一图层所有牌是否有矩阵交集,ture表示有交集，显示灰色，false表示没有交集，显示正常牌
        Cell cells[][]=layer.getCells();

        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                //如果当前单元格为空，cell不用比较
                Cell cell=cells[row][col];
                if(cell.getState()==1){
                    //单元格有牌，可以比较
                    Rectangle temp=cell.getBrand().getBounds();

                    Rectangle rect=brand.getBounds();

                    boolean result=rect.intersects(temp);       //布尔类型判断是否有交集

                    if (result){
                        //有交集说明被上层牌盖住了
                        return result;      //判定结束，结束方法
                    }



                }
            }
            System.out.println();

        }

        /*如果跳出了上面的循环，说明都没有交集,需要和更上层进行对比*/

        if (layer.getParent()!=null){
            return compare(brand,layer.getParent());        //递归判定
        }else{      //如果getparent等于null，说明已经到最顶层了
            return false;

        }



    }
}
