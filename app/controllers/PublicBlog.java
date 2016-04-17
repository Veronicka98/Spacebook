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
    User fromUser = Accounts.getLoggedInUser();;
    User toUser = User.findById(id);
    
    Logger.info("Comment from user " + 
        fromUser.firstName + ' ' + fromUser.lastName +" to " +
        toUser.firstName + ' ' + toUser.lastName +": " +
        commentText);    
    
    fromUser.sendComment(toUser, commentText, postid);
    Blog.index();
  }  
 
}