package com.sapient.demo.service.pojo;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response<T> extends RepresentationModel<Response<T>>
{
   private List<T> list;
   private boolean success;
   private HttpStatus status;

   public Response()
   {}

   public Response(@JsonProperty("list") List<T> list, @JsonProperty("success") boolean success, @JsonProperty("status") HttpStatus status)
   {
      this.list = list;
      this.success = success;
      this.status = status;
   }

   public List<T> getList()
   {
      return list;
   }

   public void setList(List<T> list)
   {
      this.list = list;
   }

   public boolean isSuccess()
   {
      return success;
   }

   public void setSuccess(boolean success)
   {
      this.success = success;
   }

   public HttpStatus getStatus()
   {
      return status;
   }

   public void setStatus(HttpStatus status)
   {
      this.status = status;
   }

}
