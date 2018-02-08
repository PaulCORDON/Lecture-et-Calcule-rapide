package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.projet4a.ensim.lecture_et_calcule_rapide.R;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by HP on 08/02/2018.
 */

public class GifImageView extends android.support.v7.widget.AppCompatImageView{

    Movie movie;
    InputStream inputStream;
    private long mMovieStart;

    public GifImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public GifImageView(Context context) {
        super(context);
    }

    public GifImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        inputStream = context.getResources()
                .openRawResource(R.drawable.GifImg);
        byte[] array = streamToBytes(inputStream);
        movie = Movie.decodeByteArray(array, 0, array.length);

    }

    private byte[] streamToBytes(InputStream is) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(
                1024);
        byte[] buffer = new byte[1024];

        int len;
        try {
            while ((len = is.read(buffer)) >= 0) {
                byteArrayOutputStream.write(buffer, 0, len);
                return byteArrayOutputStream.toByteArray();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        long now = SystemClock.uptimeMillis();
        if (mMovieStart == 0) { // first time
            mMovieStart = now;
        }
        if (movie != null) {
            int dur = movie.duration();
            if (dur == 0) {
                dur = 3000;
            }
            int relTime = (int) ((now - mMovieStart) % dur);
            movie.setTime(relTime);
            movie.draw(canvas, getWidth() - 200, getHeight() - 200);
            invalidate();
        }
    }

}


