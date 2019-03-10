package com.dsc.android.bootcamp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    //private List<RecyclerViewData> mockDataList =new ArrayList<>();
    private List<RecyclerViewData> userList =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView=findViewById(R.id.recyclerView);
        apicall();
        //CreateMockList();
        setUpRecyclerView();

    }

    private void apicall() {
     ApiService apiService=AppClient.getInstance().createService(ApiService.class);
        Call<UserWrappper>call=apiService.getUserList();
        call.enqueue(new Callback<UserWrappper>() {
            @Override
            public void onResponse(Call<UserWrappper> call, Response<UserWrappper> response) {
               if(response.isSuccessful()){
                   if(response.body()!=null){
                       userList.addAll(response.body().getRecyclerViewData());
                       Log.e("here====", "ok");
                   }
               }
            }

            @Override
            public void onFailure(Call<UserWrappper> call, Throwable t) {

            }
        });
    }

    private void setUpRecyclerView() {
        recyclerViewAdapter = new RecyclerViewAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
//        recyclerViewAdapter.setRecyclerViewDataList(mockDataList);
        recyclerViewAdapter.setRecyclerViewDataList(userList);
        recyclerViewAdapter.notifyDataSetChanged();


    }
/*
    private void CreateMockList(){
        RecyclerViewData data;
        data =new RecyclerViewData("Ena Chandak","9425535390" ,"https://bit.ly/2NT7svr");
        mockDataList.add(data);
        data =new RecyclerViewData("Aditi Agrawal","911151690" ,"https://bit.ly/2NT7svr");
        mockDataList.add(data);
        data =new RecyclerViewData("vinay Agrawal","911189690" ,"https://bit.ly/2NT7svr");
        mockDataList.add(data);
        data =new RecyclerViewData("Ena Chandak","9425535390" ,"https://bit.ly/2NT7svr");
        mockDataList.add(data);
        data =new RecyclerViewData("Aditi Agrawal","911151690" ,"https://bit.ly/2NT7svr");
        mockDataList.add(data);
        data =new RecyclerViewData("vinay Agrawal","911189690" ,"https://bit.ly/2NT7svr");
        mockDataList.add(data);
        data =new RecyclerViewData("Ena Chandak","9425535390" ,"https://bit.ly/2NT7svr");
        mockDataList.add(data);
        data =new RecyclerViewData("Aditi Agrawal","911151690" ,"https://bit.ly/2NT7svr");
        mockDataList.add(data);
        data =new RecyclerViewData("vinay Agrawal","911189690" ,"https://bit.ly/2NT7svr");
        mockDataList.add(data);
    }*/
}
