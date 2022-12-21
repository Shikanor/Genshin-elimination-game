package Model;

import Tool.MapUtil;

import java.util.ArrayList;
import java.util.List;

//图层
public class Map {

    private Integer floorHeight;    //层高        有几个图层
    private List<Layer> list=new ArrayList<>();     //存放图层数据



    /*     set/get     */
    public Integer getFloorHeight() {
        return floorHeight;
    }

    public void setFloorHeight(Integer floorHeight) {
        this.floorHeight = floorHeight;
    }

    public List<Layer> getList() {
        return list;
    }

    public void setList(List<Layer> list) {
        this.list = list;
    }


    /*判断当前map中所有牌是否置灰*/
    public void compareAll(){
        System.out.println("map.compareAll");
        //i=0是最顶层layer，不需要判断
        for (int i = 1; i < list.size(); i++) {
            Layer layer=list.get(i);
            Cell[][] cells=layer.getCells();
            for (int row = 0; row < cells.length; row++) {
                for (int col = 0; col < cells[row].length; col++) {
                    Cell cell=cells[row][col];      //先拿到单元格对象
                    if (cell.getState()==1){
                        Brand brand = cell.getBrand();      //有牌取牌

                        boolean result=MapUtil.compare(brand,layer.getParent());
                        brand.setGray(result);


                    }

                }


            }


        }
    }

}
