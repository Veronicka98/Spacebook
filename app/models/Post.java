package models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import controllers.Accounts;
import play.Logger;
import play.db.jpa.Model;

@Entity
public class Post extends Model
{
  public String title;
  @Lob()
  public String content;
  
  @ManyToOne()
  public User author;
  
  @OneToMany(mappedBy = "postid")
  public List<Comment> comments = new ArrayList<Comment>();

  public Post(User author, String title, String content)
  {
	this.author = author;
    this.title = title;
    this.content = content;
  }
  
}