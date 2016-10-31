package kr.co.ned3y2k.imagelistview;

import org.junit.Test;

import kr.co.ned3y2k.imagelistview.util.ImageUtil;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testApiConnect() {
        assertEquals("http://14.49.231.5/search.jpg", ImageUtil.getImageList().imgList[0]);
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
}