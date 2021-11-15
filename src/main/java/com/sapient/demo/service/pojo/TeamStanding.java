package com.sapient.demo.service.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamStanding
{
   private int teamId;

   private String teamName;

   private int leagueId;

   private String leagueName;

   private String countryName;

   private int leaguePosition;

   public TeamStanding(@JsonProperty("teamId") int teamId, @JsonProperty("teamName") String teamName,
      @JsonProperty("leagueId") int leagueId, @JsonProperty("leagueName") String leagueName, @JsonProperty("countryName") String countryName,
      @JsonProperty("leaguePosition") int leaguePosition)
   {
      this.teamId = teamId;
      this.teamName = teamName;
      this.leagueId = leagueId;
      this.leagueName = leagueName;
      this.countryName = countryName;
      this.leaguePosition = leaguePosition;
   }

   public int getTeamId()
   {
      return teamId;
   }

   public void setTeamId(int teamId)
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

   public int getLeagueId()
   {
      return leagueId;
   }

   public void setLeagueId(int leagueId)
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

   public int getLeaguePosition()
   {
      return leaguePosition;
   }

   public void setLeaguePosition(int leaguePosition)
   {
      this.leaguePosition = leaguePosition;
   }

}
