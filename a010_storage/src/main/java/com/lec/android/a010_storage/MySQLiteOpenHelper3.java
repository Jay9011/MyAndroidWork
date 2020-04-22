package com.lec.android.a010_storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * SQLiteOpenHelper
 * 안드로이드에서 SQLite3 데이터베이스를 좀더 쉽게(?) 사용할 수 있도록 제공되는 클래스
 */
public class MySQLiteOpenHelper3 extends SQLiteOpenHelper {

    public MySQLiteOpenHelper3(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        Log.d("myapp", "SQLiteOpenHelper 생성");
    }

    /**
     * 최초에 데이터베이스가 '없는 경우' 데이터베이스 생성을 위해 호출되는 콜백
     * 주로 DDL 등 테이블 생성하는 코드 작성
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("myapp", "SQLiteOpenHelper] onCreate() 호출");

        String sql = "CREATE TABLE mytable (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT" +
                ")";

        db.execSQL(sql);

    }

    /**
     *  데이터베이스의 '버전' 이 바뀌었을 때 호출되는 콜백 메소드
     *  '버전'이 바뀌었을 때 기존에 설치 운영되고 있는 데이터베이스를 어떻게 변경할 것인지 작성
     *  각 버전의 변경 내용들을 버전마다 작성해야 함.
     * @param db
     * @param oldVersion    기존의 버전
     * @param newVersion    새로운 버전
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("myapp", "SQLiteOpenHelper] onUpgrade 호출 : " + oldVersion + "-->" + newVersion);

        String sql = "DROP TABLE mytable";  // 기존 테이블 삭제
        db.execSQL(sql);
        onCreate(db);   // 다시 테이블 생성
    }


}
