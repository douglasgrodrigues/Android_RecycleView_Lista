package com.example.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.RecyclerItemClickListener;
import com.example.recyclerview.activity.adapter.Adapter;
import com.example.recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //criar listagem de item
        this.criarFilmes();

        //Configurar adapter
        Adapter adapter = new Adapter( listaFilmes );

        //configurar o RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize( true );
        recyclerView.addItemDecoration( new DividerItemDecoration( this, LinearLayout.VERTICAL));
        recyclerView.setAdapter( adapter );

        //Adicionar evento de clique
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText( getApplicationContext(), "Item pressionado " + filme.getTitulo(),
                                        Toast.LENGTH_SHORT ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText( getApplicationContext(), "Clique longo " + filme.getTitulo(),
                                        Toast.LENGTH_SHORT ).show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                ));


    }

    public void criarFilmes(){

        Filme filme = new Filme("The wizard of oz", "fiction","1965");
        listaFilmes.add( filme );

        filme = new Filme("Titanic", "Drama","1992");
        listaFilmes.add( filme );

        filme = new Filme("It", "Terror", "2017");
        listaFilmes.add( filme );

        filme = new Filme("Dark", "Ficção","2019");
        listaFilmes.add( filme );

        filme = new Filme("The Wolf of wallStreet", "Comédia","2014");
        listaFilmes.add( filme );

        filme = new Filme("Titanic", "Drama","1992");
        listaFilmes.add( filme );

        filme = new Filme("It", "Terror", "2017");
        listaFilmes.add( filme );

        filme = new Filme("Dark", "Ficção","2019");
        listaFilmes.add( filme );

        filme = new Filme("The Wolf of wallStreet", "Comédia","2014");
        listaFilmes.add( filme );

        filme = new Filme("Titanic", "Drama","1992");
        listaFilmes.add( filme );

        filme = new Filme("It", "Terror", "2017");
        listaFilmes.add( filme );

        filme = new Filme("Dark", "Ficção","2019");
        listaFilmes.add( filme );

        filme = new Filme("The Wolf of wallStreet", "Comédia","2014");
        listaFilmes.add( filme );

    }

}
