package kr.co.episode.epilepsee;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import kr.co.episode.epilepsee.databinding.ActivitySettingBinding;

public class SettingActivity extends AppCompatActivity {
    ActivitySettingBinding activitySettingBinding;
    private TextView textViewSelectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySettingBinding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(activitySettingBinding.getRoot());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ment_spinner_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        activitySettingBinding.mentSpinner.setAdapter(adapter);

        activitySettingBinding.switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    activitySettingBinding.layout1.setVisibility(View.VISIBLE);
                    activitySettingBinding.switch2.setEnabled(true);
                } else {
                    activitySettingBinding.layout1.setVisibility(View.GONE);
                    activitySettingBinding.switch2.setChecked(false);
                    activitySettingBinding.switch2.setEnabled(false);
                    activitySettingBinding.layout2.setVisibility(View.GONE);
                }
            }
        });

        activitySettingBinding.switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    activitySettingBinding.layout2.setVisibility(View.VISIBLE);
                } else {
                    activitySettingBinding.layout2.setVisibility(View.GONE);
                }
            }
        });

        // SeekBar 값 변경 시 호출되는 리스너
        activitySettingBinding.seekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int selectedTime = (progress + 1) * 5; // 5초 단위로 계산
                textViewSelectedTime.setText(selectedTime + " 초");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // 사용하지 않음
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // 사용하지 않음
            }
        });

        textViewSelectedTime = findViewById(R.id.textViewSelectedTime);
    }
}
