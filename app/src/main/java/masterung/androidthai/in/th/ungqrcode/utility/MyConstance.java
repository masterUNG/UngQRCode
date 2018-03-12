package masterung.androidthai.in.th.ungqrcode.utility;

/**
 * Created by masterung on 8/3/2018 AD.
 */

public class MyConstance {

    private String urlReadAllFood = "http://androidthai.in.th/cent/getAllFood.php";
    private String urlAddUser = "http://androidthai.in.th/cent/addDataMaster.php";
    private String urlReadAllUser = "http://androidthai.in.th/cent/getAllDataMaster.php";

    private String[] columnUserTableStrings = new String[]{"id", "Name", "User", "Password"};


    public String getUrlReadAllFood() {
        return urlReadAllFood;
    }

    public String[] getColumnUserTableStrings() {
        return columnUserTableStrings;
    }

    public String getUrlReadAllUser() {
        return urlReadAllUser;
    }

    public String getUrlAddUser() {
        return urlAddUser;
    }
}
