package semaphore.src;

import java.util.concurrent.Semaphore;

public class ConnectionLimiter {
    private final Semaphore semaphore;

    public ConnectionLimiter(int maxConcurrentRequests) {
        semaphore = new Semaphore(maxConcurrentRequests);
    }
    
    public URLConnection acquire(URL url) throws InterruptedException {
        semaphore.acquire();
        return url.openConnection();
    }
    
    public void release(URLConnection connection) {
        connection.close();
        semaphore.release();
    }
}


class URL {
    String address;

    public URL(String address) {
        this.address = address;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String url) {
        this.address = url;
    }
    
    public URLConnection openConnection() {
        URLConnection connection = new URLConnection(this);
        connection.connect();
        return connection;
    }
}

class URLConnection {

    private URL url;

    public URLConnection(URL url) {
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }
    
    public void connect() {
        System.out.println("    New connection to URL: " + this.url.getAddress());
    }

    public void close() {
        System.out.println("    Closed connection to URL: " + this.url.getAddress());
    }
    
}