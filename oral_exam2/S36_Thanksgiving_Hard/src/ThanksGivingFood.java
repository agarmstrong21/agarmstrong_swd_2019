public class ThanksGivingFood {
    private String name = "";
    private int weight = 0;
    private int enjoyment = 0;


    public ThanksGivingFood(String name, int weight, int enjoyment){
        this.name = name;
        this.weight = weight;
        this.enjoyment = enjoyment;
    }

    public int getEnjoyment() {
        return enjoyment;
    }

    public void setEnjoyment(int enjoyment) {
        this.enjoyment = enjoyment;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print(){
          System.out.println(name + " - weight: " +  weight + ", enjoyment: " + enjoyment);
    }
}
