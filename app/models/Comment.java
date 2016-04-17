package models;

import javax.persistence.*;
import play.db.jpa.*;

@Entity
public class Comment extends Model
{
  public String commentText;

  @ManyToOne
  public User from;

  public Comment(User from, String commentText)
  {
    this.from = from;
    this.commentText = commentText;
  }
  
  public String toString() {
	  return commentText +" from "+ from;
  }
}