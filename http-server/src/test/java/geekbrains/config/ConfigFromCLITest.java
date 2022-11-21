package geekbrains.config;

import org.junit.Assert;
import org.junit.Test;

public class ConfigFromCLITest {
    @Test
    public void testConfigFromCLI(){
        Config config = new ConfigFromCLI(new String[] {"first", "1234"});
        Assert.assertEquals("first",config.getWWW());
        Assert.assertEquals(1234, config.getPort());
    }
}
