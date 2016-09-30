package searchgrouping.lojika.com.searchgrouping.presentation.adapter;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;
import searchgrouping.lojika.com.searchgrouping.R;
import searchgrouping.lojika.com.searchgrouping.model.ItemData;

public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  List<ItemData> itemDataList;

  public SearchAdapter(List<ItemData> list) {
    this.itemDataList = list;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext())
        .inflate(R.layout.search_item, parent, false);
    return new ItemHolder(v);
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    ItemHolder itemHolder = ((ItemHolder) holder);
    ItemData itemData = itemDataList.get(position);
    itemHolder.groupName.setVisibility(View.VISIBLE);
    if (position > 0 && itemData.getGroupName()
        .contentEquals(itemDataList.get(position - 1).getGroupName())) {
      itemHolder.groupName.setVisibility(View.GONE);
    }

    itemHolder.groupName.setText(itemData.getGroupName());
    itemHolder.image.setImageResource(itemHolder.image.getContext()
        .getResources()
        .getIdentifier(itemData.getPictureId(), "drawable",
            itemHolder.image.getContext().getPackageName()));

    if (itemData.getGroupName().contentEquals("Cats")) {
      itemHolder.groupName.setBackgroundColor(
          ContextCompat.getColor(itemHolder.groupName.getContext(), R.color.green));
    } else {
      itemHolder.groupName.setBackgroundColor(
          ContextCompat.getColor(itemHolder.groupName.getContext(), R.color.gray_bg_vehicle));
    }
  }

  @Override public int getItemCount() {
    return itemDataList.size();
  }

  public class ItemHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.groupName) TextView groupName;
    @BindView(R.id.image) ImageView image;

    private ItemHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
