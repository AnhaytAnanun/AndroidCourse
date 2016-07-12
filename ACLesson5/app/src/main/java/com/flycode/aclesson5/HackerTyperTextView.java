package com.flycode.aclesson5;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by anhaytananun on 11.07.16.
 */
public class HackerTyperTextView extends TextView {
    private String hackerText = "#include <iostream> \n using namespace std; \n int main () { \n cout << \" Hello  World \" << endl; \n }";

    public HackerTyperTextView(Context context) {
        super(context);
    }

    public HackerTyperTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HackerTyperTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setHackerText (int val){
        setText(hackerText.substring(0, val));
    }

    public int getLength () {
        return hackerText.length();
    }
}
