package com.example.x.volleyinandroid.ui.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.x.volleyinandroid.MyApplication;
import com.example.x.volleyinandroid.R;
import com.example.x.volleyinandroid.config.common.Constants;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddNewStudentFragment extends Fragment implements View.OnClickListener {
    private EditText txtInputName, txtInputAge;
    private Button btnAddNewStudent;
    private ProgressDialog progressDialog;

    public AddNewStudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_new_student, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initControls(view);
        initEvents();
    }

    private void initEvents() {
        btnAddNewStudent.setOnClickListener(this);
    }

    private void initControls(View view) {
        btnAddNewStudent = view.findViewById(R.id.btnAddNewStudent);
        txtInputName = view.findViewById(R.id.txtInputName);
        txtInputAge = view.findViewById(R.id.txtInputAge);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddNewStudent:
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("name", txtInputName.getText().toString());
                    jsonObject.put("age", txtInputAge.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setMessage("Loading");
                progressDialog.show();
                JsonObjectRequest request = new JsonObjectRequest(
                        Request.Method.POST,
                        Constants.URL + Constants.POST_DATA,
                        jsonObject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                if (progressDialog.isShowing())
                                    progressDialog.dismiss();
                                Toast.makeText(getActivity(), "Complete", Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                if (progressDialog.isShowing())
                                    progressDialog.dismiss();
                                Toast.makeText(getActivity(), "Failure", Toast.LENGTH_SHORT).show();
                                Log.d(Constants.JSON_OBJECT_REQUEST, "Error: " + error.getMessage());
                            }
                        }
                );
                MyApplication.getInstance().addToRequestQueue(request, Constants.JSON_OBJECT_REQUEST);
                txtInputName.setText("");
                txtInputAge.setText("");
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MyApplication.getInstance().cancelPendingRequests(Constants.JSON_OBJECT_REQUEST);
    }
}
