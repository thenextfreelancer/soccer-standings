package com.sapient.demo.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.sapient.demo.service.CountryService;
import com.sapient.demo.service.pojo.Country;
import com.sapient.demo.service.pojo.Response;

@RestController
@RequestMapping("/country")
public class CountryController
{
   @Autowired
   private CountryService service;
   
   /**
    * Get team information
    * 
    * @param country_id
    * @param league_id
    * @return
    */
   @GetMapping
   public Response<Country> get()
   {
      try
      {
         return new Response<Country>(service.get(), true, HttpStatus.OK);
      }
      catch (Exception e)
      {
         return new Response<Country>(Lists.newArrayList(), false, HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }
}
