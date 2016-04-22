import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import play.*;
import play.jobs.*;
import play.libs.MimeTypes;
import play.test.*;
 
import models.*;

import play.db.jpa.Blob;
 
@OnApplicationStart
public class Bootstrap extends Job 
{ 
  public void doJob() throws FileNotFoundException 
  {
    if (User.count() == 0)
    {
      Fixtures.deleteDatabase();
      Fixtures.loadModels("data.yml"); 
      
      String photoName = "marge.gif";
      Blob blob = new Blob();
      blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
      User marge = User.findByEmail("marge@simpson.com");
      marge.profilePicture = blob;
      marge.save();
      
      String photoName2 = "homer.gif";
      Blob blob2 = new Blob();
      blob2.set(new FileInputStream(photoName2), MimeTypes.getContentType(photoName2));
      User homer = User.findByEmail("homer@simpson.com");
      homer.profilePicture = blob2;
      homer.save();
      
      String photoName3 = "bart.gif";
      Blob blob3 = new Blob();
      blob3.set(new FileInputStream(photoName3), MimeTypes.getContentType(photoName3));
      User bart = User.findByEmail("bart@simpson.com");
      bart.profilePicture = blob3;
      bart.save();
      
      String photoName4 = "lisa.gif";
      Blob blob4 = new Blob();
      blob4.set(new FileInputStream(photoName4), MimeTypes.getContentType(photoName4));
      User lisa = User.findByEmail("lisa@simpson.com");
      lisa.profilePicture = blob4;
      lisa.save();
      
      String photoName5 = "maggie.gif";
      Blob blob5 = new Blob();
      blob5.set(new FileInputStream(photoName5), MimeTypes.getContentType(photoName5));
      User maggie = User.findByEmail("maggie@simpson.com");
      maggie.profilePicture = blob5;
      maggie.save();
      
      String photoName6 = "ned.gif";
      Blob blob6 = new Blob();
      blob6.set(new FileInputStream(photoName6), MimeTypes.getContentType(photoName6));
      User ned = User.findByEmail("ned@flanders.com");
      ned.profilePicture = blob6;
      ned.save();
      
      String photoName7 = "milhouse.gif";
      Blob blob7 = new Blob();
      blob7.set(new FileInputStream(photoName7), MimeTypes.getContentType(photoName7));
      User milhouse = User.findByEmail("milhouse@vanhouten.com");
      milhouse.profilePicture = blob7;
      milhouse.save();
      
      String photoName8 = "moe.gif";
      Blob blob8 = new Blob();
      blob8.set(new FileInputStream(photoName8), MimeTypes.getContentType(photoName8));
      User moe = User.findByEmail("moe@slyslak.com");
      moe.profilePicture = blob8;
      moe.save();
    }
  }
}