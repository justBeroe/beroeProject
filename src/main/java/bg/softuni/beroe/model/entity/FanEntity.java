package bg.softuni.beroe.model.entity;

import bg.softuni.beroe.model.enums.FanSizeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
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
