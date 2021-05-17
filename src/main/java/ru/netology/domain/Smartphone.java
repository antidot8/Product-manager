package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Smartphone extends Product {
  private String manufacturer;

  public boolean matches(String search) {
    if (super.matches(search)) {
      return true;
    }
    return getManufacturer().equalsIgnoreCase(search);
  }

  public Smartphone(int id, String name, int price, String manufacturer) {
    super(id, name, price);
    this.manufacturer = manufacturer;
  }
}