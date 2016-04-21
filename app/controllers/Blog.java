package controllers;

import java.util.List;

import models.Comment;
import models.Message;
import models.Post;
import models.User;
import play.Logger;
import play.mvc.Controller;

public class Blog  extends Controller
{
  public static void index()
  {
    User user = Accounts.getLoggedInUser();
    Logger.info(user.posts.toString());
    render(user);
    
  }
  
  public static void posts(Long postid)
  {
	Post post = Post.findById(postid);
    User user = Accounts.getLoggedInUser();
    render(post,user);
  }
  
  public static void newPost(String title, String content)
  {
    User user = Accounts.getLoggedInUser();
    
    Post post = new Post (user,title, content);
    post.save();
    user.posts.add(post);
    user.save();
    
    Logger.info ("title:" + title + " content:" + content);
    index();
  }
  
  public static void deletePost(Long postid) {
	  
	    User user = Accounts.getLoggedInUser();
	    Post post = Post.findById(postid);
	    if(post.comments.size() > 0) {
	    for(int i = post.comments.size() - 1 ; i >= 0 ;i--) {
	    	Comment comment = post.comments.get(i);
	    	post.comments.remove(comment);
	  	    comment.delete();
	  	    user.save();
	    }
	    }
	    if(post.comments.size() == 0) {
		    user.posts.remove(post);
			post.delete();	
		    user.save();		    
	    }
	    index();
		
  }
}