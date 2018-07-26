package com.facundoalvarado.mascotapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facundoalvarado.mascotapp.Data.Mito;
import com.facundoalvarado.mascotapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MitosFragment extends Fragment {

    public MitosFragment() {
    }

//    Definiendo constantes

//    Widgets
    TextView tituloMito;
    TextView descripcionMito;
    Button btnAnterior;
    Button btnSiguiente;

//    Constantes a usar para "jugar" con los mitos
    int mIndice;

    int mMitoTitulo;
    int mMitoDescripcion;

//    Lista de mitos a utilizar
    private Mito[] mMitosBank = new Mito[]{
            new Mito(R.string.titulo_mito_0, R.string.descripcion_mito_0),
            new Mito(R.string.titulo_mito_1,R.string.descripcion_mito_1)
    };


//    Método OnCreate, esto sucede al abrir el fragmento
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_mitos, container, false);

//        Definiendo las constantes mencionadas al comienzo

//        Widgets
        tituloMito = (TextView) rootView.findViewById(R.id.tituloMito);
        descripcionMito = (TextView) rootView.findViewById(R.id.descripcionMito);
        btnAnterior = (Button) rootView.findViewById(R.id.btnAnterior);
        btnSiguiente = (Button) rootView.findViewById(R.id.btnSiguiente);

//        Constantes

//      De la lista de mitos, seleccionar aquel en cierta posición (mIndice) y tomar
//        el titulo
        mMitoTitulo = mMitosBank[mIndice].getTituloID();
//        y la descripcion
        mMitoDescripcion = mMitosBank[mIndice].getDescripcionID();

//      Poniendo el titulo y la descripcion del mito en los widgets de la pantalla
        tituloMito.setText(mMitoTitulo);
        descripcionMito.setText(mMitoDescripcion);

//        Acciones de los botones
//        boton "Anterior"
        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mitoAnterior();
            }
        });

//        boton "Siguiente"
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mitoSiguiente();
            }
        });

        return rootView;
    }

//    Funciones para cambiar mitos
    public void mitoSiguiente(){
        mIndice = (mIndice + 1) % mMitosBank.length;
        mMitoTitulo = mMitosBank[mIndice].getTituloID();
        mMitoDescripcion = mMitosBank[mIndice].getDescripcionID();

        tituloMito.setText(mMitoTitulo);
        descripcionMito.setText(mMitoDescripcion);

    }

    public void mitoAnterior(){
        mIndice = (mIndice - 1)*-1;
        mMitoTitulo = mMitosBank[mIndice].getTituloID();
        mMitoDescripcion = mMitosBank[mIndice].getDescripcionID();

        tituloMito.setText(mMitoTitulo);
        descripcionMito.setText(mMitoDescripcion);

    }

}
