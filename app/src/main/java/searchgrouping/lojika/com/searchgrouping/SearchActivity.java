package searchgrouping.lojika.com.searchgrouping;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;
import java.security.SecureRandom;
import searchgrouping.lojika.com.searchgrouping.component.AnimalsAdapter;
import searchgrouping.lojika.com.searchgrouping.model.ResponseModel;
import searchgrouping.lojika.com.searchgrouping.presentation.SearchMVP;
import searchgrouping.lojika.com.searchgrouping.presentation.SearchPresenter;

public class SearchActivity extends AppCompatActivity implements SearchMVP.View {

  @BindView(R.id.toolbar) Toolbar toolbar;
  @BindView(R.id.list) RecyclerView recyclerView;
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
    recyclerView.setHasFixedSize(true);
    linearLayoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(linearLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
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
      ResponseModel responseModel
  ) {
    final AnimalsHeadersAdapter adapter = new AnimalsHeadersAdapter();
    adapter.addAll(responseModel.getItemData());
    recyclerView.setAdapter(adapter);

    final StickyRecyclerHeadersDecoration headersDecor =
        new StickyRecyclerHeadersDecoration(adapter);
    recyclerView.addItemDecoration(headersDecor);
  }

  private class AnimalsHeadersAdapter extends AnimalsAdapter<RecyclerView.ViewHolder>
      implements StickyRecyclerHeadersAdapter<RecyclerView.ViewHolder> {
    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view =
          LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false);
      return new RecyclerView.ViewHolder(view) {
      };
    }

    @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
      TextView textView = (TextView) holder.itemView;
      textView.setText(getItem(position).getPictureId());
    }

    @Override public long getHeaderId(int position) {
      /*
      if (position == 0) {
        return -1;
      } else {
        return getItem(position).getGroupName().charAt(0);
      }
      */

      return getItem(position).getGroupName().charAt(0);
    }

    @Override public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
      View view =
          LayoutInflater.from(parent.getContext()).inflate(R.layout.view_header, parent, false);
      return new RecyclerView.ViewHolder(view) {
      };
    }

    @Override public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
      TextView textView = (TextView) holder.itemView;
      textView.setText(String.valueOf(getItem(position).getGroupName()));
      holder.itemView.setBackgroundColor(getRandomColor());
    }

    private int getRandomColor() {
      SecureRandom rgen = new SecureRandom();
      return Color.HSVToColor(150, new float[] {
          rgen.nextInt(359), 1, 1
      });
    }
  }
}
