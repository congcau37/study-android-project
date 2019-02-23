package com.example.x.volleyinandroid.ui.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.x.volleyinandroid.MyApplication;
import com.example.x.volleyinandroid.R;
import com.example.x.volleyinandroid.config.common.Constants;
import com.example.x.volleyinandroid.model.StudentModel;
import com.example.x.volleyinandroid.ui.adapter.StudentAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListStudentFragment extends Fragment {
    private ArrayList<StudentModel> mData;
    private StudentAdapter mAdapter;
    private ProgressDialog progressDialog;

    public ListStudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_student, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initControls(view);
    }

    private void initControls(View view) {
        RecyclerView rvStudents = view.findViewById(R.id.rvStudents);
        mData = new ArrayList<>();
        mAdapter = new StudentAdapter(getActivity(), mData);
        rvStudents.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvStudents.setAdapter(mAdapter);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(false);
        progressDialog.show();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                Constants.URL + Constants.READ_DATA, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(Constants.JSON_OBJECT_REQUEST, response.toString());
                        try {
                            JSONArray jsonArr = response.getJSONArray("records");
                            for (int i = 0; i < jsonArr.length(); i++) {
                                JSONObject jsonObject = jsonArr.getJSONObject(i);
                                mData.add(new StudentModel(
                                        jsonObject.getInt("id"),
                                        jsonObject.getString("name"),
                                        jsonObject.getString("age")
                                ));
                            }
                            mAdapter.notifyDataSetChanged();
                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
                            Toast.makeText(getActivity(), "Completed", Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(Constants.JSON_OBJECT_REQUEST, "Error: " + error.getMessage());
                        // hide the progress dialog
                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Failure", Toast.LENGTH_SHORT).show();
                    }
        }       );
        // Adding request to request queue
        MyApplication.getInstance().addToRequestQueue(jsonObjReq, Constants.JSON_OBJECT_REQUEST);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MyApplication.getInstance().cancelPendingRequests(Constants.JSON_OBJECT_REQUEST);
    }
}
