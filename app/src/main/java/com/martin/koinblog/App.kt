package com.martin.koinblog

import android.app.Application
import com.martin.koinblog.ui.factory.FactoryModel
import com.martin.koinblog.ui.main.MainModel
import com.martin.koinblog.ui.main.MainViewModel
import com.martin.koinblog.ui.mvvm.IMvvmView
import com.martin.koinblog.ui.mvvm.MvvmModel
import com.martin.koinblog.ui.mvvm.MvvmViewModel
import com.martin.koinblog.ui.single.SingleModel
import com.martin.koinblog.ui.viewmodel.VmViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.logger.AndroidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Logger
import org.koin.dsl.module

/**
 * @author：孟凡华
 * @date：2019/9/4 9:44
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        /*
            开启Koin，这里需要将所有需要注解生成的对象添加进来
         */
        startKoin {
            //给Koin框架添加ApplicationContext
            androidContext(this@App)
            /*
                这里设置Koin的日志打印
                Koin提供了三种实现:
                AndroidLogger:使用Android的Log.e/i/d()打印日志
                PrintLogger:使用System.err/out打印日志
                EmptyLogger:不打印日志，默认就是该实现
             */
            logger(AndroidLogger())
            /*
                设置Koin配置文件，需要放在assets文件夹中
                默认名称为：koin.propreties
                可以快速获取配置文件中的内容，文件名可以修改，但是需要在这里保持一致
                [getKoin().getProperty<String>("name")]
             */
            androidFileProperties("koin.properties")
            modules(
                /*
                    添加Module对象
                 */
                module {
                    /*
                        实例工厂，每次获取都是新的实例对象
                     */
                    factory { FactoryModel() }
                    /*
                        获取的实例为单例
                     */
                    single { SingleModel() }
                    single { MainModel() }
                    /*
                        获取的实例为ViewModel,并且具有ViewModel的功能
                        这里的ViewModel对象需要继承[ViewModel]
                     */
                    viewModel {
                        MainViewModel(
                            /*
                                如果构造函数中包含Koin添加的对象，则可以直接使用get()获取
                             */
                            get()
                        )
                    }
                    viewModel { VmViewModel() }
                    /*
                        这里MVVMViewModel需要传入IMvvmView对象
                        这个接口是Activity来实现的，没有办法在Koin中注明实例，所以需要以此方式
                     */
                    viewModel { (view: IMvvmView) -> MvvmViewModel(view) }
                    single { MvvmModel() }
                }
            )
        }
    }

}