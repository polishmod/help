package pl.mil.wp.help.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import pl.mil.wp.help.API.models.BooleanApiResponse;
import pl.mil.wp.help.R;
import pl.mil.wp.help.connection.RetrofitManager;
import pl.mil.wp.help.connection.apiusers.ApiUsersService;
import pl.mil.wp.help.shared_preferences.SharedPreferencesUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AcceptDoctorDialog extends DialogFragment {

    String doctorName;
    int doctorID;
    AlertDialog dialogToCreate;

    public AcceptDoctorDialog(String doctorName, int doctorID) {
        this.doctorName = doctorName;
        this.doctorID = doctorID;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_share_information_with_doctor, null);
        TextView textView = dialogView.findViewById(R.id.tv_dialog_text);
        textView.setText("Do you want to share your data with doctor " + doctorName + " ?");
        builder.setView(dialogView);
        dialogToCreate = builder.create();
        Button btnNo = dialogView.findViewById(R.id.btn_dialog_no);
        Button btnYes = dialogView.findViewById(R.id.btn_dialog_yes);
//        btnYes.setOnClickListener(v -> dialogToCreate.dismiss());
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authorizeDoctor(doctorID);
            }
        });
        btnNo.setOnClickListener(v -> dialogToCreate.dismiss());


        dialogToCreate.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return dialogToCreate;
    }

    @Override
    public void onResume() {
        super.onResume();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int displayWidth = displayMetrics.widthPixels;
        int displayHeight = displayMetrics.heightPixels;
        resizeDialog(displayWidth, displayHeight, 0.9f, 0.6f);
    }

    private void resizeDialog(int initialWidth, int initialHeight, float ratioWidth, float ratioHeight) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(getDialog().getWindow().getAttributes());
        int dialogWindowWidth = (int) (initialWidth * ratioWidth);
        int dialogWindowHeight = (int) (initialHeight * ratioHeight);
        layoutParams.width = dialogWindowWidth;
        layoutParams.height = dialogWindowHeight;
        //in order to properly resize layout
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().getWindow().setAttributes(layoutParams);
    }

    private void authorizeDoctor(int doctorID) {
        ApiUsersService apiUsersService = RetrofitManager.buildService(ApiUsersService.class);

        apiUsersService.authorizeDoctor("Bearer " + SharedPreferencesUtil.getAuthToken(requireContext()), doctorID).enqueue(new Callback<BooleanApiResponse>() {
            @Override
            public void onResponse(Call<BooleanApiResponse> call, Response<BooleanApiResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(requireContext(), "Shared data successful", Toast.LENGTH_SHORT).show();
                    dialogToCreate.dismiss();
                } else {
                    Toast.makeText(requireContext(), requireContext().getString(R.string.login_auth_problem_info) + " Try again.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BooleanApiResponse> call, Throwable t) {
                Toast.makeText(requireContext(), "Shared data failed. Try again", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
