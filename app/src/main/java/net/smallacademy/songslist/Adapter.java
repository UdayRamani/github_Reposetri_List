package net.smallacademy.songslist;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;

    List<User> users;

    Context context;
    public Adapter(Context ctx, List<User> users){
        this.context = ctx;
        this.inflater = LayoutInflater.from(ctx);
        this.users = users;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_list_layout,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        // bind the data
        final User user=users.get(position);
        holder.usertitle.setText(user.getName());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(view.getContext(),contain.class);
                i.putExtra("name",user.getName());
                i.putExtra("git_url",user.getGitUrl());
                i.putExtra("Date",user.getCreatedAt());
                i.putExtra("uDate",user.getUpdatedAt());
                i.putExtra("login",user.getFullName());

                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(i);

            }
        });
    }
    @Override
    public int getItemCount() {
        return users.size();
    }
    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView usertitle;
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            usertitle = itemView.findViewById(R.id.songTitle);
           // songArtists = itemView.findViewById(R.id.Authorsname1);

            relativeLayout=itemView.findViewById(R.id.relative);
            // handle onClick
        }
    }
}
