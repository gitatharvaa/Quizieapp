package com.example.quizie;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView questionTextView;
    private Button trueButton, falseButton;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private List<Question> questionList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize your UI elements
        questionTextView = findViewById(R.id.questionTextView);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);

        questionList = new ArrayList<>();
        questionList.add(new Question("1] The `main` method in Java must always be `public` and `static`.", true));
        questionList.add(new Question("2] Java is a case-sensitive programming language.", true));
        questionList.add(new Question("3] The `switch` statement in Java can only work with integer and character values.", false));
        questionList.add(new Question("4] The `final` keyword can be applied to variables, methods, and classes in Java.", true));
        questionList.add(new Question("5] The `break` statement is mandatory in every `case` block of a `switch` statement in Java.", false));

        showQuestion();

        // Set onClickListeners for true and false buttons
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });
    }

    private void showQuestion() {
        if (currentQuestionIndex < questionList.size()) {
            Question currentQuestion = questionList.get(currentQuestionIndex);
            questionTextView.setText(currentQuestion.getQuestionText());
        } else {
            // Handle the end of the quiz (no more questions)
            // You might want to show the final score or a message
            Toast.makeText(MainActivity.this, "Your score is : " + score, Toast.LENGTH_SHORT).show();
        }
    }

    private void checkAnswer(boolean userAnswer) {
        Question currentQuestion = questionList.get(currentQuestionIndex);
        if (userAnswer == currentQuestion.isCorrectAnswer()) {
            // User gave the correct answer
            score++;
        }

        // Move to the next question
        currentQuestionIndex++;

        // Display the next question
        showQuestion();
    }
}
