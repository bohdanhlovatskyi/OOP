import proxy_image.ProxyImage;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        ProxyImage im = new ProxyImage(".");
        im.display();
    }
}
