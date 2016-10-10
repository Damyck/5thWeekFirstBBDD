import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Marc on 10/10/2016.
 */
public abstract class DAO {

    String name;
    String address;

    public void insert(){

        StringBuffer query = new StringBuffer();
        query.append("insert into ").append(this.getClass().getSimpleName()).append(" (");



        Field[] fields = this.getClass().getDeclaredFields();
        int numfields = 1;
        for (Field f: fields){
            System.out.println(f.getName());
            if (fields.length == numfields) {
                query.append(f.getName());
            }
            else {
                query.append(f.getName()).append(", ");
            }
            numfields++;
            }
        query.append(") ");

        Method[] methods = this.getClass().getMethods();

        for (Method m: methods){

            // System.out.println(m.getName());
            if (m.getName().equals("getName") ) try {

                this.name = (String)m.invoke(this, null );
                System.out.println("Dame nombre loco " + name);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            if (m.getName().equals("getAddress")) try {


                try {
                    address = (String)m.invoke(this, null);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                System.out.println("Donde vive payo? "+address);
            } catch(IllegalAccessException e){
                e.printStackTrace();

            }
              catch (IncompatibleClassChangeError e) {
                    e.printStackTrace();
            }
        }

        query.append(" values (?,?,?)");
        System.out.println(query.toString());
        /* try {
            Method res = this.getClass().getMethod("getAddress", null);
            try {
                String u = (String) res.invoke(this, null);
                System.out.println(u);
            }
            catch(IllegalAccessException e){
                e.printStackTrace();

            }
            catch (InvocationTargetException e){
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
*/

    }
}
