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

import com.sapient.demo.service.LeagueService;
import com.sapient.demo.service.pojo.League;
import com.sapient.demo.service.pojo.Response;

public class LeagueControllerTest extends AbstractTest
{
   @Autowired
   private LeagueController controller;
   
   @MockBean
   private LeagueService service;


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
   public void get() throws Exception
   {
      String uri = "/league";
      ArrayList<League> list = Lists.newArrayList(new League(1,"name","logo","countryId","countryName"));
      given(service.get()).willReturn(list);
      
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      Response<League> productlist = super.mapFromJson(content, Response.class);
      assertTrue(productlist.getList().size() == 1);
   }
   
   @SuppressWarnings("unchecked")
   @Test
   public void getByCountryId() throws Exception
   {
      String uri = "/league?country_id=1";
      ArrayList<League> list = Lists.newArrayList(new League(1,"name","logo","countryId","countryName"));
      given(service.get(anyInt())).willReturn(list);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      Response<League> productlist = super.mapFromJson(content, Response.class);
      assertTrue(productlist.getList().size() == 1);
   }
}
