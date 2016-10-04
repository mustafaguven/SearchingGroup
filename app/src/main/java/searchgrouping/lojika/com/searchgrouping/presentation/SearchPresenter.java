package searchgrouping.lojika.com.searchgrouping.presentation;

import java.util.ArrayList;
import java.util.List;
import searchgrouping.lojika.com.searchgrouping.model.ItemData;
import searchgrouping.lojika.com.searchgrouping.model.ResponseModel;

public class SearchPresenter implements SearchMVP.Presenter {

  SearchMVP.View view;

  public SearchPresenter(SearchMVP.View view) {
    this.view = view;
  }

  @Override public void fetchResult() {
    ResponseModel responseModel = new ResponseModel();
    List<ItemData> itemDataList = new ArrayList<>();
    itemDataList.add(new ItemData("Cats", "pic_2"));
    itemDataList.add(new ItemData("Cats", "pic_3"));
    itemDataList.add(new ItemData("Cats", "pic_3"));
    itemDataList.add(new ItemData("Cats", "pic_3"));
    itemDataList.add(new ItemData("Cats", "pic_3"));
    itemDataList.add(new ItemData("Cats", "pic_3"));
    itemDataList.add(new ItemData("Cats", "pic_3"));
    itemDataList.add(new ItemData("Cats", "pic_3"));
    itemDataList.add(new ItemData("Cats", "pic_3"));
    itemDataList.add(new ItemData("Cats", "pic_3"));
    itemDataList.add(new ItemData("Cats", "pic_3"));
    itemDataList.add(new ItemData("Cats", "pic_3"));
    itemDataList.add(new ItemData("Cats", "pic_3"));
    itemDataList.add(new ItemData("Cats", "pic_3"));
    itemDataList.add(new ItemData("Cats", "pic_3"));
    itemDataList.add(new ItemData("Cats", "pic_3"));
    itemDataList.add(new ItemData("Cats", "pic_3"));
    itemDataList.add(new ItemData("Cats", "pic_3"));
    itemDataList.add(new ItemData("Cats", "pic_3"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_4"));
    itemDataList.add(new ItemData("Dogs", "pic_1"));
    itemDataList.add(new ItemData("Squirrels", "pic_5"));
    itemDataList.add(new ItemData("Squirrels", "pic_6"));
    itemDataList.add(new ItemData("Squirrels", "pic_6"));
    itemDataList.add(new ItemData("Squirrels", "pic_6"));
    itemDataList.add(new ItemData("Squirrels", "pic_6"));
    itemDataList.add(new ItemData("Squirrels", "pic_6"));
    itemDataList.add(new ItemData("Squirrels", "pic_6"));
    itemDataList.add(new ItemData("Squirrels", "pic_6"));
    itemDataList.add(new ItemData("Squirrels", "pic_6"));
    itemDataList.add(new ItemData("Squirrels", "pic_6"));
    itemDataList.add(new ItemData("Squirrels", "pic_6"));
    itemDataList.add(new ItemData("Squirrels", "pic_6"));
    itemDataList.add(new ItemData("Squirrels", "pic_6"));
    responseModel.setItemData(itemDataList);
    view.onFetchResult(responseModel);
  }
}
