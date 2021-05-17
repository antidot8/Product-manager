package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Book extends Product {
  private String author;
  private int pages;
  private int publishedYear;

  public boolean matches(String search) {
    if (super.matches(search)) {
      return true;
    }
    return getAuthor().equalsIgnoreCase(search);
  }

  public Book(int id, String name, int price, String author, int pages, int publishedYear) {
    super(id, name, price);
    this.author = author;
    this.pages = pages;
    this.publishedYear = publishedYear;
  }
}