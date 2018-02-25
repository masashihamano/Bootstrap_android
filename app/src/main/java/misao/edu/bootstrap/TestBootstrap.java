package misao.edu.bootstrap;


import android.app.Application;
import com.beardedhen.androidbootstrap.TypefaceProvider;

/**
 * Created by masashihamano on 2018/02/17.
 */

public class TestBootstrap extends Application {
    @Override
    public  void onCreate() {
        super.onCreate();
        TypefaceProvider.registerDefaultIconSets();
    }
}
