package id.blank15.tukangbakso;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by blank15 on 06/04/2018.
 */

public class RecylerviewAdapter extends RecyclerView.Adapter<RecylerviewAdapter.Holder> {

    Context context;

    public RecylerviewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecylerviewAdapter.Holder(LayoutInflater.from(context).inflate(R.layout.list_bakso,parent,false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public class Holder extends RecyclerView.ViewHolder {

        public Holder(View itemView) {
            super(itemView);
        }
    }
}
