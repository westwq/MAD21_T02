package sg.edu.np.mad.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder{
    public TextView name;
    public TextView age;
    public View view;

    public UserViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.txtName);
        age = itemView.findViewById(R.id.txtAge);
        view = itemView;
    }
}
