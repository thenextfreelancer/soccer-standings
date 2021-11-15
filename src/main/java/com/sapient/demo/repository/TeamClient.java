package com.sapient.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.sapient.demo.rest.api.entities.Team;

@Repository
public class TeamClient implements ApiFootballClient<Team[]>
{
   private String url;
   private static final String ACTION = "get_teams";
   private HttpEntity<String> requestEntity;
   private RestTemplate rest;

   @Autowired
   public TeamClient(@Value("${client.api.url}") String url, @Value("${client.api.key}") String restClientKey)
   {
      this.url = url + "?action=" + ACTION + "&APIkey=" + restClientKey;
      rest = new RestTemplate();
      HttpHeaders headers = new HttpHeaders();
      headers.add("Accept", "*/*");
      requestEntity = new HttpEntity<String>("", headers);
   }

   @Override
   public ResponseEntity<Team[]> get(String paramUrl)
   {
      return rest.exchange(this.url + paramUrl, HttpMethod.GET, requestEntity, Team[].class);
   }

   public ResponseEntity<Team[]> getById(int id)
   {
      String countryIdUrl = "&team_id=" + id;
      return get(countryIdUrl);
   }

   public ResponseEntity<Team[]> getByLeagueId(int leagueId)
   {
      String leagueIdUrl = "&league_id=" + leagueId;
      return get(leagueIdUrl);
   }

}
