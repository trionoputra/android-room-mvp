package id.tentangdeveloper.googleroommvp.activity.list.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.tentangdeveloper.googleroommvp.activity.detail.UserDetailActivity;
import id.tentangdeveloper.googleroommvp.database.entity.User;
import id.tentangdeveloper.googleroommvp.databinding.UserListItemBinding;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private List<User> data = new ArrayList<>();
    private Context context;
    public UserListAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(UserListItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.ViewHolder holder, int position) {
        User user = data.get(position);
        holder.textName.setText(user.name);
        holder.textEmail.setText(user.email);
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(context, UserDetailActivity.class);
            intent.putExtra("UserId",user.id);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textName;
        private final TextView textEmail;
        private final CardView cardView;
        public ViewHolder(UserListItemBinding binding) {
            super(binding.getRoot());
            textName = binding.textName;
            textEmail = binding.textEmail;
            cardView = binding.cardView;
        }
    }

    public void setData(List<User> userList){
        this.data = userList;
        notifyDataSetChanged();
    }

}
