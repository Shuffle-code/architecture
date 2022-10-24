package patterns.bridge;

public class Careers implements WebPage {
    private final Theme theme;

    public Careers(Theme theme) {
        this.theme = theme;
    }

    @Override
    public void getContent() {
        System.out.printf("Careers page in %s%n", theme.getColor());
    }
}
