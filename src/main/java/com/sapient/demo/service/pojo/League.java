package com.sapient.demo.service.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class League
{
   private int id;

   private String name;

   private String logo;

   private String countryId;

   private String countryName;

   public League()
   {}

   public League(
      @JsonProperty("id") int id,
      @JsonProperty("name") String name,
      @JsonProperty("logo") String logo,
      @JsonProperty("countryId") String countryId,
      @JsonProperty("countryName") String countryName)
   {
      this.id = id;
      this.name = name;
      this.logo = logo;
      this.countryId = countryId;
      this.countryName = countryName;
   }

   public int getId()
   {
      return id;
   }

   public void setId(int id)
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
