package com.hanamin.alaa.ui.viewmodel

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanamin.alaa.data.db.room.HomeDatabase
import com.hanamin.alaa.data.remote.responce.Sets
import com.hanamin.alaa.network.api.NetworkApi
import com.hanamin.alaa.ui.view.adapters.ListAdapter
import com.hanamin.alaa.utils.ConnectionChecker
import com.hanamin.alaa.utils.extensions.default
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber


class HomeVm @ViewModelInject constructor(
    private val networkApi: NetworkApi,
    private val database: HomeDatabase,
    @ActivityContext private val context: Context
) : ViewModel() {

    var loading = MutableLiveData<Boolean>().default(false)
    var message = MutableLiveData<String>().default("")
    var checkList = MutableLiveData<Boolean>().default(false)
    var adapterList = MutableLiveData<ListAdapter>().default(ListAdapter(mutableListOf()))

    init {
        getListFav()
    }

    fun getListFav() {
        loading.value = true

        if (ConnectionChecker.isInternetAvailable(context)) {
            viewModelScope.launch {
                try {
                    val responce = networkApi.getHomeList()
                    handleListResponse(responce.data[1]?.sets!!)
                } catch (t: Throwable) {
                    handleError(t)
                }
            }
        } else {
            loading.value = false
            GlobalScope.launch(Dispatchers.Main) {
                val list = withContext(Dispatchers.IO) {
                    database.homeDao().getList()
                }
                if (list.isNullOrEmpty()) {
                    checkList.value = true
                    message.value = "لیست خالی است!"
                } else {
                    checkList.value = false
                    adapterList.value?.addNewItems(list)
                }
            }
        }

    }

    private fun handleListResponse(response: MutableList<Sets?>) {
        loading.value = false

        if (response.size == 0) {
            checkList.value = true
            message.value = "لیست خالی است!"
        } else {
            checkList.value = false
            adapterList.value?.addNewItems(response)
            GlobalScope.launch(Dispatchers.Main) {
                withContext(Dispatchers.IO) {
                    database.homeDao().insertList(response)
                }
            }
        }

    }

    private fun handleError(t: Throwable) {
        loading.value = false
        checkList.value = true
        message.value = "خطا در برقراری ارتباط"
        Timber.e(t)
    }

}

