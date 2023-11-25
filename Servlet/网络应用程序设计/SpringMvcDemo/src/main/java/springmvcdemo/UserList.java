package springmvcdemo;

import java.util.ArrayList;

public class UserList {

    private ArrayList<User> ulist;

    public ArrayList<User> getUlist() {
        return ulist;
    }

    public void setUlist(ArrayList<User> ulist) {
        this.ulist = ulist;
    }

    public UserList(){
        ulist = new ArrayList<User>();
    }

    public UserList(ArrayList<User> ulist) {
        this.ulist = ulist;
    }

}
