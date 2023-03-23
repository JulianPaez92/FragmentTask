package com.example.fragment15task;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SIFrag  extends Fragment {

    EditText editTextPrincipalAmount, editTextRate1, editTextTime;
    Button buttonFindSI;
    TextView textViewResult1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_simpleinterest_layout,
                container, false);

        //reference to the object recently created fragmentView
        editTextPrincipalAmount=fragmentView.findViewById(R.id.editTextPrincipalAmount);
        editTextRate1=fragmentView.findViewById(R.id.editTextRate1);
        editTextTime=fragmentView.findViewById(R.id.editTextTime);
        buttonFindSI=fragmentView.findViewById(R.id.buttonFindSI);
        textViewResult1=fragmentView.findViewById(R.id.textViewResultado1);

        buttonFindSI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CUENTA -> (PxRxT)/100 + P
                //P = Principal amount
                //R = Rate
                //T = Time
                float amount = Float.parseFloat(editTextPrincipalAmount.getText().toString());
                float rate = Float.parseFloat(editTextRate1.getText().toString());
                float time = Float.parseFloat(editTextTime.getText().toString());
                float result1 = amount + ((amount * rate * time) / 100);
                textViewResult1.setText("Interest win + Principal amount = "+result1);
                //getContext() seen the object
                Toast.makeText(getContext(), "Total amount = "+ result1, Toast.LENGTH_SHORT).show();

            }
        });


        return fragmentView;
    }


}
