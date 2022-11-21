package system_patterns.orm;

public class Authority {

    private int id;
    private String permission;


    public void setId(int id) {
        this.id = id;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getId() {
        return id;
    }

    public String getPermission() {
        return permission;
    }

    public Authority(int id, String permission) {
        this.id = id;
        this.permission = permission;
    }


}
