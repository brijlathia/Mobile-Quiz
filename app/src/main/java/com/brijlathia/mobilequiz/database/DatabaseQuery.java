package com.brijlathia.mobilequiz.database;


import android.content.Context;
import android.database.Cursor;

import com.brijlathia.mobilequiz.entities.CategoryObject;
import com.brijlathia.mobilequiz.entities.QuestionObject;

import java.util.ArrayList;
import java.util.List;

public class DatabaseQuery extends DatabaseObject{

    public DatabaseQuery(Context context) {
        super(context);
    }

    public List<CategoryObject> getAllQuizCategory(int quizType){
        List<CategoryObject> categoryList = new ArrayList<CategoryObject>();
        String query = "select * from category where quiz_type = " + quizType;
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                int categoryId = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String image = cursor.getString(cursor.getColumnIndexOrThrow("image"));
                categoryList.add(new CategoryObject(categoryId, name, image));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return categoryList;
    }

    public List<QuestionObject> getQuizQuestionsById(int id){
        List<QuestionObject> quizQuestionList = new ArrayList<QuestionObject>();
        String query = "select * from quiz where cat_id =" +  id;
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                int quiz_id = cursor.getInt(cursor.getColumnIndexOrThrow("cat_id"));
                String question = cursor.getString(cursor.getColumnIndexOrThrow("question"));
                String options = cursor.getString(cursor.getColumnIndexOrThrow("options"));
                String answer = cursor.getString(cursor.getColumnIndexOrThrow("answer"));
                String image = cursor.getString(cursor.getColumnIndexOrThrow("image"));
                quizQuestionList.add(new QuestionObject(quiz_id, question, options, answer, image));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return quizQuestionList;
    }

}
