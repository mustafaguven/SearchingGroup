package searchgrouping.lojika.com.searchgrouping.model;

public class ItemData {
  String groupName;
  String pictureId;

  public ItemData(String groupName, String pictureId) {
    this.groupName = groupName;
    this.pictureId = pictureId;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getPictureId() {
    return pictureId;
  }

  public void setPictureId(String pictureId) {
    this.pictureId = pictureId;
  }
}
