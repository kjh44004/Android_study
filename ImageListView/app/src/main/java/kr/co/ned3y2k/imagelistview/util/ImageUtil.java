package kr.co.ned3y2k.imagelistview.util;

import kr.co.ned3y2k.imagelistview.ImageList;
import kr.co.ned3y2k.imagelistview.api.ApiAsyncTask;
import kr.co.ned3y2k.imagelistview.api.ApiConnector;
import kr.co.ned3y2k.imagelistview.api.ApiTaskCallback;

/**
 * Created by User on 2016-10-27.
 */

public class ImageUtil {
    public static ImageList getImageList() {
        ApiConnector apiConnector = new ApiConnector();
        return apiConnector.get("http://14.49.231.5/imgList.php", ImageList.class);
    }

    public static void asyncGetImageList(ApiTaskCallback<ImageList> callback) {
        new ApiAsyncTask<ImageList>("http://14.49.231.5/imgList.php", ImageList.class, callback).execute();
    }
}
