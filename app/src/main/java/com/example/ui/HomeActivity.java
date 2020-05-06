package com.example.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.marvelapp.R;
import com.example.ui.home.characters.CharactersFragment;
import com.example.ui.home.favorites.FavoritesFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Obtain the FirebaseAnalytics instance.

        setUp();
    }

    private void setUp() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.container);
                switch (item.getItemId()) {
                    case R.id.characters:
                        if (!(currentFragment instanceof CharactersFragment)) {
                            fragment = CharactersFragment.newInstance();
                        }else {
                            fragment = currentFragment;
                        }
                        break;
                    case R.id.detay:
                        if (!(currentFragment instanceof FavoritesFragment)) {
                            fragment = FavoritesFragment.newInstance();
                        }else {
                            fragment = currentFragment;
                        }
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, "Character").commit();
                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.characters);
    }
}
