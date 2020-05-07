package com.example.khamamm3ayachwiya.Animations;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.khamamm3ayachwiya.R;

public class AnimationController {
    private Animation topAnim,botAnim,leftoright,rightoleft,winleft,winright;
    private Context context;
    public AnimationController(Context context){
        this.context = context;
    }
    private void loadAnimationBottom(){
        this.botAnim = AnimationUtils.loadAnimation(this.context,R.anim.buttom_animation);
    }
    private void loadAnimationTop(){
        this.topAnim = AnimationUtils.loadAnimation(this.context,R.anim.top_animation);
    }
    private void loadLeftToRightAnimation(){
        this.leftoright = AnimationUtils.loadAnimation(this.context,R.anim.left_to_right);
    }
    private void loadRightToLeftAnimation(){
        this.rightoleft = AnimationUtils.loadAnimation(this.context,R.anim.righ_to_left);
    }
    private void loadWinLeft(){
        this.winleft = AnimationUtils.loadAnimation(this.context,R.anim.winleft);
    }
    private void loadWinRight(){
        this.winright = AnimationUtils.loadAnimation(this.context,R.anim.winright);
    }

    public void setAnimationBottom(View view){
        loadAnimationBottom();
        view.setAnimation(this.botAnim);
    }
    public void setAnimatioTop(View view){
        loadAnimationTop();
        view.setAnimation(this.topAnim);
    }
    public void setLeftToRightAnim(View view){
        loadLeftToRightAnimation();
        view.setAnimation(this.leftoright);
    }
    public void setRighToLeftAnim(View view){
        loadRightToLeftAnimation();
        view.setAnimation(this.rightoleft);
    }
    public void setWinLeft(View view){
        loadWinLeft();
        view.setAnimation(this.winleft);
    }
    public void setWinRight(View view){
        loadWinRight();
        view.setAnimation(this.winright);
    }

}
