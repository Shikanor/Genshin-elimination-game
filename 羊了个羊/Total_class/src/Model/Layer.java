package Model;
import java.util.Random;

/*
    图层类
    二维表格
 */
public class Layer {


    private Integer offsetx;    /*设置偏移量*/   //x轴
    private  Integer offsety;   //偏移量 y轴

    private Integer rowNum; //有多少行  (行数)
    private Integer colNum; //有多少列  (列数)

    private Integer capacity;   //当前图层能最多容纳的牌数量     最大容量

    private Integer size;       //图层 目前有多少牌     当牌添加的时候，需要改变值、当牌减少的时候，也需要改变值

    private Layer parent;       //上一层图层对象

    private Cell[][] cells =null;

    public Layer(Integer rowNum, Integer colNum) throws Exception{      //构造函数，传递参数为行号和列号（因为其他属性都可以通过行号列号知道）
        this.rowNum = rowNum;
        this.colNum = colNum;


        this.capacity= this.rowNum * this.colNum;       //容量为行数×列数

        if(this.capacity%3!=0){
            throw new Exception("容量不是3的倍数");
        }

        this.cells=new Cell[this.rowNum][this.colNum];      //因为传递的是行号和列号，所以可以通过行号和列号创建对象.
        this.size=0;        //默认为零

        this.offsetx=new Random().nextInt(100);
        this.offsety=new Random().nextInt(100); //用随机数设置偏移量
    }

    public void showCell(){
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                Brand brands1= cells[row][col].getBrand();
                System.out.print(brands1.getName()+"-");
            }
            System.out.println();

        }
    }
    /*   get/set方法   */

    public Layer getParent() {
        return parent;
    }

    public void setParent(Layer parent) {
        this.parent = parent;
    }

    public Integer getOffsety() {
        return offsety;
    }

    public void setOffsety(Integer offsety) {
        this.offsety = offsety;
    }

    public Integer getOffsetx() {
        return offsetx;
    }

    public void setOffsetx(Integer offsetx) {
        this.offsetx = offsetx;
    }





    public Integer getRowNum() {
        return rowNum;
    }

    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    public Integer getColNum() {
        return colNum;
    }

    public void setColNum(Integer colNum) {
        this.colNum = colNum;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
