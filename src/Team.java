public class Team {
    private String name;
    private int wins;
    private double probability;
    
    public Team(String name, double probability) { // initializes the team
        this.name = name;
        this.wins = 0;
        this.probability = probability;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public void addWins(int wins) { // tracks wins 
        this.wins += wins;
    }

    public double getProbability() { 
        return probability;
    }
}
