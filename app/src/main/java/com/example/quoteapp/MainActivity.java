package com.example.quoteapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowHeaderPresenter;
import androidx.leanback.widget.RowPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Workout> workouts = new ArrayList<>();

    private ListView workoutListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workoutListView = findViewById(R.id.workoutListView);

        createWorkouts();

        List<String> workoutList = new ArrayList<>();
        for (Workout workout : workouts) {
            workoutList.add(workout.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, workoutList);
        workoutListView.setAdapter(adapter);

        workoutListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Workout selectedWorkout = workouts.get(position);
//                Toast.makeText(MainActivity.this, "Selected workout: " + selectedWorkout.getName(), Toast.LENGTH_SHORT).show();

                // Start a new activity or fragment based on the selected workout
                Intent intent = new Intent(MainActivity.this, WorkoutDetailsActivity.class);
                intent.putExtra("selectedWorkout", selectedWorkout.getName());
                startActivity(intent);
            }
        });
    }

    public void createWorkouts () {

// Workout 1
        ArrayList<Workout.Step> steps1 = new ArrayList<>();
        steps1.add(new Workout.Step(1, "Warm-up"));
        steps1.add(new Workout.Step(2, "Cardio exercises"));
        steps1.add(new Workout.Step(3, "Strength training"));
        Workout workout1 = new Workout("Morning Workout", steps1);
        workouts.add(workout1);

// Workout 2
        ArrayList<Workout.Step> steps2 = new ArrayList<>();
        steps2.add(new Workout.Step(1, "Stretching"));
        steps2.add(new Workout.Step(2, "Core exercises"));
        steps2.add(new Workout.Step(3, "Balance training"));
        Workout workout2 = new Workout("Core Workout", steps2);
        workouts.add(workout2);

// Workout 3
        ArrayList<Workout.Step> steps3 = new ArrayList<>();
        steps3.add(new Workout.Step(1, "Warm-up"));
        steps3.add(new Workout.Step(2, "Lower body exercises"));
        steps3.add(new Workout.Step(3, "Upper body exercises"));
        Workout workout3 = new Workout("Full Body Workout", steps3);
        workouts.add(workout3);

// Workout 4
        ArrayList<Workout.Step> steps4 = new ArrayList<>();
        steps4.add(new Workout.Step(1, "Chest exercises"));
        steps4.add(new Workout.Step(2, "Shoulder exercises"));
        steps4.add(new Workout.Step(3, "Arm exercises"));
        Workout workout4 = new Workout("Upper Body Strength", steps4);
        workouts.add(workout4);

// Workout 5
        ArrayList<Workout.Step> steps5 = new ArrayList<>();
        steps5.add(new Workout.Step(1, "Leg exercises"));
        steps5.add(new Workout.Step(2, "Glute exercises"));
        steps5.add(new Workout.Step(3, "Core exercises"));
        Workout workout5 = new Workout("Lower Body Workout", steps5);
        workouts.add(workout5);
    }




}
