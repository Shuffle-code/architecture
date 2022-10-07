package geekbrains.config;

public class ConfigFactory {
    public static Config create(String[] args) {
        if (args.length == 2) {
            return new ConfigFromCLI(args);
        } else {
            return new ConfigFromFile("./../../server.properties");

        }
    }
}
