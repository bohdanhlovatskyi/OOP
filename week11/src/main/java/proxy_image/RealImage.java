package proxy_image;

public class RealImage implements Image {
    public String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        System.out.println("Displaying real image");
    }

    public void loadFromDisk() {
        System.out.println("Loading real image from a disk");
    }
}
