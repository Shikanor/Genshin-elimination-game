package Model;

/*
    单元格类
    有两种状态, 0:无牌，1：有牌;
 */
public class Cell {
    private Integer state;      //0、1
    private  Brand brand;


    /*   get/set方法   */
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
