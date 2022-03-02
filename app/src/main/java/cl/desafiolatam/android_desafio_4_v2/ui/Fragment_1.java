package cl.desafiolatam.android_desafio_4_v2.ui;

import static android.app.Activity.RESULT_OK;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.CameraProvider;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.extensions.internal.PreviewConfigProvider;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

import cl.desafiolatam.android_desafio_4_v2.R;

public class Fragment_1 extends Fragment {


    private Button btnCargar;
    private Button btnNext;
    private ImageView ivPic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_1, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCargar = view.findViewById(R.id.btnCargar);
        btnNext = view.findViewById(R.id.btnNext);
        ivPic = view.findViewById(R.id.ivPic);


        btnCargar.setOnClickListener(v -> {

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            start.launch(intent);


        });

        btnNext.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_fragment_1_to_fragment_2);
        });


    }

    ActivityResultLauncher<Intent> start = registerForActivityResult( new ActivityResultContracts.StartActivityForResult(), result -> {
        //aquí es cuando se hace el launch.
        if (result != null && result.getResultCode() == RESULT_OK) {

            Bundle extras = result.getData().getExtras();
            Bitmap img = (Bitmap) extras.get("data");
            ivPic.setImageBitmap(img);

        } });
}