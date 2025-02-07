package com.abdolphininfratech.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.abdolphininfratech.Adapter.RewardAdapter;
import com.abdolphininfratech.Model.UserRewardModel;
import com.abdolphininfratech.R;
import com.abdolphininfratech.databinding.ActivityUserRewardBinding;
import java.util.ArrayList;
import java.util.List;


public class UserRewardActivity extends AppCompatActivity {
    ActivityUserRewardBinding binding;
    private List<UserRewardModel> userRewardModels;
    private RewardAdapter rewardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityUserRewardBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        initview();
        onclicklistener();
    }

    private void onclicklistener() {
      binding.backarrow.setOnClickListener(new View.OnClickListener() {
       @Override
        public void onClick(View v) {
         Intent intent = new Intent(UserRewardActivity.this, ContainerActivity.class);
         startActivity(intent);
         finish();
        }
     });


    }

    private void initview() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rewardRecyclerview.setLayoutManager(layoutManager);
        userRewardModels = new ArrayList<>();
        userRewardModels.add(new UserRewardModel("Bag Kit","Pending","500000.00", R.drawable.bagkit));
        userRewardModels.add(new UserRewardModel("Bag Kit","Pending","500000.00", R.drawable.bagkit));
        userRewardModels.add(new UserRewardModel("Bag Kit","Pending","500000.00", R.drawable.bagkit));
        rewardAdapter = new RewardAdapter(userRewardModels, getApplicationContext());
        binding.rewardRecyclerview.setAdapter(rewardAdapter);

    }
}
