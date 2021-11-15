package com.sapient.demo.rest.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country
{
   @JsonProperty("country_id") 
   private String id;
   
   @JsonProperty("country_name") 
   private String name;
   
   @JsonProperty("country_logo") 
   private String logo;

   public Country()
   {}

   public Country(String id, String name, String logo)
   {
      this.id = id;
      this.name = name;
      this.logo = logo;
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

}
