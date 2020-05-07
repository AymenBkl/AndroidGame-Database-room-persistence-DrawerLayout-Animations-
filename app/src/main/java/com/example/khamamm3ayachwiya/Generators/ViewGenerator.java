package com.example.khamamm3ayachwiya.Generators;

import android.content.Context;
import android.text.InputFilter;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.khamamm3ayachwiya.Animations.AnimationController;
import com.example.khamamm3ayachwiya.R;

public class ViewGenerator {
    private Context context;
    private AnimationController animationController;
    private LinearLayout linearLayout;
    private TextView textView;

    public ViewGenerator(Context context,View view){
        this.context = context;
        this.animationController = new AnimationController(this.context);
        this.linearLayout = (LinearLayout) view.findViewById(R.id.linearLayoutContainer);
        this.textView = (TextView) view.findViewById(R.id.valueScore);
    }

    public EditText createEditText(int id){
        EditText editText = new EditText(new ContextThemeWrapper(this.context, R.style.editTextStyle));
        editText.setId(id);
        editText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(1)});
        this.animationController.setAnimatioTop(editText);
        this.linearLayout.addView(editText);
        return editText;
    }
    public TextView createTextView(int id, String Text){
        TextView textView = new TextView(new ContextThemeWrapper(this.context,R.style.textViewStyle));
        textView.setText(Text);
        this.animationController.setAnimationBottom(textView);
        this.linearLayout.addView(textView);
        return textView;
    }
    public void editScore(Long score){
        this.animationController.setAnimationBottom(this.textView);
        this.textView.setText(String.valueOf(score));
    }
    public void resetLinearLayout(){
        this.linearLayout.removeAllViews();
    }

}
