package shfront.club.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import shfront.club.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private EditText xNameField;
    private Button xstartButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xNameField = (EditText) findViewById(R.id.name);
        xstartButton = (Button) findViewById(R.id.startButton);
        xstartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = xNameField.getText().toString();
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                startStory(name);
            }
        });

    }

    private void startStory(String name){
        Intent intent = new Intent(this,StoryActivity.class);
        intent.putExtra(getString(R.string.key_Name),name);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        xNameField.setText("");
    }
}
