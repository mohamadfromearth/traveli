package util;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerViewAnimator extends DefaultItemAnimator {

    @Override
    public boolean animateAdd(RecyclerView.ViewHolder holder) {
        dispatchAddFinished(holder); // this is what bypasses the animation
        return true;
    }

}
