import java.util.Date;
import java.util.List;
import models.Comment;
import models.Message;
import models.Post;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import play.test.Fixtures;
import play.test.UnitTest;

public class CommentTest extends UnitTest
{
  private User mary, joan;
  private Post post1, post2;

  @BeforeClass
  public static void loadDB()
  {
    Fixtures.deleteAllModels();
  }

  @Before
  public void setup()
  {
    mary = new User("mary", "collins", "mary@collins.com", "secret", 20, "irish");
    post1 = new Post(mary,"Post Title 1", "This is the first post content");
    mary.save();

    joan = new User("joan", "collins", "joan@collins.com", "secret", 20, "irish");
    post2 = new Post(joan,"Post Title 2", "This is the second post content");
    joan.save();
    
    post1.save();
    post2.save();
    
  }

  @After
  public void teardown()
  {
	post1.delete();
	post2.delete();
    mary.delete();
    joan.delete();
  }

  @Test
  public void testCreateComment()
  {
	Date date = new Date();
	String date2 = date.toString();
    Comment comment = new Comment(joan,"Hi Mary",post1.id,date2);
    comment.save();
    
    post1.comments.add(comment);

    assertEquals(post1.comments.size(), 1);
    assertEquals(comment.from, joan);
    assertEquals(comment.commentText, "Hi Mary");
    assertEquals(post1.comments.get(0).commentText, "Hi Mary");

    comment.delete();
    post1.comments.remove(comment);
    post1.save();
    assertEquals(post1.comments.size(), 0);
    mary.save();
  }
  
  @Test
  public void testNoComments()
  {
    assertEquals(post1.comments.size(), 0);
  }
  
  @Test
  public void testMultipleComments()
  {
	Date date = new Date();
    String date2 = date.toString();
    Comment cm1 = new Comment(mary,"Hi there - how are you",post2.id,date2);
    cm1.save();
    Comment cm2 = new Comment(mary,"Where are you now?",post2.id,date2);
    cm2.save();
    
    post2.comments.add(cm1);
    post2.comments.add(cm2);
    
    assertEquals(post2.comments.size(),2);
    
    Comment comment1 = post2.comments.get(0);
    assertEquals(comment1.commentText, "Hi there - how are you");
    Comment comment2 = post2.comments.get(1);
    assertEquals(comment2.commentText, "Where are you now?");

    comment1.delete();
    post2.comments.remove(comment1);
    post2.save();
    comment2.delete();
    post2.comments.remove(comment2);
    post2.save();
    assertEquals(post1.comments.size(), 0);
    joan.save();

  }

  
}