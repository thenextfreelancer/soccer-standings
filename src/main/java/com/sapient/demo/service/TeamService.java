package com.sapient.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.sapient.demo.repository.TeamClient;
import com.sapient.demo.repository.TeamStandingClient;
import com.sapient.demo.service.pojo.Team;
import com.sapient.demo.service.pojo.TeamStanding;
import com.sapient.demo.shared.Utils;

@Service
public class TeamService
{

   private static final Logger LOGGER = LoggerFactory.getLogger(LeagueService.class);

   @Autowired
   private TeamClient client;

   @Autowired
   private TeamStandingClient standingClient;

   public List<Team> getByLeagueId(int leagueId)
   {
      List<Team> teams = Lists.newArrayList();
      try
      {
         ResponseEntity<com.sapient.demo.rest.api.entities.Team[]> response = client.getByLeagueId(leagueId);
         for (com.sapient.demo.rest.api.entities.Team t : response.getBody())
         {
            teams.add(entityToPojo(t));
         }
      }
      catch (Exception e)
      {
         LOGGER.error("Error while fetching team list", e);
         throw e;
      }
      return teams;
   }

   public TeamStanding getTeamStandings(int leagueId, int teamId)
   {
      TeamStanding ts = null;
      try
      {
         ResponseEntity<com.sapient.demo.rest.api.entities.TeamStanding[]> response = standingClient.getByLeagueId(leagueId);
         for (com.sapient.demo.rest.api.entities.TeamStanding t : response.getBody())
         {
            int _teamId = Utils.parseToInt(t.getTeamId());
            if (teamId == _teamId)
            {
               ts = entityToPojo(t);
               break;
            }
         }
      }
      catch (Exception e)
      {
         LOGGER.error("Error while fetching team list", e);
         throw e;
      }
      return ts;
   }

   private Team entityToPojo(com.sapient.demo.rest.api.entities.Team source)
   {
      return new Team(Utils.parseToInt(source.getId()), source.getName(), source.getLogo());
   }

   private TeamStanding entityToPojo(com.sapient.demo.rest.api.entities.TeamStanding source)
   {
      return new TeamStanding(
         Utils.parseToInt(source.getTeamId()),
         source.getTeamName(),
         Utils.parseToInt(source.getLeagueId()),
         source.getLeagueName(),
         source.getCountryName(),
         Utils.parseToInt(source.getLeaguePosition()));
   }
}
