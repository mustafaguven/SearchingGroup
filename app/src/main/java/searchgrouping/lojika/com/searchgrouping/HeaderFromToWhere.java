package searchgrouping.lojika.com.searchgrouping;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HeaderFromToWhere extends RelativeLayout {

  @BindView(R.id.from) TextView from;
  @BindView(R.id.to) TextView to;
  @BindView(R.id.when) TextView when;
  @BindView(R.id.time) TextView time;

  public HeaderFromToWhere(Context context, AttributeSet attrs) {
    super(context, attrs);
    View view = LayoutInflater.from(context).inflate(R.layout.component_navbar_fromtowhere, this);
    ButterKnife.bind(this, view);
  }

  public void setFrom(String from) {
    this.from.setText(from);
  }

  public void setTo(String to) {
    this.to.setText(to);
  }

  public void setWhen(String when) {
    this.when.setText(when);
  }

  public void setTime(String time) {
    this.time.setText(time);
  }
}
