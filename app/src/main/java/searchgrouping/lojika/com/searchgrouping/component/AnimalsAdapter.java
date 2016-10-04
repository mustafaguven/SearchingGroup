package searchgrouping.lojika.com.searchgrouping.component;

import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import searchgrouping.lojika.com.searchgrouping.model.ItemData;

/**
 * Adapter holding a list of animal names of type String. Note that each item must be unique.
 */
public abstract class AnimalsAdapter<VH extends RecyclerView.ViewHolder>
    extends RecyclerView.Adapter<VH> {
  private List<ItemData> items = new ArrayList<>();

  public AnimalsAdapter() {
    setHasStableIds(true);
  }

  public void add(ItemData itemData) {
    items.add(itemData);
    notifyDataSetChanged();
  }

  public void add(int index, ItemData itemData) {
    items.add(index, itemData);
    notifyDataSetChanged();
  }

  public void addAll(Collection<? extends ItemData> collection) {
    if (collection != null) {
      items.addAll(collection);
      notifyDataSetChanged();
    }
  }

  public void clear() {
    items.clear();
    notifyDataSetChanged();
  }

  public void remove(String object) {
    items.remove(object);
    notifyDataSetChanged();
  }

  public ItemData getItem(int position) {
    return items.get(position);
  }

  @Override public long getItemId(int position) {
    return getItem(position).hashCode();
  }

  @Override public int getItemCount() {
    return items.size();
  }
}
