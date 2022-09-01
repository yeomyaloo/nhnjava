public class Swap {

    int value;

    public Swap(int value) {
        this.value = value;
    }
    private static void swap(Swap a, Swap b) {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }
    public static void main(String[] args) {
        Swap a = new Swap(1);
        Swap b = new Swap(2);
        System.out.println(a.value + " " +b.value);

        swap(a,b);
        System.out.println(a.value + " " +b.value);
    }


}
