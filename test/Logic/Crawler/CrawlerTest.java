package Logic.Crawler;

import Components.Position;
import DataStructures.DepthFirst;
import DataStructures.IDataStructure;
import Maze.ForkRoad;
import Maze.IMaze;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrawlerTest {

    private Crawler crawler;
    private IDataStructure dataStructure;

    @Before
    public void setUp() {
        IMaze maze = new ForkRoad();
        this.dataStructure = new DepthFirst();
        this.crawler = new Crawler(maze, dataStructure);
    }

    @Test
    public void updateNotNull() {
        crawler.update();
        crawler.update();
        crawler.update();

        Position actual = dataStructure.checkNext();
        assertNotNull(actual);
    }

    @Test
    public void updateNull() {
        Position actual = dataStructure.checkNext();
        assertNull(actual);
    }

}
