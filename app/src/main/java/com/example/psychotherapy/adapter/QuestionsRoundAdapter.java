package com.example.psychotherapy.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.psychotherapy.Database.DAO;
import com.example.psychotherapy.Database.RoomDB;
import com.example.psychotherapy.R;
import com.example.psychotherapy.model.GlobalVariable;
import com.example.psychotherapy.model.QuestionsRound;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class QuestionsRoundAdapter extends RecyclerView.Adapter<QuestionsRoundAdapter.ViewHolder> {
    Context context;
    private String [] question;
    public QuestionsRoundAdapter(Context context, String[] question) {
        this.context=context;
        this.question=question;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.questions_round_cardview, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.tv_question.setText(question[position]);
        holder.tv_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.et_answer.setVisibility(View.VISIBLE);
                holder.btn_save_answer.setVisibility(View.VISIBLE);


            }
        });
        holder.btn_save_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!holder.et_answer.getText().toString().isEmpty()) {
                    String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
                    QuestionsRound questionsRound = new QuestionsRound(holder.tv_question.getText().toString(),holder.et_answer.getText().toString(),date);
                  //  insertAsync(questionsRound);
                    new insertAsyncTask().execute(questionsRound);
                    holder.et_answer.setVisibility(View.GONE);
                    holder.btn_save_answer.setVisibility(View.GONE);
                    Toast.makeText(context, "Anwser Saved!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return question.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Button btn_save_answer;
        private TextView tv_question;
        private EditText et_answer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btn_save_answer=itemView.findViewById(R.id.btn_save_answer);
            tv_question=itemView.findViewById(R.id.tv_question);
            et_answer=itemView.findViewById(R.id.et_answer);

        }
    }

    @SuppressLint("StaticFieldLeak")
    class insertAsyncTask extends AsyncTask<QuestionsRound, Void, Void> {
        //Database initialization
        private DAO mAsyncTaskDao;
        private RoomDB roomDB;

        public insertAsyncTask() {
            roomDB = RoomDB.getDatabase(GlobalVariable.activity);
            mAsyncTaskDao = roomDB.dao();
        }
        @Override
        protected Void doInBackground(final QuestionsRound... params) {
            mAsyncTaskDao.QuestionroundInsert(params[0]);
            return null;
        }
    }
}
