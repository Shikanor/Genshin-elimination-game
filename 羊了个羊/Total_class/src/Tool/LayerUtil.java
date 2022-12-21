package Tool;

import Model.Brand;
import Model.Cell;
import Model.Layer;

public class LayerUtil {
    public static Layer build(Integer rowNum, Integer colNum) {
        Layer layer = null;
        try {
            layer = new Layer(rowNum, colNum);     //容量需要为3的倍数，不然下面for循环因为i=i+3时，数组越界会报错
        } catch (Exception e) {
            e.printStackTrace();
        }

        Brand[] brands=BrandUtil.buildBrands(layer.getCapacity());

        Cell cells[][] = layer.getCells();
        int flag=0;
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {

                //        System.out.println(row+"-"+col);
                Brand brands1=brands[flag++];
                Cell cell = new Cell();       //初始化单元格对象
                cell.setState(1);
                cell.setBrand(brands1);     //单元格对象找到我们牌

                brands1.setCell(cell);      //牌反向找到单元格对象,       互相链式关系

                cells[row][col] = cell;       //把之前空的图层设置了值
            }
        }
        return layer;

    }
}
