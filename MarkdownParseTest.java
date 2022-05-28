import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;



public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(35, 34 + 1);
    }
    
      @Test 
    public void snippet0Test() throws IOException {
        Path fileName1 = Path.of("snippet1.md");
        String contents1 = Files.readString(fileName1);
        ArrayList<String> links1 = MarkdownParse.getLinks(contents1);
        ArrayList<String> links2 = new ArrayList<String>();
        links2.add("`google.com");
        links2.add("google.com");
        links2.add("ucsd.edu");
        assertEquals(links2, links1);
    }

    @Test 
    public void snippet1Test() throws IOException {
        Path fileName2 = Path.of("snippet2.md");
        String contents2 = Files.readString(fileName2);
        ArrayList<String> links3 = MarkdownParse.getLinks(contents2);
        ArrayList<String> links4 = new ArrayList<String>();
        links4.add("a.com");
        links4.add("a.com(())");
        links4.add("example.com");
        assertEquals(links4, links3);
    }

    @Test 
    public void snippet2Test() throws IOException {
        Path fileName3 = Path.of("snippet3.md");
        String contents3 = Files.readString(fileName3);
        ArrayList<String> links5 = MarkdownParse.getLinks(contents3);
        ArrayList<String> links6 = new ArrayList<String>();
        links6.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        assertEquals(links6, links5);
    }

}
