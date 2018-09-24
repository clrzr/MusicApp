package com.clrzr.googlealc.musicapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class AlbumGenerator extends RecyclerView.Adapter<AlbumGenerator.MyViewHolder> {

        private final Context mContext;
        private final List<AlbumDisplay> albumList;


    class MyViewHolder extends RecyclerView.ViewHolder {
            final TextView title;
            final TextView count;
            final ImageView thumbnail;
            final ImageView menu;
            final CardView cardView;


            MyViewHolder(View view) {
                super(view);
                title = view.findViewById(R.id.title);
                count =  view.findViewById(R.id.count);
                thumbnail = view.findViewById(R.id.thumbnail);
                menu =  view.findViewById(R.id.menu);
                cardView = view.findViewById(R.id.card_view);
            }
        }


         AlbumGenerator(Context mContext, List<AlbumDisplay> albumList, AlbumGeneratorListener listener) {
            this.mContext = mContext;
            this.albumList = albumList;
         }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.album_card_view, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
            final AlbumDisplay album = albumList.get(holder.getAdapterPosition());
            holder.title.setText(album.getName());
            String songsNumber = album.getNumOfSongs() + " songs";
            holder.count.setText(songsNumber);

            // Show album cover using Glide
            Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

            holder.menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showMenu(holder.menu);
                }
            });
        }

        /**
         * Showing popup menu
         */
        private void showMenu(View view) {
            // inflate menu
            PopupMenu popup = new PopupMenu(mContext, view);
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.album_menu_layout, popup.getMenu());
            popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
            popup.show();
        }

        /**
         * Click listener for popup menu items
         */
        class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

            MyMenuItemClickListener() {
            }

            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_add_favourite:
                        Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.action_play_next:
                        Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                }
                return false;
            }
        }

        @Override
        public int getItemCount() {
            return albumList.size();
        }
}