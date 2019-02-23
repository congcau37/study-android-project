package com.example.x.androidasynctaskwithjsonparsing.ui.fragment;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.x.androidasynctaskwithjsonparsing.R;
import com.example.x.androidasynctaskwithjsonparsing.config.common.Constants;
import com.example.x.androidasynctaskwithjsonparsing.config.network.HttpHandler;
import com.example.x.androidasynctaskwithjsonparsing.model.ProductModel;
import com.example.x.androidasynctaskwithjsonparsing.ui.adapter.ProductAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    public static final String TAG = "JSON_PARSING";
    private ArrayList<ProductModel> mData;
    private RecyclerView rvProducts;
    private boolean flag = false;
    private View view1 = null;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view1 == null) {
            view1 = inflater.inflate(R.layout.fragment_home, container, false);
            flag = false;
        } else {
            flag = true;
        }
        return view1;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "" + flag);
        rvProducts = view.findViewById(R.id.rvProducts);
        if (!flag) {
            mData = new ArrayList<>();
            new GetProducts().execute();
        }
    }

    private class GetProducts extends AsyncTask<Void, Void, Void> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(Constants.URL);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONArray jsonArray = new JSONArray(jsonStr);

                    // Getting JSON Array node
                    //JSONArray contacts = jsonObj.getJSONArray();

                    // looping through All Contacts
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject c = jsonArray.getJSONObject(i);
                        //add data to the list
                        mData.add(new ProductModel(
                                c.getInt("id_sanpham"),
                                c.getString("ten_sanpham"),
                                c.getInt("id_danhmuc"),
                                c.getInt("gia_sanpham"),
                                c.getString("mota_sanpham"),
                                c.getInt("sanpham_noibat"),
                                c.getString("anh_sanpham")
                        ));

                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (progressDialog.isShowing())
                progressDialog.dismiss();
            ProductAdapter adapter = new ProductAdapter(getActivity(), mData);
            rvProducts.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            rvProducts.setAdapter(adapter);
        }

    }
}
