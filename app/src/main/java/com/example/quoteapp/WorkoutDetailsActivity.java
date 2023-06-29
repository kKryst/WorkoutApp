package com.example.quoteapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WorkoutDetailsActivity extends Activity {

    ArrayList<Workout> workouts = new ArrayList<>();

    ArrayList<Workout.Step> steps = new ArrayList<>();

    private TextView workoutTitleTextView;
    private ImageView workoutImageView;
    private TextView descriptionTextView;
    private TextView repsTextView;
    private Button previousStepButton;
    private Button nextStepButton;

    int reps = 10;

    private int stepCounter = 0;

    private String passedWorkout = "";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createWorkouts();
        setContentView(R.layout.activity_workout_details);



        workoutTitleTextView = findViewById(R.id.workoutTitleTextView);
        workoutImageView = findViewById(R.id.workoutImageView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        repsTextView = findViewById(R.id.repsTextView);
        previousStepButton = findViewById(R.id.previousStepButton);
        nextStepButton = findViewById(R.id.nextStepButton);



        // Retrieve the selected workout details from the intent
        String selectedWorkout = getIntent().getStringExtra("selectedWorkout");
        passedWorkout = selectedWorkout;

        Workout workout = findWorkout(selectedWorkout);

        steps = workout.getSteps();

        // Set the workout title
        workoutTitleTextView.setText(workout.getName());

        // Set the workout image (replace R.drawable.workout_image with the appropriate image resource)
        workoutImageView.setImageResource(R.drawable.workout_image);

        // Set the workout description
        String workoutDescription = getStepDescription(selectedWorkout, stepCounter);
        descriptionTextView.setText(workoutDescription);

        // Set the workout reps
        int workoutReps = getWorkoutReps(selectedWorkout);
        repsTextView.setText("Reps: " + reps);

        previousStepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stepCounter > 0) {
                    stepCounter--;
                    reps -= 5;
                    descriptionTextView.setText(getStepDescription(selectedWorkout, stepCounter));
                    repsTextView.setText("Reps: " + reps);
                }
            }
        });

        nextStepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stepCounter < 2) {
                    stepCounter++;
                    reps += 5;
                    descriptionTextView.setText(getStepDescription(selectedWorkout, stepCounter));
                    repsTextView.setText("Reps: " + reps);
                }
            }
        });
    }

    private String getWorkoutDescription(String workoutName) {

        return "Workout description for " + workoutName;
    }

    private String getStepDescription(String workoutName, int number) {
        Workout currentWorkout = findWorkout(workoutName);

        if (0 <= number && number <= 2) {
            String desc = currentWorkout.getSteps().get(number).getDescription();
            return desc;

        }
        return "";

    }

    private int getWorkoutReps(String workoutName) {

        return reps;
    }

    public Workout findWorkout(String name) {
        for (int i = 0; i < workouts.size(); i++) {
            String workoutName = workouts.get(i).getName();
            if (workoutName.equals(name)) {
                return workouts.get(i);
            }
        }

        return workouts.get(0);
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
