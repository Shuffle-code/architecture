package geekbrains.config;

import java.io.IOException;
import java.util.Properties;

public class ConfigConnectionFromFile implements ConfigConnection{
    private final String url;
    private final String username;
    private final String password;

    public ConfigConnectionFromFile(String fileProperties) throws IOException {
        Properties properties = new Properties();
        properties.load(getClass().getResourceAsStream(fileProperties));
        this.url= properties.getProperty("url");
        this.username = properties.getProperty("username");
        this.password= properties.getProperty("password");
    }


    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
