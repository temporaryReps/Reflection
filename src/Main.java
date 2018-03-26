import withoutparent.Cat;

public class Main {
    public static void main(String[] args) {
        new Descriptor().describe(TestAbstract.class);
        new Descriptor().describe(Cat.class);
    }
}
