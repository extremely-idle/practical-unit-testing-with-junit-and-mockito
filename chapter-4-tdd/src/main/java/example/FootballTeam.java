package example;

public class FootballTeam implements Comparable<FootballTeam> {
    private int gamesWon;

    public FootballTeam(int gamesWon) {
        if (gamesWon < 0) {
            throw new IllegalArgumentException("Invalid number of games won.");
        }

        this.gamesWon = gamesWon;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    @Override
    public int compareTo(FootballTeam otherTeam) {
        return gamesWon - otherTeam.getGamesWon();
    }
}
