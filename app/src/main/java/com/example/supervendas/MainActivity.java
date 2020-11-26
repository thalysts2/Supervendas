package com.example.supervendas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    private String uid;
    private String usuario;

    private ArrayList<String>seguindo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        seguindo = new ArrayList<>();
    }
    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user==null)finish();

//        para obter informações dos usuarios
        getUserinfo();
    }
//    userRef apontando para os dados do banco de user e buscando uid
    private void getUserinfo(){
         uid = mAuth.getCurrentUser().getUid();

        DatabaseReference userRef = database.getReference("users/" + uid);
        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                usuario = datasnapshot.child("usuario").getValue(String.class);

                seguindo.clear();
                for (DataSnapshot s : datasnapshot.child("seguindo").getChildren()) {
                    seguindo.add(s.getValue(String.class));
                }
                Log.d("usuario",usuario);
                Log.d("lista",seguindo.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    }
