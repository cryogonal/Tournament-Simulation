public class Team {
    private String name;
    private int wins;
    
    public Team(String name) { // initializes the team
        this.name = name;
        this.wins = 0;
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
}
