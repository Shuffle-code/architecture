package patterns.adapter;

public class WillDogAdapter implements Lion{
    private final WillDog dog;

    public WillDogAdapter(WillDog dog) {
        this.dog = dog;
    }

    @Override
    public void roar() {
        dog.dark();
    }
}
