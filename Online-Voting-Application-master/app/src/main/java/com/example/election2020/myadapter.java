package com.example.election2020;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myadapter extends FirebaseRecyclerAdapter<signupdata, myadapter.myviewholder> {
    public myadapter(@NonNull FirebaseRecyclerOptions<signupdata> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull signupdata model) {
        holder.name.setText(model.getFullname());
        holder.age.setText(model.getUsername());
        holder.phone_no.setText(model.getPhoneno());
        holder.email.setText(model.getEmailid());
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder {
        TextView name, age, phone_no, email;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nametext);
            age = (TextView) itemView.findViewById(R.id.age);
            phone_no = (TextView) itemView.findViewById(R.id.phone_no);
            email = (TextView) itemView.findViewById(R.id.emailtext);
        }
    }
}
