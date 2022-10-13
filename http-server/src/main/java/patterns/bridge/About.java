package patterns.bridge;

public class About implements WebPage {
    private final Theme theme;

    public About(Theme theme) {
        this.theme = theme;
    }

    @Override
    public void getContent() {
        System.out.printf("About page in %s%n", theme.getColor());
    }
}
