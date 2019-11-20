package com.example.psychotherapy.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.psychotherapy.model.QuestionsRound;
import com.example.psychotherapy.model.SignupUser;
import com.example.psychotherapy.model.UserInputData;
import com.example.psychotherapy.model.UserRatingData;

import java.util.List;


//database access objects
@Dao
public interface DAO {
    //Queries for User data
    //for Signup data save
    @Insert
    public  void UserDataInsert(SignupUser user);

    @Update
    public  void UserDataUpdate(SignupUser user);

    //to login Authentication
     @Query("SELECT _password FROM userinfo WHERE _email = (:email)")
     String GetUserAuthentication(String email);

     //to get user data
    @Query("SELECT * FROM userinfo WHERE _email = (:email)")
    SignupUser GetUserData(String email);

    //for Signup data save
    @Insert
    public  void UserInputInsert(UserInputData inputs);

    @Query("SELECT * FROM userinputdata WHERE _date LIKE (:date)")
    List<UserInputData> GetInputData_OnDate(String date);


    //for User Rating data save
    @Insert
    public  void RatingDataInsert(UserRatingData ratingDataU);

    @Query("SELECT * FROM user_ratings WHERE _date LIKE (:date)")
    List<UserRatingData> GetRatingData(String date);
    @Query("SELECT * FROM user_ratings ")
    List<UserRatingData> GetAllRatingData();

    //for User Question Round
    @Insert
    public  void QuestionroundInsert(QuestionsRound questionsRound);
    @Query("SELECT * FROM questionsround WHERE _date LIKE (:date)")
    List<QuestionsRound> GetQuestionroundData(String date);
    @Query("SELECT * FROM questionsround")
    List<QuestionsRound> GetQuestionroundData();
    //    @Query("select * from signup")
//    public List<SignupUser> getAllSignupData();
//    @Query("SELECT * FROM BORROWER_DETAIL WHERE id = (:loanId)")
//    Borrower_Detail Borr_Detail_Id(String loanId);
//    @Update
//    public void UpdateUser(User_Form user_form);
//
//    @Delete
//    public  void Delete_User(User_Form user_form);
//
//    @Update
//    public void UpdateUserBorrower_Detail(Borrower_Detail borrowerDetail);
//
//    @Delete
//    public  void Delete_UserBorrower_Detail(Borrower_Detail borrowerDetail);



}
