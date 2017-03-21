package com.coco.coordinatorlayoutdemo;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * CoordinatorLayout是Design引入的一个功能强大的布局，本质上是一个增强的FrameLayout,
 * 它可以使得不同组件之间直接相互作用，并协调动画效果。我们可以定义CoordinatorLayout
 * 内部的视图组件如何相互作用并发生变化。例如刚才的FloatingActionButton 和 SnackBar，
 * 为了实现SnackBar出现时FAB能够上移，我们可以使用CoordinatorLayout为父容器。
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CoordinatorLayout coordinator = (CoordinatorLayout) findViewById(R.id.coordinator);
        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.floatingaction);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinator, "click the floatactionbar", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "undo", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }
}
