package proxy_image;

public class ProxyImage implements Image {
    private RealImage realImage;
    public String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
        this.realImage = new RealImage(fileName);
    }

    public void display() {
        System.out.println("Proxy image: logic before the real image display call (middleware analogy)");
        realImage.display();
        System.out.println("Proxy image: logic after the read image call");
    }
}
