package com.example.backend;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

  private @Id @GeneratedValue Long id;
  private String firstName;
  private String lastName;
  private String description;

  public Employee() {
  }

  public Employee(String firstName, String lastName, String description) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.description = description;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, description);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;

    Employee other = (Employee) obj;
    return Objects.equals(id, other.id) &&
        Objects.equals(firstName, other.firstName) &&
        Objects.equals(lastName, other.lastName) &&
        Objects.equals(description, other.description);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", description='" + description + '\'' +
        '}';
  }

}
