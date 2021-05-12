package sg.edu.np.mad.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UserViewHolder>{
    Context context;
    ArrayList<User> data;

    public UsersAdapter(Context c, ArrayList<User> d)
    {
        context = c;
        data = d;
    }

    //Mandatory to overwrite
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;

        if(viewType == 0) //multiplies of three
        {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_user_right, parent, false);
        }
        else
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_user, parent, false);

        Log.d("RV", "On Create View Holder");
        return new UserViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Log.d("RV","onBindViewHolder #" + position);
        User u = data.get(position);

        holder.name.setText(u.getName());
        holder.age.setText("" + u.getAge());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View alertView = LayoutInflater.from(context).inflate(R.layout.alert_delete, null);

                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setTitle("hello")
                        .setView(alertView)
                        .setCancelable(true)
                        .show();

                Intent i = new Intent(context, MainActivity2.class);
                i.putExtra("userInput", u.getName());
                //context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    //<--- end


    @Override
    public int getItemViewType(int position) {
        if(data.get(position).getAge() % 3 == 0)
            return 0;
        return 1;
    }
}
