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
  public void doJob() //throws FileNotFoundException 
  {
    if (User.count() == 0)
    {
      Fixtures.loadModels("data.yml"); 
      
      
      /*String photoName = "20070875-webapp/public/images/marge.gif";
      Blob blob = new Blob ();
      blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
      User homer = User.findByEmail("marge@simpson.com");
      homer.profilePicture = blob;
      homer.save();*/
    }
  }
}