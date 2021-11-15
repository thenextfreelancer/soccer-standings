package com.sapient.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.sapient.demo.repository.LeagueClient;
import com.sapient.demo.service.pojo.League;

@Service
public class LeagueService
{
   private static final Logger LOGGER = LoggerFactory.getLogger(LeagueService.class);

   @Autowired
   private LeagueClient client;

   public List<League> get() throws Exception
   {
      List<League> leagues = Lists.newArrayList();
      try
      {
         ResponseEntity<com.sapient.demo.rest.api.entities.League[]> response = client.get();
         for (com.sapient.demo.rest.api.entities.League l : response.getBody())
         {
            leagues.add(entityToPojo(l));
         }
      }
      catch (Exception e)
      {
         LOGGER.error("Error while fetching league list", e);
         throw e;
      }
      return leagues;
   }

   public List<League> get(int countryId) throws Exception
   {
      List<League> leagues = Lists.newArrayList();
      try
      {
         ResponseEntity<com.sapient.demo.rest.api.entities.League[]> response = client.getByCountryId(countryId);
         for (com.sapient.demo.rest.api.entities.League l : response.getBody())
         {
            leagues.add(entityToPojo(l));
         }
      }
      catch (Exception e)
      {
         LOGGER.error("Error while fetching league list", e);
         throw e;
      }
      return leagues;
   }

   private League entityToPojo(com.sapient.demo.rest.api.entities.League source)
   {
      return new League(Integer.parseInt(source.getId()), source.getName(), source.getLogo(), source.getCountryId(), source.getCountryName());
   }
}
