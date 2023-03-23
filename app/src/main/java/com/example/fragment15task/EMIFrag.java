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

public class EMIFrag extends Fragment {

    EditText editTextLoanAmount, editTextYears, editTextRate2;
    Button buttonFindEMI;
    TextView textViewResult2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_emi_layout,
                container,false);

        //reference to the object recently created fragmentView
        editTextLoanAmount=fragmentView.findViewById(R.id.editTextLoanAmount);
        editTextYears=fragmentView.findViewById(R.id.editTextYears);
        editTextRate2=fragmentView.findViewById(R.id.editTextRate2);
        buttonFindEMI=fragmentView.findViewById(R.id.buttonFindEMI);
        textViewResult2=fragmentView.findViewById(R.id.textViewResultado2);

        buttonFindEMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CUENTA (P x R x (1+R)^N / [(1+R)^N-1]) + P
                //P = Principal loan amount
                //N = Loan tenure in months
                //R = Monthly interest rate
                float amount = Float.parseFloat(editTextLoanAmount.getText().toString());
                float time = Float.parseFloat(editTextYears.getText().toString());
                float rate = Float.parseFloat(editTextRate2.getText().toString());
                double anualRateInterest = rate / 12d ;
                double months = time * 12d;
                //Math.pow(2,3); 1st base and 2nd exponencial
                double result2 = amount + (amount * anualRateInterest *  Math.pow(( 1d + anualRateInterest), months))
                                            / ( Math.pow(1d + anualRateInterest, months - 1d) ) ;

                textViewResult2.setText("Interest win + Loan amount = " + result2);
                //getContext() seen the object
                Toast.makeText(getContext(), "Total amount = " + result2, Toast.LENGTH_SHORT).show();
            }
        });

        return fragmentView;

    }
}
