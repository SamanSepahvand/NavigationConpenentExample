package com.samansepahvand.test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.samansepahvand.test1.fragment.AddNoteFragmentDirections;
import com.samansepahvand.test1.fragment.ListNoteFragmentDirections;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottom_navigation_view);
        navController= Navigation.findNavController(this,R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

        Log.e("TAG", "onNavigationItemSelected 1:  "+ navController.getCurrentDestination()+"///" +    navController.getCurrentDestination().getId() );

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                       case R.id.blankFragment:

                        Model model=new Model("azion","Sessspahvand");
                        ListNoteFragmentDirections.ActionListNoteFragmentToBlankFragment action1=
                                ListNoteFragmentDirections.actionListNoteFragmentToBlankFragment(model);
                        action1.setData(90);
                        navController.navigate(action1);
                        break;
                    case R.id.listNoteFragment:
                        if (navController.getCurrentDestination().getNavigatorName().equals("AddNoteFragment")) {
                            Toast.makeText(MainActivity.this, "We are here DUde !", Toast.LENGTH_SHORT).show();

                        }else {
                            AddNoteFragmentDirections.ActionAddNoteFragmentToListNoteFragment action =
                                    AddNoteFragmentDirections.actionAddNoteFragmentToListNoteFragment("Hiiiii");
                            navController.navigate(action);
                            Log.e("TAG", "onNavigationItemSelected: " + navController.getCurrentDestination());
                        }
                        break;
                }
                return false;
            }
        });
    }
}