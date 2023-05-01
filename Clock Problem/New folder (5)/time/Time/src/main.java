public class main {
    public static void main(String[] args) {

        Time time1 = new Time(23, 59, 59);
        Time time2 = new Time(23, 59, 59);
        time1.add(time2);
        System.out.println(time1.toString());
    }
}
