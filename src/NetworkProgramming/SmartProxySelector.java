package NetworkProgramming;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class SmartProxySelector extends ProxySelector {

    private final ProxySelector defaultSelector = ProxySelector.getDefault();
    private final Proxy proxy;
    private final Set<String> failedHosts = new HashSet<>();

    public SmartProxySelector(Proxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public List<Proxy> select(URI uri) {
        String host = uri.getHost();

        if (failedHosts.contains(host)) {
            System.out.println("Skipping proxy for host: " + host);
            return Collections.singletonList(Proxy.NO_PROXY);
        }

        // Otherwise, try proxy first
        System.out.println("Using proxy for host: " + host);
        return Arrays.asList(proxy, Proxy.NO_PROXY);
    }

    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        String host = uri.getHost();
        System.out.println("Proxy connection failed for host: " + host);
        failedHosts.add(host); // Mark as failed
    }

    public static void main(String[] args) throws IOException {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8888));

        ProxySelector.setDefault(new SmartProxySelector(proxy));

        List<String> testUrls = Arrays.asList(
                "https://example.com",
                "https://example.com",
                "https://httpbin.org/get"
        );

        for (String urlString : testUrls) {

                System.out.println("Connecting to: " + urlString);
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                System.out.println("------------------------------------------------");
        }
        }
    }

