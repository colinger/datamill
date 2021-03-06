package foundation.stack.datamill.configuration;

/**
 * @author Israel Colomer (israelcolomer@gmail.com)
 */
public class SystemPropertyRetriever {

    private SystemPropertyRetriever() {
    }

    public static String getSystemProperty(String name, boolean required) {
        String value = System.getProperty(name);

        if (value == null) {
            value = System.getenv(name);
        }

        if (value == null && required) {
            throw new IllegalStateException("Expected " + name + " to be found in the system properties list!");
        }

        return value;
    }
}
