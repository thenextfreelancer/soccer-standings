package com.sapient.demo.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.sapient.demo.service.LeagueService;
import com.sapient.demo.service.pojo.League;
import com.sapient.demo.service.pojo.Response;

@RestController
@RequestMapping("/league")
public class LeagueController
{

   @Autowired
   private LeagueService service;

   @GetMapping
   public Response<League> get()
   {
      try
      {
         return new Response<>(service.get(), true, HttpStatus.OK);
      }
      catch (Exception e)
      {
         return new Response<>(Lists.newArrayList(), false, HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }

   @GetMapping(params = { "country_id" })
   public Response<League> get(@RequestParam Integer country_id)
   {
      try
      {
         return new Response<>(service.get(country_id), true, HttpStatus.OK);
      }
      catch (Exception e)
      {
         return new Response<>(Lists.newArrayList(), false, HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }
}
