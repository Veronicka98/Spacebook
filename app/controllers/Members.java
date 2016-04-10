package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Members extends Controller
{
  public static void index()
  {
	  List<User> users = User.findAll();
	    String userId = session.get("logged_in_userid");
	    if (userId != null) {
	    	User user = User.findById(Long.parseLong(userId));
	    	users.remove(user);
	        render(user, users);
	    } else {
	    	Accounts.index();
	    }
  }
  
  public static void follow(Long id)
  {
    User user = Accounts.getLoggedInUser();
    User friend = User.findById(id);
    user.befriend(friend);
    Home.index();
  }
}