package searchgrouping.lojika.com.searchgrouping;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import searchgrouping.lojika.com.searchgrouping.model.ItemData;
import searchgrouping.lojika.com.searchgrouping.model.ResponseModel;
import searchgrouping.lojika.com.searchgrouping.presentation.SearchMVP;
import searchgrouping.lojika.com.searchgrouping.presentation.SearchPresenter;
import searchgrouping.lojika.com.searchgrouping.presentation.adapter.SearchAdapter;

public class SearchActivity extends AppCompatActivity implements SearchMVP.View {

  @BindView(R.id.toolbar) Toolbar toolbar;
  @BindView(R.id.groupName) TextView groupName;
  @BindView(R.id.list) RecyclerView list;
  SearchMVP.Presenter presenter;
  private String TAG = "SearchActivity";
  LinearLayoutManager linearLayoutManager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter = new SearchPresenter(this);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    generateToolbarAsActionBar(toolbar);
    initRecyclerView();
    presenter.fetchResult();
  }

  private void initRecyclerView() {
    list.setHasFixedSize(true);
    linearLayoutManager = new LinearLayoutManager(this);
    list.setLayoutManager(linearLayoutManager);
    list.setItemAnimator(new DefaultItemAnimator());
  }

  public void generateToolbarAsActionBar(Toolbar toolbar) {
    this.toolbar = toolbar;
    setSupportActionBar(this.toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);
    this.toolbar.setNavigationIcon(R.drawable.ic_navigation_back);
  }

  @Override public void onFetchResult(
      final ResponseModel responseModel
  ) {
    SearchAdapter searchAdapter = new SearchAdapter(responseModel.getItemData());
    list.setAdapter(searchAdapter);
    list.addOnScrollListener(new RecyclerView.OnScrollListener() {
      @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        Log.e(TAG, "firstVisibleItem: " + String.valueOf(firstVisibleItemPosition));
        ItemData itemData = responseModel.getItemData().get(firstVisibleItemPosition);
        groupName.setText(itemData.getGroupName());
        if (itemData.getGroupName().contentEquals("Cats")) {
          groupName.setBackgroundColor(ContextCompat.getColor(SearchActivity.this, R.color.green));
        } else {
          groupName.setBackgroundColor(
              ContextCompat.getColor(SearchActivity.this, R.color.gray_bg_vehicle));
        }

        groupName.setVisibility(firstVisibleItemPosition > 0 ? View.VISIBLE : View.GONE);
      }
    });
  }
}
