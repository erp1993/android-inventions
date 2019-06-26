package com.example.android_inventions;

import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.LinearLayout;
import android.widget.TextView;

public class BloggingActivity extends AppCompatActivity {

    LinearLayout verticalMain;
    TextView textName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogging);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        verticalMain = findViewById(R.id.verticalMain);
        textName = findViewById(R.id.nombreText);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseFirestore myDb = FirebaseFirestore.getInstance();

        CollectionReference usuarios = myDb.collection("usuarios");

        usuarios.document("nh4cvg498HeSpmWsfvAVzUMu8im1").get()

                .addOnCompleteListener(new OnCompleteListener< DocumentSnapshot >() {

                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                        if (task.isSuccessful()) {
                            DocumentSnapshot doc = task.getResult();
                            textName.setText(doc.get("Nombre").toString());
                        }

                    }
                })


                .addOnFailureListener(new OnFailureListener() {

                    @Override

                    public void onFailure(@NonNull Exception e) {

                    }

                });


        for (int i = 0; i < 20; i++) {
            TextView text = new TextView(this);
            text.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
            LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lParams.setMargins(50,15,50,15);
            text.setLayoutParams(lParams);
            verticalMain.addView(text);
        }
    }
}
