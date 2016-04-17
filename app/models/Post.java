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
  @Lob
  public String content;
  
  public ArrayList<Comment> comments;

  public Post(String title, String content)
  {
    this.title = title;
    this.content = content;
    comments = new ArrayList<Comment>();
  }

  public Post() {
	  
  }
  
  public void addComment(Comment comment) {
	  Logger.info("Coment:"+comment.commentText+" from: "+comment.from);    
  	comments.add(comment);
  }
  
  public ArrayList<Comment> getComments() {
	  	return comments;
	  }
  public String toString() {
	  String str = "";
	  int index = 0;
	  for(Comment comment: comments) {
		  str = str + " ("+index +" comment) "+ comment.commentText + "   "; 
	  }
	  str = str + "\n";
	  return str;
  }
  
  
 

  
}