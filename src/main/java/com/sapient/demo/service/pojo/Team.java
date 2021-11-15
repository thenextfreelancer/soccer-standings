package com.sapient.demo.service.pojo;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Team extends RepresentationModel<Team>
{
   private int id;

   private String name;

   private String logo;

   public Team()
   {}

   @JsonCreator
   public Team(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("logo") String logo)
   {
      this.id = id;
      this.name = name;
      this.logo = logo;
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

}