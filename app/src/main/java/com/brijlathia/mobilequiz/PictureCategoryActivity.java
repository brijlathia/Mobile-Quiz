package com.brijlathia.mobilequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.brijlathia.mobilequiz.entities.CategoryObject;
import com.brijlathia.mobilequiz.adapters.QuizCategoryAdapter;
import com.brijlathia.mobilequiz.database.DatabaseQuery;

import java.util.List;

public class PictureCategoryActivity extends AppCompatActivity {

    private static final String TAG = PictureCategoryActivity.class.getSimpleName();

    private RecyclerView quizRecyclerView;

    private static int quizType = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_category);

        setTitle(getString(R.string.picture_quiz_category));

        DatabaseQuery dbQuery = new DatabaseQuery(PictureCategoryActivity.this);
        List<CategoryObject> categoryData = dbQuery.getAllQuizCategory(1);

        quizRecyclerView = (RecyclerView)findViewById(R.id.picture_category);
        GridLayoutManager mGrid = new GridLayoutManager(this, 2);
        quizRecyclerView.setLayoutManager(mGrid);
        quizRecyclerView.setHasFixedSize(true);

        QuizCategoryAdapter mAdapter = new QuizCategoryAdapter(PictureCategoryActivity.this, categoryData, quizType);
        quizRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent(PictureCategoryActivity.this, QuizMenuActivity.class);
        startActivity(backIntent);
    }
}
