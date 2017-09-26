package com.tedu.bean;

import java.sql.Date;

/**
 * 属性
 */
public class DBook {
  private int id;
  private String productName;
  private String description;
  private Double fixedPrice;
  private Double dangPrice;
  private String productPic;
  private String author;
  private String publishing;
  private Date publishTime;
  private String authorSummary;
  private String catalogue;

    public DBook(int id, String productName, String description, Double fixedPrice, Double dangPrice, String productPic,
                 String author, String publishing, Date publishTime, String authorSummary, String catalogue) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.fixedPrice = fixedPrice;
        this.dangPrice = dangPrice;
        this.productPic = productPic;
        this.author = author;
        this.publishing = publishing;
        this.publishTime = publishTime;
        this.authorSummary = authorSummary;
        this.catalogue = catalogue;
    }

    public DBook() {
    }

    public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getFixedPrice() {
    return fixedPrice;
  }

  public void setFixedPrice(Double fixedPrice) {
    this.fixedPrice = fixedPrice;
  }

  public Double getDangPrice() {
    return dangPrice;
  }

  public void setDangPrice(Double dangPrice) {
    this.dangPrice = dangPrice;
  }

  public String getProductPic() {
    return productPic;
  }

  public void setProductPic(String productPic) {
    this.productPic = productPic;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPublishing() {
    return publishing;
  }

  public void setPublishing(String publishing) {
    this.publishing = publishing;
  }

  public Date getPublishTime() {
    return publishTime;
  }

  public void setPublishTime(Date publishTime) {
    this.publishTime = publishTime;
  }

  public String getAuthorSummary() {
    return authorSummary;
  }

  public void setAuthorSummary(String authorSummary) {
    this.authorSummary = authorSummary;
  }

  public String getCatalogue() {
    return catalogue;
  }

  public void setCatalogue(String catalogue) {
    this.catalogue = catalogue;
  }
}
