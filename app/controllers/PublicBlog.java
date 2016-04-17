package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class PublicBlog extends Controller
{
  public static void visit(Long id)
  {
    User currentUser = Accounts.getLoggedInUser();
    
    User user = User.findById(id);
    Logger.info("Just visiting the page for " + user.firstName + ' ' + user.lastName);
    render(currentUser,user);
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