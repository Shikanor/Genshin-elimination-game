package Model;
import BeginGame.Play;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/*
游戏中的牌
*/
public class Brand extends Component {        //牌类
    /*牌基础信息*/
    private String name;    //名称
    private boolean isGray;    //判断当前的牌是否是在牌堆下
    private Image image;        //正常图片
    private Image grayimage;     //牌堆下灰色图片

    /*坐标*/
    private Integer x;      //代表在渲染的时候左上角的坐标
    private Integer y;

    /*宽高度*/
    private Integer width;
    private Integer height;
    /**/
    private Cell cell;

    EliminateBox eliminateBox =new EliminateBox();


    public Brand(String name){      //含name参数构造
        this.name=name;
        /*通过name的值 对应图片目录下的图片前缀*/
        this.image = Toolkit.getDefaultToolkit().getImage("imgs\\"+name+".png");    //通过name找到图片
        this.grayimage=Toolkit.getDefaultToolkit().getImage("imgs\\"+name+"Gray.png");      //通过name找到灰色图片

        this.isGray=false;       //默认不置灰

        /*设置宽高*/
        this.width=50;
        this.height=50;
        /*设置默认坐标*/
        this.x=0;
        this.y=0;

        this.addMouseListener(new MouseAdapter() {      //鼠标监听器
            @Override
            public void mouseClicked(MouseEvent e) {        //点击鼠标
                System.out.println("点击鼠标");

                Brand brand=(Brand) e.getSource();      //点击后获取当前组件     强制下转型(默认是object)

                if (brand.getGray()){
                    //灰色
                    return;
                }else {

                    /*只在页面中删除了brand对象，但是cell状态中的state和brand没有删除*/
                    //brand.getParent().remove(brand);        //调用上层容器删除自己    一般树形结构使用这样的方式
                    eliminateBox.addBox(brand);


                    /*解决问题关键是纪要删除UI当中的组件，还要删除数据模型中的数据和对应状态*/
                    cell.setState(0);
                    cell.setBrand(null);


                    Play.map.compareAll();          //涉及到map对象的共享  处理：把map对象设为静态变量
                }


            }
        });

    }

    @Override
    public void paint(Graphics g) {     //重写Component的paint方法(绘制函数)
        if(this.isGray==true){                  //通过控制isGray来控制图片的灰色和彩色
            //绘制灰色图片
            g.drawImage(this.grayimage,this.x,this.y,null);
        }else {
            //绘制正常图片
            g.drawImage(this.image,this.x,this.y,null);
        }
    }

    /*     set/get     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGray() {
        return isGray;
    }

    public void setGray(boolean gray) {
        isGray = gray;
    }
    public boolean getGray(){
        return isGray;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getGrayimage() {
        return grayimage;
    }

    public void setGrayimage(Image grayimage) {
        this.grayimage = grayimage;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
    //    public Integer getX() {
//        return x;
//    }
//
//    public void setX(Integer x) {
//        this.x = x;
//    }
//
//    public Integer getY() {
//        return y;
//    }
//
//    public void setY(Integer y) {
//        this.y = y;
//    }
//
//    public Integer getWidth() {
//        return width;
//    }
//
//    public void setWidth(Integer width) {
//        this.width = width;
//    }
//
//    public Integer getHeight() {
//        return height;
//    }
//
//    public void setHeight(Integer height) {
//        this.height = height;
//    }
}
