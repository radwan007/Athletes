package com.creative.athletes.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.creative.athletes.APIHandler.ApiClient;
import com.creative.athletes.APIHandler.ApiInterface;
import com.creative.athletes.APIHandler.Response.AthletesResponse;
import com.creative.athletes.R;
import com.creative.athletes.adapter.AthleteAdapter;
import com.creative.athletes.data.AthleteItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<AthleteItem> mAthleteList = new ArrayList<>();
    private AthleteItem mAthleteItem;

    private AthleteAdapter mAdapter;
    private ProgressBar loadingimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        GetAthletesRequest();
    }


    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        loadingimage = (ProgressBar) findViewById(R.id.loadingimage);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    public void setupRecyclerView(final ArrayList<AthleteItem> mAthleteList) {


        mAdapter = new AthleteAdapter(this, mAthleteList);
        recyclerView.setAdapter(mAdapter);
    }

    private void GetAthletesRequest() {
        loadingimage.setVisibility(View.VISIBLE);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<AthletesResponse> call = apiService.getathletes();

        call.enqueue(new Callback<AthletesResponse>() {
            @Override
            public void onResponse(Call<AthletesResponse> call, Response<AthletesResponse> response) {
                loadingimage.setVisibility(View.INVISIBLE);
                if (response.isSuccessful()) {
                    try {
                        AthletesResponse athletesResponse = response.body();

                        //Setup Athletes List
                        for (int i = 0; i < athletesResponse.getAthletes().size(); i++) {
                            mAthleteItem = new AthleteItem();
                            mAthleteItem.setName(athletesResponse.getAthletes().get(i).getName());
                            mAthleteItem.setImage(athletesResponse.getAthletes().get(i).getImage());
                            mAthleteItem.setBrief(athletesResponse.getAthletes().get(i).getBrief());
                            mAthleteList.add(mAthleteItem);
                        }
                        setupRecyclerView(mAthleteList);


                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.connectionerror), Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.connectionerror), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AthletesResponse> call, Throwable t) {
                loadingimage.setVisibility(View.INVISIBLE);
                t.printStackTrace();
                Toast.makeText(MainActivity.this, getResources().getString(R.string.connectionerror), Toast.LENGTH_SHORT).show();
            }

        });
    }
}
