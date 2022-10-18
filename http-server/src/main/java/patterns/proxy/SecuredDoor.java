package patterns.proxy;

public class SecuredDoor implements Door {

    private final Door door;

    public SecuredDoor(Door door) {
        this.door = door;
    }


    public void open(String password) {
        if (authenticate(password)) {
            open();
        }else System.out.println("Big no! It ain't possible. ");
    }

    public boolean authenticate(String password){
        if (password == "1234"){
        return true;
        }
        return false;
    }

    @Override
    public void open() {
        door.open();
    }

    @Override
    public void close() {
        door.close();
    }
}
