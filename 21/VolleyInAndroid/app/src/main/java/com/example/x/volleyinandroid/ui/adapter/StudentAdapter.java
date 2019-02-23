package com.example.x.volleyinandroid.ui.adapter;

/* Created by X on 12/8/2017.
* */

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.x.volleyinandroid.MyApplication;
import com.example.x.volleyinandroid.R;
import com.example.x.volleyinandroid.config.common.Constants;
import com.example.x.volleyinandroid.model.StudentModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<StudentModel> mData;
    private ProgressDialog progressDialog;
    private Dialog dialog;
    private EditText txtInputNewName, txtInputNewAge;
    private Button btnChange;

    public StudentAdapter(Context mContext, ArrayList<StudentModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.custom_item_student, parent, false));
    }

    @Override
    public void onBindViewHolder(StudentAdapter.ViewHolder holder, int position) {
        holder.txtName.setText(mData.get(position).getName());
        holder.txtAge.setText(mData.get(position).getAge());
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

    private void showMenu(final int adapterPosition) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        String coures[] = new String[]{
                "Delete",
                "Update"
        };
        builder.setItems(coures, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        showDeleleAlertDialog(adapterPosition);
                        break;
                    case 1:
                        showUpateAlertDialog(adapterPosition);
                        break;
                }
            }
        });
        builder.create().show();
    }

    private void showUpateAlertDialog(final int adapterPosition) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.update_student_dialog, null);
        dialog = new Dialog(mContext, R.style.Theme_Dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);
        initControls(view);
        initEvents(adapterPosition);
        dialog.show();
    }

    private void initEvents(final int adapterPosition) {
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                StudentModel newStudent = mData.get(adapterPosition);
                String newName = txtInputNewName.getText().toString();
                if (!newName.equals("")) {
                    flag = true;
                    newStudent.setName(newName);
                }
                String newAge = txtInputNewAge.getText().toString();
                if (!newAge.equals("")) {
                    flag = true;
                    newStudent.setAge(newAge);
                }
                if (flag) {
                    updateData(adapterPosition, newStudent);
                }
                dialog.dismiss();
            }
        });
    }

    private void initControls(View view) {
        txtInputNewName = view.findViewById(R.id.txtInputNewName);
        txtInputNewAge = view.findViewById(R.id.txtInputNewAge);
        btnChange = view.findViewById(R.id.btnChange);
    }

    private void updateData(final int adapterPosition, final StudentModel newStudent) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", newStudent.getId());
            jsonObject.put("name", newStudent.getName());
            jsonObject.put("age", newStudent.getAge());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d(Constants.JSON_OBJECT_REQUEST, jsonObject.toString());
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setMessage("Loading");
        progressDialog.show();
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                Constants.URL + Constants.UPDATE_DATA,
                jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                        Toast.makeText(mContext, "Updated", Toast.LENGTH_SHORT).show();
                        mData.set(adapterPosition, newStudent);
                        notifyItemChanged(adapterPosition);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                        Toast.makeText(mContext, "Failure", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        MyApplication.getInstance().addToRequestQueue(request, Constants.JSON_OBJECT_REQUEST);
    }

    private void showDeleleAlertDialog(final int adapterPosition) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Message");
        builder.setMessage("Are you sure?");
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteData(adapterPosition);
            }
        });
        builder.create().show();
    }

    private void deleteData(final int adapterPosition) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", mData.get(adapterPosition).getId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setMessage("Loading");
        progressDialog.show();
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                Constants.URL + Constants.DELETE_DATA,
                jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                        Toast.makeText(mContext, "Deleted", Toast.LENGTH_SHORT).show();
                        mData.remove(mData.get(adapterPosition));
                        notifyItemRemoved(adapterPosition);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                        Toast.makeText(mContext, "Failure", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        MyApplication.getInstance().addToRequestQueue(request, Constants.JSON_OBJECT_REQUEST);
    }
}
