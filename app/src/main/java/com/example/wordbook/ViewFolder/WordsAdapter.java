package com.example.wordbook.ViewFolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wordbook.ModelFolder.WordCard;
import com.example.wordbook.R;

import java.util.ArrayList;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.ViewHolder> {

    private ArrayList<WordCard> cardList;

    @NonNull
    @Override
    public WordsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(cardList.get(position));
    }

    public void setCardList(ArrayList<WordCard> cardList) {
        this.cardList = cardList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView spelling;
        TextView meaning;
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            spelling = (TextView) itemView.findViewById(R.id.spelling_card);
            meaning = (TextView) itemView.findViewById(R.id.meaning_card);
            description = (TextView) itemView.findViewById(R.id.description_card);
        }

        void onBind(WordCard wc) {
            spelling.setText(wc.getSpelling());
            meaning.setText(wc.getMeaning());
            description.setText(wc.getDescription());
        }
    }
}
