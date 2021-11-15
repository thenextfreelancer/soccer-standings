package com.sapient.demo.repository;

import org.springframework.http.ResponseEntity;

public interface ApiFootballClient<T>
{
   ResponseEntity<T> get(String paramUrl);
}
