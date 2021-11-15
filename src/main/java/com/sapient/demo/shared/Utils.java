package com.sapient.demo.shared;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sapient.demo.service.LeagueService;

public class Utils
{
   private static final Logger LOGGER = LoggerFactory.getLogger(LeagueService.class);
   
   public static int parseToInt(String value)
   {
      if (value == null || value.isEmpty())
         return 0;

      try
      {
         return Integer.parseInt(value);
      }
      catch (NumberFormatException e)
      {
         LOGGER.warn("Error while casting String to Integer.", e);
         return 0;
      }
   }
}
