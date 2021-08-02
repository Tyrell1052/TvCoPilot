package com.example.tvcopilot

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList

class SuggestionsActivityViewModel(db: ListTitlesBO): ViewModel() {

        val pageSize = 15
        var config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(15)
            .setPrefetchDistance(5)
            .setEnablePlaceholders(false)
            .build()
        var dataSource = ListTitlesBO

        var contacts: LiveData<PagedList<TitlesBO>> = dataSource.getContacts()
            .toLiveData(config,
                null,
                ListTitlesBoundaryCallback()
            )
}