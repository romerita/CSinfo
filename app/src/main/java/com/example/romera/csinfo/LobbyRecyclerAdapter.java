package com.example.romera.csinfo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class LobbyRecyclerAdapter extends RecyclerView.Adapter<LobbyRecyclerAdapter.LobbyViewHolder>{

    List<Lobby> list;

    LobbyRecyclerAdapter(List<Lobby> list){
        this.list = list;
    }

    @Override
    public LobbyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLobby = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lobby, parent, false);
        return new LobbyViewHolder(itemLobby);
    }

    @Override
    public void onBindViewHolder(LobbyViewHolder holder, int position) {
        Lobby lobby = list.get(position);

        holder.lobbyTitle.setText(lobby.title);
        holder.lobbyPlayer.setText(lobby.player);
    }

    @Override
    public int getItemCount() {
        return (list != null ? list.size() : 0);
    }

    class LobbyViewHolder extends RecyclerView.ViewHolder {
        private TextView lobbyTitle;
        private TextView lobbyPlayer;

        LobbyViewHolder(View itemLobby) {
            super(itemLobby);
            lobbyTitle = itemLobby.findViewById(R.id.lobby_title);
            lobbyPlayer = itemLobby.findViewById(R.id.lobby_player);
        }
    }
}
