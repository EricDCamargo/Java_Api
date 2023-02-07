package br.com.project.api.model;

import org.springframework.stereotype.Component;

@Component
public class Messege {

  private String messege;

  public String getMessege() {
    return messege;
  }

  public void setMessege(String messege) {
    this.messege = messege;
  }
}
