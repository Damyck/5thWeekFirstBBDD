/**
 * Created by Marc on 10/10/2016.
 */
public class Main {
    public static void main(String[] args) {

        UserDao ud = new UserDao("Pepe","Casa Dios");
        ud.insert();
    }
}
