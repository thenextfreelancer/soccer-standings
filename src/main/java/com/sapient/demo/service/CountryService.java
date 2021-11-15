package com.sapient.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.sapient.demo.repository.CountryClient;
import com.sapient.demo.service.pojo.Country;

@Service
public class CountryService
{
   private static final Logger LOGGER=LoggerFactory.getLogger(CountryService.class);
   
   @Autowired
   private CountryClient client;
   
   public List<Country> get() throws Exception
   {
      List<Country> countries= Lists.newArrayList();
      try
      {
         ResponseEntity<com.sapient.demo.rest.api.entities.Country[]> response = client.getAll();
         for(com.sapient.demo.rest.api.entities.Country c : response.getBody())
         {
            countries.add(new Country(Integer.parseInt(c.getId()), c.getName(), c.getLogo()));
         }
      }
      catch (Exception e)
      {
         LOGGER.error("Error while fetching country list", e);
         throw e;
      }
      return countries;
   }
}
