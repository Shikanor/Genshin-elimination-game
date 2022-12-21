package Test;

import Model.Layer;
import Model.Map;
import Tool.LayerUtil;

import java.util.List;

public class TestBulidMap {         //测试创建地图类

    public static void main(String[] args) {
        Map map=new Map();
        map.setFloorHeight(3);

        Layer layer1= LayerUtil.build(3,3);
        Layer layer2= LayerUtil.build(6,6);
        Layer layer3= LayerUtil.build(9,9);

        map.getList().add(layer1);
        map.getList().add(layer2);
        map.getList().add(layer3);

        List<Layer> list=map.getList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第"+i+"个图层");
            list.get(i).showCell();
        }
    }
}
