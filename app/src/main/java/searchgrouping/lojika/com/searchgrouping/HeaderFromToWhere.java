package searchgrouping.lojika.com.searchgrouping;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HeaderFromToWhere extends RelativeLayout {

  TextView from;
  TextView to;
  TextView when;
  TextView time;

  public HeaderFromToWhere(Context context, AttributeSet attrs) {

    super(context, attrs);

    LayoutInflater inflater =
        (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    inflater.inflate(R.layout.component_navbar_fromtowhere, this);

    from = (TextView) findViewById(R.id.from);
    to = (TextView) findViewById(R.id.to);
    when = (TextView) findViewById(R.id.when);
    time = (TextView) findViewById(R.id.time);
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
