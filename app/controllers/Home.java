package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Home extends Controller
{
  public static void index()
  {
	  String userId = session.get("logged_in_userid");
	     if (userId != null) {
	    	User user = User.findById(Long.parseLong(userId));
	    	render(user);	
	     } else {
		   	Accounts.index();
	     }
  }

  public static void drop(Long id)
  {
    User user   = Accounts.getLoggedInUser();    
    User friend = User.findById(id);
    user.unfriend(friend);
    Logger.info("Dropping " + friend.email);
    index();
  }  
}