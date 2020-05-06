package com.example.ui.home.characters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.marvelapp.MainActivity;
import com.example.marvelapp.R;
import com.example.model.Result;
import com.example.ui.home.favorites.FavoritesFragment;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;


public class CharacterRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String ACTION_LIKE_IMAGE_DOUBLE_CLICKED = "action_like_image_button";
    private List<Result> results;
    private int tapCount = 0;
    public CharacterRVAdapter(List<Result> results) {
        this.results = results;
    }
    Fragment fragment ;
     Context context;



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.character_item_layout,parent,false);
        final CharacterViewHolder characterViewHolder = new CharacterViewHolder(view);

        characterViewHolder.characterCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Result result = getItem(characterViewHolder.getAdapterPosition());
                if (result != null) {
                    tapCount++;
                    if (tapCount == 1) {
/*
                        Intent newIntent = new Intent(context, MainActivity.class);
                        context.startActivity(newIntent);
                        */
                       // onDoubleClick(characterViewHolder.getAdapterPosition(), result);
                    }

                }
            }
        });

        return characterViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CharacterViewHolder characterViewHolder = (CharacterViewHolder)holder;
        String path = results.get(position).getThumbnail().getPath()+"."+results.get(position).getThumbnail().getExtension();
        Glide.with(characterViewHolder.itemView.getContext())
                .load(path)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .centerCrop()
                .crossFade()
                .into(characterViewHolder.characterIV);

        characterViewHolder.nameTV.setText(results.get(position).getName());

    }
/*
    private void onDoubleClick(int position, Result result) {
        notifyItemChanged(position, ACTION_LIKE_IMAGE_DOUBLE_CLICKED);
        //TODO: create a callback to save result item in db as favorite
        //callback.onLikeRecipeClick(position, result);
    }
    */


    @Override
    public int getItemCount() {
        return results.size();
    }

    public Result getItem(int position) {
        if (position != RecyclerView.NO_POSITION)
            return results.get(position);
        else
            return null;
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder{

        public TextView nameTV;
        public ImageView characterIV;
        public CardView characterCV;

        public CharacterViewHolder(View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.nameTV);
            characterIV = itemView.findViewById(R.id.characterIV);
            characterCV = itemView.findViewById(R.id.character_card);
        }
    }
}
