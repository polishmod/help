package pl.mil.wp.help.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.mil.wp.help.R;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ViewHolder> {

    private List<Pair<String, Integer>> titles;

    ArticlesAdapter(List<Pair<String, Integer>> titles) {
        this.titles = new ArrayList<>(titles);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArticlesAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.row_article_dashboard, parent, false
        ));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (!titles.isEmpty()) {
            holder.title.setText(titles.get(position).first);
            Glide.with(holder.itemView.getContext()).load(titles.get(position).second).fitCenter()
                    .into(holder.image);

        }
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.iv_article)
        ImageView image;

        ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}
