package Test;

import Model.Brand;
import Model.Cell;
import Model.Layer;
import Tool.LayerUtil;


import javax.swing.*;

//测试渲染一个图层(Layer)数据
public class TestRenderLayer extends JFrame {

    private Layer layer= LayerUtil.build(6,6);

    public TestRenderLayer(){
        /*初始化窗口基本信息*/
        inti();

        /*渲染图层*/
        renderLayer();
        /*自动刷新*/
        autoRefresh();          //自动刷新线程
    }

    private void renderLayer(){
        /*渲染图层
        默认情况下 brand牌的左上角坐标是0,0    需要改变牌的坐标
        设置布局方式，默认swing 添加组件 提供了多种布局方式  网格、流线、、、  绝对布局
         */
        Cell[][] cells=layer.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                Brand brands1 = cells[row][col].getBrand();

                int x=col*50;
                int y=row*50;       //设置xy坐标
                brands1.setBounds(x,y,50,50);

                this.getContentPane().add(brands1);
            }
            System.out.println();
        }

    }
    private void autoRefresh(){     //自动刷新方法

        JFrame main=this;

        new Thread(new Runnable() {
            @Override
            public void run() {     //一直执行刷新页面
                while(true){

                    main.repaint();
                    try {
                        Thread.sleep(40);   //40毫秒刷新一次
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    private void inti(){
        this.setTitle("羊了个羊");      //标题
        this.setSize(450,800);      //设置窗口大小
        this.setVisible(true);  //窗口显示(默认关闭)

        this.setLocationRelativeTo(null);       //窗口居中

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //关闭窗口的同时也关闭进程

        /*设置绝对布局*/
        this.setLayout(null);
        this.setBounds(0,0,450,800);
    }

    public static void main(String[] args) {
        new TestRenderLayer();
    }



}
