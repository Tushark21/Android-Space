package imagedrag.imagedrag;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    float prevX, prevY;
    ImageView image1;

    View.OnTouchListener touchListener=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch(event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    prevX=event.getRawX();
                    prevY=event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float x=event.getRawX()-prevX;
                    float y=event.getRawY()-prevY;

                    image1.setX(image1.getX()+x);
                    image1.setY(image1.getY()+y);
                    Log.d("Position:","("+image1.getX()+","+image1.getY()+")");

                    prevX=event.getRawX();
                    prevY=event.getRawY();
                    break;

                    default:
                        break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = findViewById(R.id.bulbasaurImage);
        image1.setOnTouchListener(touchListener);
    }

}