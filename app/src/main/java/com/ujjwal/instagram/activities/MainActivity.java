package com.ujjwal.instagram.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.widget.Toast;

import com.ujjwal.instagram.PostApi;
import com.ujjwal.instagram.StoryApi;
import com.ujjwal.instagram.Url;
import com.ujjwal.instagram.models.PostModel;
import com.ujjwal.instagram.R;
import com.ujjwal.instagram.models.StoryModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btmNav;
//    Fragment selectedFragment = null;

    public static List<PostModel> listPosts = new ArrayList<>();
    public static List<StoryModel> listStories = new ArrayList<>();

//    RecyclerView rvStories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btmNav = findViewById(R.id.nav_view);
//        rvStories = findViewById(R.id.rvStories);

        getSupportActionBar().hide();

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_add, R.id.navigation_liked, R.id.navigation_profile
        ).build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(btmNav, navController);

        loadStories();
//        loadPosts();

//        Sample Datas------------------------
        listPosts.add(new PostModel("1","Al Lucy", "Back ", R.drawable.post, R.drawable.profilepic));
        listPosts.add(new PostModel("2","Barry Allen", "I am done with this.", R.drawable.profilepic2, R.drawable.profilepic2));
        listPosts.add(new PostModel("3","Ujjwal Bhusal", "Battle between two childhood friends!", R.drawable.post, R.drawable.profilepic));
        listPosts.add(new PostModel("4","Tony Starc", "I am done with this.", R.drawable.profilepic2, R.drawable.profilepic2));


        listStories.add(new StoryModel("1","Ujjwal", R.drawable.ujj2, 0));
        listStories.add(new StoryModel("Iron Man", R.drawable.profilepic2));
//        listStories.add(new StoryModel("2","Add", R.drawable.add, 0));
//        listStories.add(new StoryModel("3","ujjwal Rajbhandari", R.drawable.home, 0));
//        listStories.add(new StoryModel("4","Add", R.drawable.add, 0));
//        listStories.add(new StoryModel("5","ujjwal Rajbhandari", R.drawable.home, 0));
//        listStories.add(new StoryModel("6","Add", R.drawable.add, 0));
//        listStories.add(new StoryModel("7","ujjwal Rajbhandari", R.drawable.home, 0));
//        listStories.add(new StoryModel("8","Add", R.drawable.add, 0));
//        listStories.add(new StoryModel("9","ujjwal Rajbhandari", R.drawable.home, 0));
//        listStories.add(new StoryModel("10","Add", R.drawable.add, 0));

//        setUpStories();
    }


    //For changing active icon on bottom navigation bar
//    private BottomNavigationView.OnNavigationItemReselectedListener
//                selectedItem = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//            Menu menu = btmNav.getMenu();
//            menu.findItem(R.id.navigation_home).setIcon(R.drawable.on_home);
//            menu.findItem(R.id.navigation_search).setIcon(R.drawable.on_search);
//            menu.findItem(R.id.navigation_add).setIcon(R.drawable.on_add);
//            menu.findItem(R.id.navigation_liked).setIcon(R.drawable.on_like);
//            menu.findItem(R.id.navigation_profile).setIcon(R.drawable.on_profile);
//
//            switch (menuItem.getItemId()) {
//                case R.id.navigation_home:
//                    selectedFragment = new PostFragment();
//                    menuItem.setIcon(R.drawable.on_home);
//                    break;
//                case R.id.navigation_search:
//                    selectedFragment = new SearchFragment();
//                    menuItem.setIcon(R.drawable.on_search);
//                    break;
//                case  R.id.navigation_add:
//                    menuItem.setIcon(R.drawable.on_add);
//                    break;
//                case R.id.navigation_liked:
//                    menuItem.setIcon(R.drawable.on_like);
//                    break;
//                case R.id.navigation_profile:
//                    menuItem.setIcon(R.drawable.on_profile);
//                    break;
//
//            }
//            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
//                    selectedFragment).commit();
//
//            if (selectedFragment != null){
//                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).commit();
//            }
//
//            return true;
//        }
//    };


//    public void setUpStories(){
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        rvStories = findViewById(R.id.rvStories);
//
//        StoryAdapter adapter = new StoryAdapter(listStories, MainActivity.this);
//        rvStories.setAdapter(adapter);
//
//        rvStories.setLayoutManager(layoutManager);
//    }


    public void loadStories(){

        StoryApi storyApi = Url.getInstance().create(StoryApi.class);
        Call<List<StoryModel>> storyCall = storyApi.getStories();

        storyCall.enqueue(new Callback<List<StoryModel>>() {
            @Override
            public void onResponse(Call<List<StoryModel>> call, Response<List<StoryModel>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Code: " +response.body(), Toast.LENGTH_SHORT).show();
                    return;
                }

//                String imgPath = Url.imagePath +  response.body();
//                Picasso.get().load(imgPath).into(imgProgileImg);

                List<StoryModel> list = response.body();
                for(StoryModel story: list){
                    listStories.add(new StoryModel(story.getName(), story.getDailyPhoto()));
                }
            }

            @Override
            public void onFailure(Call<List<StoryModel>> call, Throwable t) {

            }
        });


    }

    public void loadPosts(){

        PostApi postApi = Url.getInstance().create(PostApi.class);
        Call<List<PostModel>> postCalls = postApi.getPosts();

        postCalls.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Code: " + response.body(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<PostModel> list = response.body();
                assert list != null;
                listPosts.addAll(list);
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

            }
        });

    }



}
