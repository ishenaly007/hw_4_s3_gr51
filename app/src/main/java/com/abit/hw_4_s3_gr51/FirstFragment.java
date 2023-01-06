package com.abit.hw_4_s3_gr51;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abit.hw_4_s3_gr51.databinding.FragmentFirstBinding;

import java.util.ArrayList;


public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;
    ArrayList<Film> films = new ArrayList<Film>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        films.clear();
        setInitialData();
        RecyclerView recyclerView = binding.list;
        // определяем слушателя нажатия элемента в списке
        Adapter.OnFilmClickListener filmClickListener = new Adapter.OnFilmClickListener() {
            @Override
            public void onFilmClick(Film film, int position) {

                Film filmList = films.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("list", filmList);
                Fragment fragment = new SecondFragment();
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container111, fragment).addToBackStack(null).commit();

            }
        };
        // создаем адаптер
        Adapter adapter = new Adapter(getContext(), films, filmClickListener);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData(){

        films.add(new Film ("matrix", "The Matrix is a 1999 science fiction action film written and directed by the Wachowskis.\n" +
                " It is the first installment in The Matrix film series", "7.0", R.drawable.matrix));
        films.add(new Film ("1917", "«1917» (англ. 1917) — британский военный фильм режиссёра и продюсера Сэма Мендеса,\n" +
                " который также написал сценарий совместно с Кристи Уилсон-Кэрнс.", "5.8", R.drawable.fim1917));
        films.add(new Film ("angry birds", "«Angry Birds в кино» (англ. The Angry Birds Movie) — компьютерный анимационный фильм\n" +
                " по мотивам популярной игры Angry Birds компании Rovio.", "9.0", R.drawable.angry_birds));
        films.add(new Film ("red", "«РЭД» (англ. RED) — художественный фильм Роберта Швентке в жанре комедийного боевика\n" +
                ", вышедший на экраны 29 сентября 2010 года.", "7.9", R.drawable.red));
        films.add(new Film ("how to train your dragon", "How to Train Your Dragon is a 2010 American computer-animated action fantasy film\n" +
                " loosely based on the 2003 book of the same name by Cressida Cowell\n" +
                ", produced by DreamWorks Animation and distributed by Paramount Pictures.", "8.3", R.drawable.how_dragon_train));
    }

}