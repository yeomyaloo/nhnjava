public class TV {

    private String manufacturer;
    private int year;
    private int size;

    public TV(String manufacturer, int year, int size) {
        this.manufacturer = manufacturer;
        this.year = year;
        this.size = size;
    }

    public void show(){
        System.out.println(manufacturer+"에서 만든"+year+"년 " +size+"인치 TV");
    }

    public static void main(String[] args) {
        TV myTv = new TV("LG",2017,32);
        myTv.show();
    }
}
