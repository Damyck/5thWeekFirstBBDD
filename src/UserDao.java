/**
 * Created by Marc on 10/10/2016.
 */
public class UserDao extends DAO {

    private int id;
    private String name;
    private String address;

    public  UserDao(String name, String address){
        super();
        this.name = name;
        this.address = address;

    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }
}
