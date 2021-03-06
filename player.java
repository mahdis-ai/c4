public class player {
private String name;
private String color;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;

     public player(String name,String color){

         this.name=name;
         this.color=color;
     }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
