package com.sapient.demo.rest.api.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.*;

import java.util.ArrayList;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sapient.demo.service.TeamService;
import com.sapient.demo.service.pojo.Team;
import com.sapient.demo.service.pojo.TeamStanding;
import com.sapient.demo.service.pojo.Response;

public class TeamControllerTest extends AbstractTest
{
   @Autowired
   private TeamController controller;
   
   @MockBean
   private TeamService service;


   @Override
   @Before
   public void setUp()
   {
      super.setUp();
   }

   @Test
   public void contextLoads() throws Exception
   {
      assertTrue(controller != null);
   }
   
   @SuppressWarnings("unchecked")
   @Test
   public void getByLeagueId() throws Exception
   {
      String uri = "/team?league_id=1";
      ArrayList<Team> list = Lists.newArrayList(new Team(1,"name","logo"));
      given(service.getByLeagueId(anyInt())).willReturn(list);
      
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      Response<Team> productlist = super.mapFromJson(content, Response.class);
      assertTrue(productlist.getList().size() == 1);
   }
   
   @SuppressWarnings("unchecked")
   @Test
   public void getStandingPosition() throws Exception
   {
      String uri = "/team/standings?league_id=1&team_id=1";
      TeamStanding ts = new TeamStanding(1,"teamName", 1, "leagueName", "countryName", 1);
      given(service.getTeamStandings(anyInt(), anyInt())).willReturn(ts);
      
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      Response<TeamStanding> productlist = super.mapFromJson(content, Response.class);
      assertTrue(productlist.getList().size() == 1);
   }
}
