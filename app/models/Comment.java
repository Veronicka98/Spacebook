package models;

import javax.persistence.*;
import play.db.jpa.*;

@Entity
public class Comment extends Model
{
  public String commentText;
  public Long postid;

  @ManyToOne
  public User from;

  public Comment(User from, String commentText, Long postid)
  {
    this.from = from;
    this.commentText = commentText;
    this.postid = postid;
  }
  
  public String toString() {
	  return commentText +" from "+ from;
  }
}