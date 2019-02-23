package com.example.x.firebaseandroid.ui.adapter;

/* Created by X on 12/2/2017.
* */

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.x.firebaseandroid.R;
import com.example.x.firebaseandroid.model.StudentModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<StudentModel> mData;
    private DatabaseReference mDatabase;
    private Dialog dialog;
    private EditText txtInputNewName, txtInputNewAge;
    private Button btnChange;
    private StudentModel newStudent;

    public StudentAdapter(Context mContext, ArrayList<StudentModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.custom_items_student, parent, false));
    }

    @Override
    public void onBindViewHolder(StudentAdapter.ViewHolder holder, int position) {
        holder.txtName.setText(mData.get(position).getName());
        holder.txtAge.setText(String.valueOf(mData.get(position).getAge()));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtName, txtAge;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAge = itemView.findViewById(R.id.txtAge);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            showMenu(getAdapterPosition());
        }
    }

    private void showMenu(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        String courses[] = new String[]{
                "Delete",
                "Update"
        };
        builder.setItems(courses, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        showDeleteAlertDialog(position);
                        break;
                    case 1:
                        showUpdateAlertDialog(position);
                        break;
                }
            }
        });
        builder.create().show();
    }

    private void showUpdateAlertDialog(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.update_student_dialog, null);
        dialog = new Dialog(mContext, R.style.Theme_Dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);
        initControls(view);
        initEvents(position);
        dialog.show();
    }

    private void initEvents(final int position) {
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                newStudent = new StudentModel(mData.get(position).getName(), mData.get(position).getAge());
                String newName = txtInputNewName.getText().toString();
                if (!newName.equals("")) {
                    flag = true;
                    newStudent.setName(newName);
                }
                String newAge = txtInputNewAge.getText().toString();
                if (!newAge.equals("")) {
                    flag = true;
                    newStudent.setAge(Integer.parseInt(newAge));
                }
                if (flag) {
                    mDatabase
                            .child("Student")
                            .child(mData.get(position).getKey())
                            .setValue(newStudent)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(mContext, "Updating successfully", Toast.LENGTH_SHORT).show();
                                    newStudent.setKey(mData.get(position).getKey());
                                    mData.set(position, newStudent);
                                    notifyItemChanged(position);
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(mContext, "Updating failure", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
                txtInputNewName.setText("");
                txtInputNewAge.setText("");
                dialog.dismiss();
            }
        });
    }

    private void initControls(View view) {
        txtInputNewName = view.findViewById(R.id.txtInputNewName);
        txtInputNewAge = view.findViewById(R.id.txtInputNewAge);
        btnChange = view.findViewById(R.id.btnChange);
    }

    private void showDeleteAlertDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Message");
        builder.setMessage("Are you sure?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mDatabase.child("Student").child(mData.get(position).getKey()).removeValue();
                mData.remove(mData.get(position));
                notifyItemRemoved(position);
            }
        });
        builder.setNegativeButton("No", null);
        builder.create().show();
    }
}
