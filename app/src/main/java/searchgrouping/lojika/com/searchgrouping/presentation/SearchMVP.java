package searchgrouping.lojika.com.searchgrouping.presentation;

import searchgrouping.lojika.com.searchgrouping.model.ResponseModel;

public interface SearchMVP {

  interface View {

    void onFetchResult(ResponseModel responseModel);
  }

  interface Presenter {

    void fetchResult();
  }

}
