package cl.desafiolatam.android_desafio_4_v2.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import cl.desafiolatam.android_desafio_4_v2.R;

public class Fragment_2 extends Fragment {

    private Button btnCargar2;
    private Button btnCargar3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment}






        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCargar2 = view.findViewById(R.id.btnCargar2);
        btnCargar3 = view.findViewById(R.id.btnCargar3);

        btnCargar2.setOnClickListener(v -> {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.desafiolatam.com"));
            startActivity(browserIntent);

            Toast.makeText(getContext(), "Abriendo la Página de DesafioLatam",Toast.LENGTH_LONG).show();

        });

        btnCargar3.setOnClickListener(v->{

            Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
            whatsappIntent.setType("text/plain");
            whatsappIntent.setPackage("com.whatsapp");
            whatsappIntent.putExtra(Intent.EXTRA_TEXT, "Compartir Foto");

            try {
                startActivity(whatsappIntent);
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(getContext(),"Whatsapp no ha sido instalado",Toast.LENGTH_LONG).show();
            }


        });
    }
}