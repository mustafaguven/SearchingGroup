package searchgrouping.lojika.com.searchgrouping.component;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import java.util.List;

public class MyRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private List<T> list;

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return null;
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

  }

  @Override public int getItemCount() {
    return list.size();
  }
}
