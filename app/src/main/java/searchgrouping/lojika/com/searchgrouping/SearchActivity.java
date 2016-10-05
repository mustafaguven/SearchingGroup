package searchgrouping.lojika.com.searchgrouping;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import butterknife.BindDimen;
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
  @BindDimen(R.dimen.results_header_height) int headerHeight;
  @BindDimen(R.dimen.group_name_header_height) int groupNameHeaderHeight;
  SearchMVP.Presenter presenter;
  private String TAG = "SearchActivity";
  LinearLayoutManager linearLayoutManager;
  private int totalScrolled = 0;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter = new SearchPresenter(this);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    generateToolbarAsActionBar(toolbar);
    initRecyclerView();
    arrangeViews();
    presenter.fetchResult();
  }

  private void arrangeViews() {
    groupName.setTranslationY(-groupNameHeaderHeight);
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
        totalScrolled += dy;

        //Log.e(TAG, String.valueOf(groupName.getY()));

        int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        //Log.e(TAG, "firstVisibleItem: " + String.valueOf(firstVisibleItemPosition));
        ItemData itemData = responseModel.getItemData().get(firstVisibleItemPosition);
        groupName.setText(itemData.getGroupName());
        if (itemData.getGroupName().contentEquals("Cats")) {
          groupName.setBackgroundColor(ContextCompat.getColor(SearchActivity.this, R.color.green));
        } else {
          groupName.setBackgroundColor(
              ContextCompat.getColor(SearchActivity.this, R.color.gray_bg_vehicle));
        }

        translateGroupName(totalScrolled);
        //getVisiblePercantageOfHeaderHeight(totalScrolled);
        //groupName.setVisibility(firstVisibleItemPosition > 0 ? View.VISIBLE : View.GONE);
      }
    });
  }

  private void translateGroupName(int totalScrolled) {

    int percentage = getVisiblePercantageOfHeaderHeight(totalScrolled);
    float factor = percentage * 0.01f;
    //Log.e(TAG, String.valueOf(percentage * 0.02f));
    groupName.setTranslationY(
        (groupNameHeaderHeight * -1) + groupNameHeaderHeight - (groupNameHeaderHeight * factor));
    Log.e(TAG, String.valueOf(
        groupNameHeaderHeight * -1 + groupNameHeaderHeight - (groupNameHeaderHeight * factor)));
  }

  private int getVisiblePercantageOfHeaderHeight(int totalScrolled) {
    int delta = headerHeight - totalScrolled;
    int percantage = Math.max(delta * 100 / headerHeight, 0);

    //Log.e(TAG, String.valueOf(percantage));
    return percantage;
  }
}
