package se.iths.jelleryd.webshop.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CustomerOrder {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long orderNumber;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<OrderProduct> products;

  @ManyToOne // Bi-directional relationship
  private Customer customer;

  private boolean dispatched;

  public CustomerOrder() {
    // Required by JPA
  }

  public CustomerOrder(List<OrderProduct> products, Customer customer) {
    this.products = products;
    this.customer = customer;
  }

  public List<OrderProduct> getProducts() {
    return products;
  }

  public void setProducts(List<OrderProduct> products) {
    this.products = products;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Long getOrderNumber() {
    return orderNumber;
  }

  public boolean isDispatched() {
    return dispatched;
  }

  public void setDispatched(boolean dispatched) {
    this.dispatched = dispatched;
  }

}
