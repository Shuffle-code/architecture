package geekbrains.config;
public class ConfigFromCLI implements Config {
    private final String WWW;
    public final int port;

    public ConfigFromCLI(String [] args){
        if(args.length < 2) {
            throw new IllegalStateException("No parameters specified");
        }

        this.WWW = args[0];
        this.port = Integer.parseInt(args[1]);
        System.out.println("Path + port: " + WWW + port);
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
