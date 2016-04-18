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
    }
  }
}