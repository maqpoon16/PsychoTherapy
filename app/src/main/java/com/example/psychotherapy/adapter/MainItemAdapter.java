package com.example.psychotherapy.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.psychotherapy.MainActivity;
import com.example.psychotherapy.QuestionsRoundActivity;
import com.example.psychotherapy.R;
import com.example.psychotherapy.RepotsActivity;
import com.example.psychotherapy.UserInputActivity;

public class MainItemAdapter extends RecyclerView.Adapter<MainItemAdapter.ViewHolder> {


    private Context context;
    private String [] menu;
    private String [] menu_click;

    public MainItemAdapter(Context context , String [] menu, String [] Menu_click) {
        this.context=context;
        this.menu=menu;
        this.menu_click=Menu_click;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_item_cardview, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.menu_text.setText(menu[position]);
        holder.menu_onclick.setText(menu_click[position]);

        holder.menu_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menu[position]==menu[0]){

                    Intent intent=new Intent(context, UserInputActivity.class);
                    context.startActivity(intent);
                }
                if (menu[position]==menu[1]){
                    Toast.makeText(context, "Work in progress", Toast.LENGTH_SHORT).show();
                }
                if (menu[position]==menu[2]){

                    Intent intent=new Intent(context, RepotsActivity.class);
                    context.startActivity(intent);
                }
                if (menu[position]==menu[3]){
                    Toast.makeText(context, "Work in progress", Toast.LENGTH_SHORT).show();
                }
                if (menu[position]==menu[4]){
                    Toast.makeText(context, "Work in progress", Toast.LENGTH_SHORT).show();
                }
                if (menu[position]==menu[5]){
                    Intent intent=new Intent(context, QuestionsRoundActivity.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menu.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView menu_text;
        private TextView menu_onclick;
        private LinearLayout menu_box;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            menu_box = itemView.findViewById(R.id.menu_box);
            menu_text=itemView.findViewById(R.id.menu_text);
            menu_onclick=(TextView)itemView.findViewById(R.id.menu_onclick);
        }
    }
}
