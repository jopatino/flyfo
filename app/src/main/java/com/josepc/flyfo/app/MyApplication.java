package com.josepc.flyfo.app;

import android.app.Application;
import android.os.SystemClock;

import com.josepc.flyfo.models.Product;
import com.josepc.flyfo.models.ShoppingCar;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MyApplication  extends Application {

    public static AtomicInteger ShoppingCarID = new AtomicInteger();
    public static AtomicInteger ProductID = new AtomicInteger();
    @Override
    public void onCreate() {
        super.onCreate();

        SystemClock.sleep(3000);

        //Configuracion de la base de datos
        setUpRealmConfig();

        //Instanciar las tablas
        Realm realm = Realm.getDefaultInstance();
        ShoppingCarID = getIdByTable(realm, ShoppingCar.class);
        ProductID = getIdByTable(realm, Product.class);
        realm.close();

    }

    private void setUpRealmConfig(){

        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm, Class<T> anyClass){
        //Encontrar todos los resultados de una clase asignada
        RealmResults<T> results = realm.where(anyClass).findAll();

        //verifica si los resultados son mayores a 0, es decir si existen registros

        //(results.size() > 0) ? return true : return false;
        if ((results.size() > 0)) {
            new AtomicInteger(results.max("id").intValue());
        } else {
            new AtomicInteger();
        }
        return null;
    }
}
