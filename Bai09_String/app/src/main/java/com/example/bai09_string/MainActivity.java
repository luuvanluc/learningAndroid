package com.example.bai09_string;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.activity_main_tv_empty);
        //Set text with plain string
        textView.setText(R.string.empty_note_html);
        //getString method just get pure string (not full HTML string)
        textView.setText(getString(R.string.empty_note_html));
        //Set text with CDATA style
        textView.setText(Html.fromHtml(getString(R.string.empty_note_cdata)));


        //Set text with Spannable strings
        CharSequence exampleForSpannable = getText(R.string.empty_note_spannable);
        SpannableString spannableString = new SpannableString(exampleForSpannable);

        spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, 30, 0);

        spannableString.setSpan(new RelativeSizeSpan(2), 86, 87, 0);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(MainActivity.this, "Will be implemented later...", Toast.LENGTH_SHORT).show();
            }
        };
        spannableString.setSpan(clickableSpan, 130, 152, 0);
        spannableString.setSpan(new ForegroundColorSpan(Color.BLUE), 130, 152, 0);

        spannableString.setSpan(new URLSpan("https://yellowcodebooks.com/"), 181, exampleForSpannable.length(), 0);
        spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), 181, exampleForSpannable.length(), 0);
        spannableString.setSpan(new RelativeSizeSpan(1.5f), 181, exampleForSpannable.length(), 0);

        textView.setMovementMethod(LinkMovementMethod.getInstance());

        textView.setText(spannableString);

    }
}