package com.example.tvcopilot

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.android.paging.moCountry
import com.android.paging.utils.CountriesDb

class PagedTitlesDataSourse: PageKeyedDataSource<Int, Country>() {
    private val TAG: String = "PagedCountriesDataSource"
    private var source = CountriesDb.getCountries()

    fun deleteById(id: Int) {
        Log.v(TAG, "removing country by id ${id} and invalidating...")
        CountriesDb.deleteCountryById(id)
        invalidate()
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Country>
    ) {
        Log.v(TAG, "loadInitial called")
        val pagedCountries = source.filter { country -> country.page == 1}
        Log.v(TAG, "loadInitial created a list of ${pagedCountries.size} size...")

        callback.onResult(pagedCountries, null, 2)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Country>) {
        Log.v(TAG, "loadBefore called with key ${params.key}")
        val list = source.filter { country -> country.page == params.key}
        Log.v(TAG, "loadBefore returning list for page ${params.key} with ${list.size} items...")

        callback.onResult(list, params.key - 1)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Country>) {
        Log.v(TAG, "loadBefore called with key ${params.key}")
        val list = source.filter { country -> country.page == params.key}
        Log.v(TAG, "loadBefore returning list for page ${params.key} with ${list.size} items...")

        callback.onResult(list, params.key + 1)
    }
}

class PagedCountriesDataSourceFactory: DataSource.Factory<Int, Country>() {
    private val TAG: String = "PagedCountriesDataSourceFactory"

    var dataSource = MutableLiveData<PagedCountriesDataSource>()
    lateinit var latestSource: PagedCountriesDataSource

    fun deleteById(id: Int) {
        Log.v(TAG, "removing country by id ${id}...")
        latestSource.deleteById(id)
    }

    override fun create(): DataSource<Int, Country> {
        latestSource = PagedCountriesDataSource()
        dataSource.postValue(latestSource)

        return latestSource
    }
}