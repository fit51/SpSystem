package subclasses;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * Created with IntelliJ IDEA.
 * User: Павел
 * Date: 11.01.14
 * Time: 2:32
 * To change this template use File | Settings | File Templates.
 */
public class MyFrameLayout extends FrameLayout {
    private static final String TAG = MyFrameLayout.class.getName();

    public MyFrameLayout(Context context) {
        super(context);
    }
    public MyFrameLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs, 0);
    }

    public MyFrameLayout(Context context, AttributeSet attrs, int defaultStyle)
    {
        super(context, attrs, defaultStyle);
    }

    public float getXFraction() {
        final WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Point size = new Point();
        wm.getDefaultDisplay().getSize(size);
        int width = size.x;
        return (width == 0) ? 0 : getX() / (float) width;
    }

    public void setXFraction(float xFraction) {
        final WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Point size = new Point();
        wm.getDefaultDisplay().getSize(size);
        int width = size.x;;
        setX((width > 0) ? (xFraction * width) : 0);
    }
}
