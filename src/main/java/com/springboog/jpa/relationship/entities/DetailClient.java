package com.springboog.jpa.relationship.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detail_client")
public class DetailClient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private boolean premium;
  private Integer points;

  @OneToOne
  private Client client;

  public DetailClient() {}

  public DetailClient(boolean premium, Integer points) {
    this.premium = premium;
    this.points = points;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public boolean isPremium() {
    return premium;
  }

  public void setPremium(boolean premium) {
    this.premium = premium;
  }

  public Integer getPoints() {
    return points;
  }

  public void setPoints(Integer points) {
    this.points = points;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  @Override
  public String toString() {
    return "{id=" + id + ", premium=" + premium + ", points=" + points + "}";
  }
}
