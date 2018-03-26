package withoutparent;

public class Cat {
    private String name;
    private String color;
    private int weight;

    public Cat() {
    }

    public Cat(String name, String color, int weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * method for cat feeding
     * @param foodName ...
     * @param foodWeight ...
     */
    public void eat(String foodName, int foodWeight) {
        ///to do sth
    }

    /**
     * volume of sound which make cat
     * @return volume in dB
     */
    public int meom() {
        return 30;
    }

    private void scrubFurniture() {
        ///to do sth
    }
}
