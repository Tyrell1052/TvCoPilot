package com.example.tvcopilot

import android.util.Log
import androidx.paging.PagedList
import com.example.tvcopilot.TitlesBO

class ListTitlesBoundaryCallback: PagedList.BoundaryCallback<TitlesBO>() {
        private val TAG: String = "ContactsBoundaryCallback"

        override fun onZeroItemsLoaded() {
            Log.i(TAG, "onZeroItemsLoaded")
        }

        override fun onItemAtEndLoaded(itemAtEnd: TitlesBO) {
            Log.i(TAG, "onItemAtEndLoaded")
        }

        override fun onItemAtFrontLoaded(itemAtFront: TitlesBO) {
            Log.i(TAG, "onItemAtFrontLoaded")
        }

}