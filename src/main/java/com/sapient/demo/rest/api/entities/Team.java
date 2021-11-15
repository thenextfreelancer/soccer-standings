package com.sapient.demo.rest.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team
{
   @JsonProperty("team_key")
   private String id;

   @JsonProperty("team_name")
   private String name;

   @JsonProperty("team_badge")
   private String logo;

   public Team()
   {}

   public Team(String id, String name, String logo)
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