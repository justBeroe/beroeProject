package bg.softuni.beroe.model.entity;

import bg.softuni.beroe.model.enums.FanSizeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "fans")
public class FanEntity extends BaseEntity {

  @NotEmpty
  private String description;


  private String item;

  @Positive
  private int price;

  private String imageUrl;

  @Enumerated(EnumType.STRING)
  private FanSizeEnum fanSize;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

  public UserEntity getUser() {
    return user;
  }

  public FanEntity setUser(UserEntity user) {
    this.user = user;
    return this;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public FanEntity setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }



  public String getItem() {
    return item;
  }

  public FanEntity setItem(String item) {
    this.item = item;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public FanEntity setDescription(String description) {
    this.description = description;
    return this;
  }

  public FanSizeEnum getFanSize() {
    return fanSize;
  }

  public FanEntity setFanSize(FanSizeEnum fanSize) {
    this.fanSize = fanSize;
    return this;
  }

  public int getPrice() {
    return price;
  }

  public FanEntity setPrice(int price) {
    this.price = price;
    return this;
  }
}
