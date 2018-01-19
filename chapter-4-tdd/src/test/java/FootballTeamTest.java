import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.Assert.assertEquals;
import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {

    public static final int GAMES_WON = 3;
    public static final int ANY_NUMBER = 123;

    public Object[] numberOfGamesWon() {
        return $(0, 1, 2);
    }

    public Object[] invalidNumberOfGamesWon() {
        return $(-10, -1);
    }

    @Test
    public void should_SetGamesWon_When_ConstructorCalledWithValidGamesWon() {
        FootballTeam team = new FootballTeam(GAMES_WON);
        assertEquals("3 games passed to constructor, but " + team.getGamesWon() + " were returned", GAMES_WON, team
                .getGamesWon());
    }

    @Test
    @Parameters(method = "numberOfGamesWon")
    public void should_SetGamesWon_When_ConstructorCalledWithValidGamesWon(int gamesWon) {
        FootballTeam team = new FootballTeam(gamesWon);
        assertEquals(gamesWon + " games passed to constructor, but " + team.getGamesWon() + " were returned",
                gamesWon, team.getGamesWon());
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "invalidNumberOfGamesWon")
    public void should_ThrowException_When_ConstructorCalledWithInvalidGamesWon(int gamesWon) {
        new FootballTeam(gamesWon);
    }

    @Test
    public void should_BeInstanceOfComparable() {
        FootballTeam team = new FootballTeam(ANY_NUMBER);

        assertTrue(team instanceof Comparable, "FootballTeam should implement Comparable");
    }

    @Test
    public void teamsWithMoreMatchesWonShouldBeGreater() {
        FootballTeam team_2 = new FootballTeam(2);
        FootballTeam team_3 = new FootballTeam(3);

        assertTrue(team_3.compareTo(team_2) > 0, "team with " + team_3.getGamesWon() + " games won should be ranked" +
                " higher than the team with " +
                team_2.getGamesWon() + " games won");
    }

    @Test
    public void teamsWithLessMatchesWonShouldBeLesser() {
        FootballTeam team_2 = new FootballTeam(2);
        FootballTeam team_3 = new FootballTeam(3);

        assertTrue(team_2.compareTo(team_3) < 0, "team with " + team_2.getGamesWon() + " games won should be ranked" +
                " lower than the team with " +
                team_3.getGamesWon() + " games won");
    }

    @Test
    public void teamsWithSameNumberOfMatchesWonShouldBeEqual() {
        FootballTeam teamA = new FootballTeam(2);
        FootballTeam teamB = new FootballTeam(2);

        assertTrue(teamA.compareTo(teamB) == 0, "both teams have won the same number of games : " + teamA
                .getGamesWon() + " vs. " + teamB.getGamesWon() + " and should be ranked the same");
    }
}