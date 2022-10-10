package com.example.medicine_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import me.dm7.barcodescanner.zxing.sample.R;

import java.util.ArrayList;


public class FragmentSearch extends Fragment {

    private AutoCompleteTextView txAutoComplete;
    private ArrayList<String> DrugList;
    private AutoComplete autoDB;
    Button myButton;
    DBHandler dbHandler;

    Drug drug;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drug = new Drug();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        myButton = view.findViewById(R.id.buttonBarcode);
        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SimpleScannerActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        Button searchbtn = view.findViewById(R.id.searchbtn);
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drug = new Drug();
                String text = txAutoComplete.getText().toString();
                Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
                drug = dbHandler.search(text);
                Intent intent = new Intent(getActivity(), RESULT_ACTIVITY.class);

                intent.putExtra("drug", drug);
                startActivity(intent);
            }
        });

        // ======================================================================

        txAutoComplete = view.findViewById(R.id.txAutoComplete);
        autoDB = new AutoComplete(getActivity());

        DrugList = autoDB.getName();

        ArrayAdapter<String> autoComplete = new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, DrugList);
        txAutoComplete.setAdapter(autoComplete); //layout id:txAutoComplete에 어댑터 autoComplete 연결
        return view;
    }
}