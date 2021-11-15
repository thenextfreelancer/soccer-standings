package com.sapient.demo.rest.api.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.sapient.demo.service.TeamService;
import com.sapient.demo.service.pojo.Response;
import com.sapient.demo.service.pojo.Team;
import com.sapient.demo.service.pojo.TeamStanding;

@RestController
@RequestMapping("/team")
public class TeamController
{

   @Autowired
   private TeamService service;

   /**
    * Get team information
    * 
    * @param country_id
    * @param league_id
    * @return
    */
   @GetMapping(params = { "league_id" })
   public Response<Team> getByLeagueId(@RequestParam Integer league_id)
   {
      try
      {
         Response<Team> response = new Response<>(service.getByLeagueId(league_id), true, HttpStatus.OK);
         response.add(linkTo(methodOn(TeamController.class).getByLeagueId(league_id)).withSelfRel());
         return response;
      }
      catch (Exception e)
      {
         return new Response<>(Lists.newArrayList(), false, HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }

   /**
    * Get team standing position
    * 
    * @param country_id
    * @param league_id
    * @return
    */
   @GetMapping(path= "/standings", params = { "team_id", "league_id" })
   public Response<TeamStanding> getStandingPosition(@RequestParam Integer team_id, @RequestParam Integer league_id)
   {
      try
      {
         TeamStanding ts = service.getTeamStandings(league_id, team_id);
         Response<TeamStanding> response = new Response<>(Lists.newArrayList(ts), true, HttpStatus.OK);
         response.add(linkTo(methodOn(TeamController.class).getStandingPosition(team_id, league_id)).withSelfRel());
         return response;
      }
      catch (Exception e)
      {
         return new Response<>(Lists.newArrayList(), false, HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }

}