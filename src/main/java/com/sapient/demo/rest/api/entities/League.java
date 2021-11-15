package com.sapient.demo.rest.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class League
{
   @JsonProperty("league_id")
   private String id;

   @JsonProperty("league_name")
   private String name;

   @JsonProperty("league_logo")
   private String logo;

   @JsonProperty("country_id")
   private String countryId;

   @JsonProperty("country_name")
   private String countryName;

   public League()
   {}

   public League(String id, String name, String logo, String countryId, String countryName)
   {
      this.id = id;
      this.name = name;
      this.logo = logo;
      this.countryId = countryId;
      this.countryName = countryName;
   }

   public String getId()
   {
      return id;
   }

   public void setId(String id)
   {
      this.id = id;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getLogo()
   {
      return logo;
   }

   public void setLogo(String logo)
   {
      this.logo = logo;
   }

   public String getCountryId()
   {
      return countryId;
   }

   public void setCountryId(String countryId)
   {
      this.countryId = countryId;
   }

   public String getCountryName()
   {
      return countryName;
   }

   public void setCountryName(String countryName)
   {
      this.countryName = countryName;
   }

}
