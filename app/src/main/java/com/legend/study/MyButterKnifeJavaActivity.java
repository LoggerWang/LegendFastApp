package com.legend.study;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.legend.ArouterConst;
import com.legend.R;

@Route(path = ArouterConst.ACTIVITY_BUTTERKNIFE_JAVA)
public class MyButterKnifeJavaActivity extends AppCompatActivity {
    @MyButterKinfeJava(R.id.tvShow1)
    TextView tvShow;
    @MyButterKinfeJava(R.id.ivShow1)
    ImageView ivShow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife_java);
        InjectViewUtilsJava.init(this);

        tvShow.setText("我的注解成功了");
        ivShow.setImageResource(R.drawable.ic_launcher_background);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    a[0]=i;
                    a[1]=j;
                }
            }
        }
        return a;
    }
}
