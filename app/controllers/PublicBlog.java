package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class PublicBlog extends Controller
{
	int index = 0;
	
  public static void visit(Long id)
  {
		  User user = User.findById(id);
		    Logger.info("Just visiting the page for " + user.firstName + ' ' + user.lastName);
		    render(user);
	  

  }

  public static void sendComment(Long id, String commentText, Long postid)
  {
    User fromUser = Accounts.getLoggedInUser();
    if(fromUser != null) {
    	User toUser = User.findById(id);
        
        Logger.info("Comment from user " + 
            fromUser.firstName + ' ' + fromUser.lastName +" to " +
            toUser.firstName + ' ' + toUser.lastName +": " +
            commentText);    
        
        fromUser.sendComment(toUser, commentText, postid);
        Blog.index();	
    } else {
    	Blog.index();
    }
    
  }  
  public static void sendComment2(Long id, String commentText, Long postid)
  {
	  User fromUser = Accounts.getLoggedInUser();
	    if(fromUser != null) {
	    	User toUser = User.findById(id);
	        
	        Logger.info("Comment from user " + 
	            fromUser.firstName + ' ' + fromUser.lastName +" to " +
	            toUser.firstName + ' ' + toUser.lastName +": " +
	            commentText);    
	        
	        fromUser.sendComment(toUser, commentText, postid);
	        PublicBlog.visit(id);	
	    } else {
	    	PublicBlog.visit(id);
	    }
    
  }  
 
}