package com.test.arrays;

import java.util.*;

public class TournamentWinner {
    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Write your code here.
        Map<String,Integer> teamScoreMap = new Hashtable<>();
        HighestValueTeam highestValueTeam = new HighestValueTeam();
        final int homeTeamWon = 1;
        final int awayTeamWon = 0;
        for (int idx = 0; idx < competitions.size(); idx++) {
            if(results.get(idx) ==0){
                updateMap(competitions, teamScoreMap, idx, homeTeamWon,highestValueTeam);
            } else {
                updateMap(competitions, teamScoreMap, idx, awayTeamWon, highestValueTeam);
            }
        }

        return highestValueTeam.highestValueTeamName;
    }

    private class HighestValueTeam{
        int highestValue =0;
        String highestValueTeamName = "";
    }

    private void updateMap(ArrayList<ArrayList<String>> competitions,
                           Map<String, Integer> teamScoreMap,
                           int idx,
                           int teamWinStatus,
                           HighestValueTeam highestValueTeam) {
        int value;
        if (teamScoreMap.containsKey(competitions.get(idx).get(teamWinStatus))) {
            value = teamScoreMap.get(competitions.get(idx).get(teamWinStatus));
            value = value + 3;
        } else {
            value = 3;
        }
        teamScoreMap.put(competitions.get(idx).get(teamWinStatus), value);
        if(highestValueTeam.highestValue < value){
            highestValueTeam.highestValue = value;
            highestValueTeam.highestValueTeamName = competitions.get(idx).get(teamWinStatus);
        }
    }

    public static void main(String[] args) {

    }
}
