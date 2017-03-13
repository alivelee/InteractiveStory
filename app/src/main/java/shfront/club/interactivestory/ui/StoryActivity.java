package shfront.club.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import shfront.club.interactivestory.R;
import shfront.club.interactivestory.model.Page;
import shfront.club.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {
    public static final String TAG = StoryActivity.class.getSimpleName();
    private Story xStory = new Story();
    private ImageView xImageView;
    private TextView xTextView;
    private Button xfirstButton;
    private Button xsecondButton;
    private String xname;
    private Page xCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Intent intent = getIntent();
        xname = intent.getStringExtra(getString(R.string.key_Name));
        if (xname == null) {
            xname = "Friend";
        }
        Log.d(TAG,xname);
        xImageView = (ImageView) findViewById(R.id.storyImageView);
        xTextView = (TextView) findViewById(R.id.storyTextView);
        xfirstButton = (Button) findViewById(R.id.firstChoiceButton);
        xsecondButton = (Button) findViewById(R.id.secondChoiceButton);

        loadPage(0);
    }
    private void loadPage(int choice){
        xCurrentPage = xStory.getPage(choice);
        Drawable drawable = getResources().getDrawable(xCurrentPage.getImageId());
        xImageView.setImageDrawable(drawable);
        String pageText = xCurrentPage.getText();
        pageText = String.format(pageText,xname);
//        Log.d(TAG,xname);
        xTextView.setText(pageText);
        if (xCurrentPage.isFinal()){
            xfirstButton.setVisibility(View.INVISIBLE);
            xsecondButton.setText("Play Again");
            xsecondButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        } else {
            xfirstButton.setText(xCurrentPage.getFirstChoice().getText());
            xsecondButton.setText(xCurrentPage.getSecondChoice().getText());
            xfirstButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int nextPage = xCurrentPage.getFirstChoice().getNextPage();
                    loadPage(nextPage);
                }
            });
            xsecondButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int nextPage = xCurrentPage.getSecondChoice().getNextPage();
                    loadPage(nextPage);
                }
            });
        }
    }
}
