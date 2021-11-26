package com.sapient.demo.rest.api.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sapient.demo.service.CountryService;
import com.sapient.demo.service.pojo.Country;
import com.sapient.demo.service.pojo.League;
import com.sapient.demo.service.pojo.Response;

public class CountryControllerTest extends AbstractTest
{

   @Autowired
   private CountryController controller;

   @MockBean
   private CountryService service;

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
      String uri = "/country";
      ArrayList<Country> list = Lists.newArrayList(new Country(1,"name","logo"));
      given(service.get()).willReturn(list);
      
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();

      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      Response<Country> productlist = super.mapFromJson(content, Response.class);
      assertTrue(productlist.getList().size() == 1);
   }
}
