package by.iba.xmlreport.db.entities.promoting;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "promote_info")
public class PromoteInfo implements Serializable{
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;
  @Column 
  private String appname;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAppname() {
    return appname;
  }

  public void setAppname(String appname) {
    this.appname = appname;
  }
}
