package com.sapient.demo.repository;

public interface RestClientInterface<T>
{
   public String buildUrl();
   public T get();
}
