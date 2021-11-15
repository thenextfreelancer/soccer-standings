package com.sapient.demo.rest.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamStanding
{
   @JsonProperty("team_id")
   private String teamId;

   @JsonProperty("team_name")
   private String teamName;

   @JsonProperty("league_id")
   private String leagueId;

   @JsonProperty("league_name")
   private String leagueName;

   @JsonProperty("country_name")
   private String countryName;

   @JsonProperty("overall_league_position")
   private String leaguePosition;

   public TeamStanding()
   {}

   public TeamStanding(String teamId, String teamName, String leagueId, String leagueName, String countryName, String leaguePosition)
   {
      this.teamId = teamId;
      this.teamName = teamName;
      this.leagueId = leagueId;
      this.leagueName = leagueName;
      this.countryName = countryName;
      this.leaguePosition = leaguePosition;
   }

   public String getTeamId()
   {
      return teamId;
   }

   public void setTeamId(String teamId)
   {
      this.teamId = teamId;
   }

   public String getTeamName()
   {
      return teamName;
   }

   public void setTeamName(String teamName)
   {
      this.teamName = teamName;
   }

   public String getLeagueId()
   {
      return leagueId;
   }

   public void setLeagueId(String leagueId)
   {
      this.leagueId = leagueId;
   }

   public String getLeagueName()
   {
      return leagueName;
   }

   public void setLeagueName(String leagueName)
   {
      this.leagueName = leagueName;
   }

   public String getCountryName()
   {
      return countryName;
   }

   public void setCountryName(String countryName)
   {
      this.countryName = countryName;
   }

   public String getLeaguePosition()
   {
      return leaguePosition;
   }

   public void setLeaguePosition(String leaguePosition)
   {
      this.leaguePosition = leaguePosition;
   }

}
