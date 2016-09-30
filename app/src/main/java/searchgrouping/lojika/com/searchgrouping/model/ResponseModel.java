package searchgrouping.lojika.com.searchgrouping.model;

import java.util.List;

public class ResponseModel {
  public List<ItemData> getItemData() {
    return itemData;
  }

  public void setItemData(List<ItemData> itemData) {
    this.itemData = itemData;
  }

  private List<ItemData> itemData;


}
