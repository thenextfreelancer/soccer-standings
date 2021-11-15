package com.sapient.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.sapient.demo.rest.api.entities.League;

@Repository
public class LeagueClient implements ApiFootballClient<League[]>
{
   private String url;
   private static final String ACTION = "get_leagues";
   private HttpEntity<String> requestEntity;
   private RestTemplate rest;

   @Autowired
   public LeagueClient(@Value("${client.api.url}") String url, @Value("${client.api.key}") String restClientKey)
   {
      this.url = url + "?action=" + ACTION + "&APIkey=" + restClientKey;
      rest = new RestTemplate();
      HttpHeaders headers = new HttpHeaders();
      headers.add("Accept", "*/*");
      requestEntity = new HttpEntity<String>("", headers);
   }

   @Override
   public ResponseEntity<League[]> get(String paramUrl)
   {
      return rest.exchange(url + paramUrl, HttpMethod.GET, requestEntity, League[].class);
   }

   public ResponseEntity<League[]> getByCountryId(int countryId)
   {
      String countryIdUrl = "&country_id=" + countryId;
      return get(countryIdUrl);
   }

   public ResponseEntity<League[]> get()
   {
      return get("");
   }
}
