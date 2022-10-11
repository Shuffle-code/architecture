package geekbrains.config;

import java.io.IOException;
import java.util.Properties;

class ConfigFromFile implements Config {
    private final String WWW;
    public final int port;

    public ConfigFromFile(String fileProperties){
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream(fileProperties));
        } catch (IOException e) {
            throw new IllegalStateException();
        }
        this.WWW = properties.getProperty("homeWWW");
        this.port = Integer.parseInt(properties.getProperty("port"));
        System.out.println(port);
    }

    @Override
    public String getWWW() {
        return this.WWW;
    }

    @Override
    public int getPort() {
        return this.port;
    }
}
