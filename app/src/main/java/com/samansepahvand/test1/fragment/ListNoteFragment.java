package com.samansepahvand.test1.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.samansepahvand.test1.Model;
import com.samansepahvand.test1.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListNoteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListNoteFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private TextView txtShow;
    private Button btnGoEnd;
    private NavController navController;


    public ListNoteFragment() {
        // Required empty public constructor
    }


    public static ListNoteFragment newInstance(String param1, String param2) {
        ListNoteFragment fragment = new ListNoteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        navController = Navigation.findNavController(view);

        btnGoEnd = view.findViewById(R.id.btn_go_end);
        txtShow = view.findViewById(R.id.textView);

        if (getArguments() != null) {

            ListNoteFragmentArgs args=ListNoteFragmentArgs.fromBundle(getArguments());
            txtShow.setText(args.getMessage());
        }


        btnGoEnd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_go_end:

                Log.e("TAG", "onNavigationItemSelected 1:  "+ navController.getCurrentDestination()+"///" +    navController.getCurrentDestination().getId() );

                Model model=new Model("Saman","Sepahvand");
                ListNoteFragmentDirections.ActionListNoteFragmentToBlankFragment action=
                        ListNoteFragmentDirections.actionListNoteFragmentToBlankFragment(model);
                action.setData(50);
                navController.navigate(action);
                break;
        }
    }
}