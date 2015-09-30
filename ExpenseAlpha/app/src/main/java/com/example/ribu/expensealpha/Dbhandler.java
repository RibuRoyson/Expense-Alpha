package com.example.ribu.expensealpha;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import android.util.Log;
import android.widget.Toast;


import com.example.ribu.expensealpha.details;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ribu on 24-Sep-15.
 */
public class Dbhandler extends SQLiteOpenHelper {
    public static final String DB_name = "expensedb";
    public static final String TB_name = "myexp";
    public String deleted;
    SQLiteDatabase db;
    Context context;


    public Dbhandler(Context context) {
        super(context, DB_name, null, 32);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("create table if not exists " + TB_name + "(id integer primary key autoincrement,expense integer,cat text,description text,time text,date text,day integer,month integer,year integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
        db.execSQL("drop table if exists " + TB_name);
        onCreate(db);
    }

    public long insertdata(details d) {
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("expense", d.getExpense());
        cv.put("cat", d.getCat());
        cv.put("description", d.getDescription());
        cv.put("time", d.getTime1());
        cv.put("date", d.getDate1());
        cv.put("day", d.getDy());
        cv.put("month", d.getMn());
        cv.put("year", d.getYr());
        return db.insert(TB_name, null, cv);
    }

    public ArrayList<String> resultiddb() {
        int id = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> iddb = new ArrayList<String>();

        try {
            Cursor c = null;
            c = db.rawQuery("select * from " + TB_name, null);
            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        int cc = c.getColumnCount();
                        if (cc < 0) {
                            return null;
                        } else {
                            id = c.getInt(c.getColumnIndex("id"));
                            iddb.add(String.valueOf(id));
                        }

                    } while (c.moveToNext());
                }

                c.close();
                db.close();

            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_SHORT).show();

            }
        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "Could not connect");

        }
        return iddb;
    }

    public int resultid1() {
        int id = 0;
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor c = null;
            c = db.rawQuery("select * from " + TB_name, null);
            if (c != null) {
                String exp = null;

                if (c.moveToLast()) {
                    do {
                        int cc = c.getCount();
                        id = c.getInt(c.getColumnIndex("id"));


                    } while (c.moveToNext());

                }


                c.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
        } catch (SQLiteException se) {

        }
        return id;
    }

    public String resultexp() {
        SQLiteDatabase db = this.getReadableDatabase();
        String exp = null;
        try {
            Cursor c = null;
            c = db.rawQuery("select * from " + TB_name, null);
            if (c != null) {
                exp = null;
                String id = null;
                if (c.moveToFirst()) {
                    do {
                        int cc = c.getCount();
                        exp = c.getString(c.getColumnIndex("expense"));
                    } while (c.moveToNext());
                }


                c.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return exp;
    }

    public String resultcat() {

        SQLiteDatabase db = this.getReadableDatabase();
        String cat = null;
        try {
            Cursor c = null;
            c = db.rawQuery("select * from " + TB_name, null);
            if (c != null) {
                String exp = null;
                String id = null;
                cat = null;
                if (c.moveToFirst()) {
                    do {
                        cat = c.getString(c.getColumnIndex("cat"));
                    } while (c.moveToNext());
                }


                c.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return cat;
    }

    public String resultdesc() {
        SQLiteDatabase db = this.getReadableDatabase();
        String des = null;
        try {
            Cursor c = null;
            c = db.rawQuery("select * from " + TB_name, null);
            if (c != null) {
                String exp = null;
                String id = null;
                des = null;
                if (c.moveToFirst()) {
                    do {
                        int cc = c.getCount();
                        des = c.getString(c.getColumnIndex("description"));
                    } while (c.moveToNext());
                }


                c.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return des;
    }

    public String resulttime() {
        SQLiteDatabase db = this.getReadableDatabase();
        String tim = null;
        try {
            Cursor c = null;
            c = db.rawQuery("select * from " + TB_name, null);
            if (c != null) {
                String exp = null;
                String id = null;
                tim = null;
                if (c.moveToFirst()) {
                    do {
                        int cc = c.getCount();
                        tim = c.getString(c.getColumnIndex("time"));

                    } while (c.moveToNext());
                }


                c.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return tim;
    }

    public String resultdate() {
        SQLiteDatabase db = this.getReadableDatabase();
        String dat = null;
        try {
            Cursor c = null;
            c = db.rawQuery("select * from " + TB_name, null);
            if (c != null) {
                String exp = null;
                String id = null;
                dat = null;
                if (c.moveToFirst()) {
                    do {
                        int cc = c.getCount();

                        dat = c.getString(c.getColumnIndex("date"));


                    } while (c.moveToNext());
                }


                c.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return dat;
    }


    public ArrayList<details> resultdata() {
        ArrayList<details> results = new ArrayList<details>();

        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor c = null;
            c = db.rawQuery("select * from " + TB_name, null);
            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        int cc = c.getCount();
                        String exp = c.getString(c.getColumnIndex("expense"));
                        String cat = c.getString(c.getColumnIndex("cat"));
                        String des = c.getString(c.getColumnIndex("description"));
                        String tim = c.getString(c.getColumnIndex("time"));
                        String dat = c.getString(c.getColumnIndex("date"));
                        String id = c.getString(c.getColumnIndex("id"));
                        int d = c.getInt(c.getColumnIndex("day"));
                        int m = c.getInt(c.getColumnIndex("month"));
                        int y = c.getInt(c.getColumnIndex("year"));
                        results.add(new details(id, exp, cat, des, tim, dat, d, m, y));

                    } while (c.moveToNext());
                }
                c.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return results;
    }

    public int total() {
        int exp = 0;
        db = this.getReadableDatabase();
        try {
            Cursor d;
            Log.e("TOTAL", "reached");
            d = db.rawQuery("select expense from " + TB_name, null);

            if (d != null) {
                if (d.moveToFirst())
                {
                    do {
                        int x = d.getInt(d.getColumnIndex("expense"));
                        exp = exp + x;

                    }
                    while (d.moveToNext());
                }
                d.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();

            }

        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return exp;

    }

    public int totalmnth() {
        int exp = 0;
        db = this.getReadableDatabase();
        try {
            Cursor d = null;
            final Calendar ye = Calendar.getInstance();
            int mYear = Integer.parseInt(String.valueOf(ye.get(Calendar.YEAR)));
            int val =  ye.get(Calendar.MONTH);
            val=val + 1;
            System.out.println("Year:--------------" + mYear + "Month:------------" + val);
            d = db.rawQuery("select * from " + TB_name + " where month = '" + val + "' and year = '" + mYear + "' ", null);
            if (d != null) {
                if (d.moveToFirst()) ;
                {
                    do {
                        int cc = d.getCount();
                        if (cc < 1) {
                            return 0;
                        }
                        int z = d.getInt(d.getColumnIndex("expense"));
                        exp = exp + z;

                    }
                    while (d.moveToNext());
                }
                d.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();

            }

        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return exp;
    }

    public void updateDetails(details d, String id1) {
        if (Integer.parseInt(id1) >= 0) {
            db = getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("expense", d.getExpense());
            cv.put("cat", d.getCat());
            cv.put("description", d.getDescription());
            cv.put("time", d.getTime1());
            cv.put("date", d.getDate1());
            String where = "id=?";
            String[] whereArgs = {id1};
            db.update(TB_name, cv, where, whereArgs);
        } else {
            insertdata(d);
        }
    }

    public void deletedetails(String idd) {
        Cursor c = null;
        db = getWritableDatabase();
        deleted = "false";
        String[] columns = {"expense", "cat", "description", "time", "date"};
        String selection = "id=?";
        String[] selectionArgs = {idd};
        c = db.query(TB_name, columns, selection, selectionArgs, null, null, null);
        if (c != null) {
            if (c.moveToFirst()) {
                String where = "id=?";
                String[] args = {idd};
                db.delete(TB_name, where, args);
                deleted = "true";
            } else {
                deleted = "false";
            }


        } else {
            deleted = "false";
        }
    }

    public ArrayList<details> category(String ca) {
        ArrayList<details> results = new ArrayList<details>();
        db = this.getReadableDatabase();
        try {
            Cursor c = null;
            String[] columns = {"id", "expense", "cat", "description", "time", "date", "day", "month", "year"};
            String selection = "cat=?";
            String[] selectionArgs = {ca};
            Log.v("selection", selection);

            c = db.query(TB_name, columns, selection, selectionArgs, null, null, null);
            if (c != null)

            {
                if (c.moveToFirst()) ;
                {
                    do {
                        int cc = c.getCount();
                        if (cc < 1) {
                            return null;
                        }
                        String exp = c.getString(c.getColumnIndex("expense"));
                        String cat = c.getString(c.getColumnIndex("cat"));
                        String des = c.getString(c.getColumnIndex("description"));
                        String tim = c.getString(c.getColumnIndex("time"));
                        String dat = c.getString(c.getColumnIndex("date"));
                        String id = c.getString(c.getColumnIndex("id"));
                        int d = c.getInt(c.getColumnIndex("day"));
                        int m = c.getInt(c.getColumnIndex("month"));
                        int y = c.getInt(c.getColumnIndex("year"));
                        results.add(new details(id, exp, cat, des, tim, dat, d, m, y));
                    } while (c.moveToNext());
                }
                c.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();

            }

        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return results;
    }

    public int currentcategory(String ab) {
        int ex = 0;
        db = this.getReadableDatabase();
        try {
            int y = 0;
            final Calendar c = Calendar.getInstance();
            String mYear = String.valueOf(c.get(Calendar.YEAR));
            int mMonth = (c.get(Calendar.MONTH));
            String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
            y = mMonth + 1;
            String mon = String.valueOf(y);
            StringBuffer sb = new StringBuffer();
            String s = String.valueOf(sb.append(mDay).append("-").append(mon).append("-").append(mYear));

            String abc = "Drinks";
            if (ab.equals(abc)) {
                Log.e(abc, "match");
            }
            Cursor d = null;
            d = db.rawQuery("select expense from " + TB_name + " where cat='" + ab + "' and month =" + y, null);

            if (d != null) {
                if (d.moveToFirst()) {
                    do {
                        int cc = d.getCount();
                        if (cc < 1) {
                            return 0;
                        }
                        int z = d.getInt(d.getColumnIndex("expense"));
                        ex = ex + z;

                    }
                    while (d.moveToNext());
                }
                d.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();

            }

        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");

        }
        return ex;
    }

    public int todaycategory(String ab) {
        int ex = 0;
        db = this.getReadableDatabase();
        try {
            int y = 0;
            final Calendar c = Calendar.getInstance();
            String mYear = String.valueOf(c.get(Calendar.YEAR));
            int mMonth = (c.get(Calendar.MONTH));
            String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
            y = mMonth + 1;
            String mon = String.valueOf(y);
            StringBuffer sb = new StringBuffer();
            String s = String.valueOf(sb.append(mDay).append("-").append(mon).append("-").append(mYear));
            Log.e(s, "Current Date");
            int mDate = c.get(Calendar.DATE);
            Cursor d = null;

            d = db.rawQuery("select expense from " + TB_name + " where cat='" + ab + "' and date = '" + s + "' ", null);
            if (d != null) {
                if (d.moveToFirst()) {
                    do {
                        int cc = d.getCount();
                        if (cc < 1) {
                            return 0;
                        }
                        int z = d.getInt(d.getColumnIndex("expense"));
                        ex = ex + z;

                    }
                    while (d.moveToNext());
                }
                d.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();

            }

        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");

        }
        return ex;
    }
    public ArrayList<details> monthdata(int x) {
        ArrayList<details> results = new ArrayList<>();
        db = this.getReadableDatabase();
        try {
            Cursor c = null;
            final Calendar ye = Calendar.getInstance();
            int mYear = Integer.parseInt(String.valueOf(ye.get(Calendar.YEAR)));
            String val = String.valueOf(x).toString();
            System.out.println("Year:--------------"+mYear+"Month:------------"+val);
            c = db.rawQuery("select * from " + TB_name + " where month = '" + val + "' and year = '" + mYear + "' ", null);
            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        String exp = c.getString(c.getColumnIndex("expense"));
                        String cat = c.getString(c.getColumnIndex("cat"));
                        String des = c.getString(c.getColumnIndex("description"));
                        String tim = c.getString(c.getColumnIndex("time"));
                        String dat = c.getString(c.getColumnIndex("date"));
                        String id = c.getString(c.getColumnIndex("id"));
                        int d = c.getInt(c.getColumnIndex("day"));
                        int m = c.getInt(c.getColumnIndex("month"));
                        int y = c.getInt(c.getColumnIndex("year"));
                        results.add(new details(id, exp, cat, des, tim, dat, d, m, y));
                    } while (c.moveToNext());
                }
                c.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return results;
    }

    public int categorytotal(String ca) {
        int exp = 0;
        db = this.getReadableDatabase();
        try {
            Cursor d = null;
            String[] columns = {"id", "expense", "cat", "description", "time", "date", "day", "month", "year"};
            String selection = "cat=?";
            String[] selectionArgs = {ca};
            Log.v("selection", selection);

            d = db.query(TB_name, columns, selection, selectionArgs, null, null, null);
            if (d != null) {
                if (d.moveToFirst()) ;
                {
                    do {
                        int cc = d.getCount();
                        if (cc < 1) {
                            return 0;
                        }
                        int z = d.getInt(d.getColumnIndex("expense"));
                        exp = exp + z;

                    }
                    while (d.moveToNext());
                }

            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();

            }

        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return exp;
    }

    public ArrayList<details> monthWiseData(int x) {
        ArrayList<details> results = new ArrayList<>();
        db = this.getReadableDatabase();
        try {
            Cursor c = null;
            String val = String.valueOf(x).toString();
            Log.e("monthvalue", val);
            String[] columns = {"id", "expense", "cat", "description", "time", "date", "day", "month", "year"};
            String selection = "month=?";
            String[] selectionArgs = {val};
            c = db.query(TB_name, columns, selection, selectionArgs, null, null, null);
            Log.e("cursor", "" + c);
            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        String exp = c.getString(c.getColumnIndex("expense"));
                        String cat = c.getString(c.getColumnIndex("cat"));
                        String des = c.getString(c.getColumnIndex("description"));
                        String tim = c.getString(c.getColumnIndex("time"));
                        String dat = c.getString(c.getColumnIndex("date"));
                        String id = c.getString(c.getColumnIndex("id"));
                        int d = c.getInt(c.getColumnIndex("day"));
                        int m = c.getInt(c.getColumnIndex("month"));
                        int y = c.getInt(c.getColumnIndex("year"));
                        results.add(new details(id, exp, cat, des, tim, dat, d, m, y));
                    } while (c.moveToNext());
                }
                c.close();
                db.close();
            } else {
                Toast.makeText(context, "data no found", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;

    }

    public int monthtotal(int a) {
        int exp = 0;
        db = this.getReadableDatabase();
        try {
            String val = String.valueOf(a).toString();
            Cursor d = null;
            String[] columns = {"id", "expense", "cat", "description", "time", "date", "day", "month", "year"};
            String selection = "month=?";
            String[] selectionArgs = {val};
            Log.v("selection", selection);

            d = db.query(TB_name, columns, selection, selectionArgs, null, null, null);

            if (d != null) {
                if (d.moveToFirst()) ;
                {
                    do {
                        int cc = d.getCount();
                        if (cc < 1) {
                            return 0;
                        }
                        int z = d.getInt(d.getColumnIndex("expense"));
                        exp = exp + z;

                    }
                    while (d.moveToNext());
                }
                d.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();

            }

        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return exp;

    }
    public int monthdatatotal(int x) {
        int exp = 0;
        db = this.getReadableDatabase();
        try {
            Cursor d = null;
            final Calendar ye = Calendar.getInstance();
            int mYear = Integer.parseInt(String.valueOf(ye.get(Calendar.YEAR)));
            String val = String.valueOf(x).toString();
            System.out.println("Year:--------------" + mYear + "Month:------------" + val);
            d = db.rawQuery("select * from " + TB_name + " where month = '" + val + "' and year = '" + mYear + "' ", null);
            if (d != null) {
                if (d.moveToFirst()) ;
                {
                    do {
                        int cc = d.getCount();
                        if (cc < 1) {
                            return 0;
                        }
                        int z = d.getInt(d.getColumnIndex("expense"));
                        exp = exp + z;

                    }
                    while (d.moveToNext());
                }
                d.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();

            }

        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return exp;

    }

    public ArrayList<Integer> monthwise() {
        ArrayList<Integer> data = new ArrayList<Integer>();
        db = this.getReadableDatabase();
        try {
            int expa = 0;
            Cursor a = null;
            a = db.rawQuery("select * from " + TB_name + " where month=1 ", null);
            if (a != null) {
                if (a.moveToFirst()) {
                    do {
                        int a1 = a.getCount();
                        if (a1 < 1) {
                            return null;
                        }
                        int x = a.getInt(a.getColumnIndex("expense"));
                        expa = expa + x;
                    } while (a.moveToNext());
                    data.add(expa);
                }

            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
            int expb = 0;
            Cursor b = null;
            b = db.rawQuery("select * from " + TB_name + " where month=2 ", null);
            if (b != null) {
                if (b.moveToFirst()) {
                    do {
                        int a1 = b.getCount();
                        if (a1 < 1) {
                            return null;
                        }
                        int x = b.getInt(b.getColumnIndex("expense"));
                        expb = expb + x;
                    } while (b.moveToNext());
                    data.add(expb);
                }

            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
            Cursor c = null;
            int expc = 0;
            c = db.rawQuery("select * from " + TB_name + " where month=3 ", null);
            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        int a1 = c.getCount();
                        if (a1 < 1) {
                            return null;
                        }
                        int x = c.getInt(c.getColumnIndex("expense"));
                        expc = expc + x;
                    } while (c.moveToNext());
                    data.add(expc);
                }

            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
            int expd = 0;
            Cursor d = null;
            d = db.rawQuery("select * from " + TB_name + " where month=4 ", null);
            if (d != null) {
                if (d.moveToFirst()) {
                    do {
                        int a1 = d.getCount();
                        if (a1 < 1) {
                            return null;
                        }
                        int x = d.getInt(d.getColumnIndex("expense"));
                        expd = expd + x;
                    } while (d.moveToNext());
                    data.add(expd);
                }

            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
            int expe = 0;
            Cursor e = null;
            e = db.rawQuery("select * from " + TB_name + " where month=5 ", null);
            if (e != null) {
                if (e.moveToFirst()) {
                    do {
                        int a1 = e.getCount();
                        if (a1 < 1) {
                            return null;
                        }
                        int x = e.getInt(e.getColumnIndex("expense"));
                        expe = expe + x;
                    } while (e.moveToNext());
                    data.add(expe);
                }
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
            int expf = 0;
            Cursor f = null;
            f = db.rawQuery("select * from " + TB_name + " where month=6 ", null);
            if (f != null) {
                if (f.moveToFirst()) {
                    do {
                        int a1 = f.getCount();
                        if (a1 < 1) {
                            return null;
                        }
                        int x = f.getInt(f.getColumnIndex("expense"));
                        expf = expf + x;
                    } while (f.moveToNext());
                    data.add(expf);
                }
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
            int expg = 0;
            Cursor g = null;
            g = db.rawQuery("select * from " + TB_name + " where month=7 ", null);
            if (g != null) {
                if (g.moveToFirst()) {
                    do {
                        int a1 = g.getCount();
                        if (a1 < 1) {
                            return null;
                        }
                        int x = g.getInt(g.getColumnIndex("expense"));
                        expg = expg + x;
                    } while (g.moveToNext());
                    data.add(expg);
                }
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
            int exph = 0;
            Cursor h = null;
            h = db.rawQuery("select * from " + TB_name + " where month=8 ", null);
            if (h != null) {
                if (h.moveToFirst()) {
                    do {
                        int a1 = h.getCount();
                        if (a1 < 1) {
                            return null;
                        }
                        int x = h.getInt(h.getColumnIndex("expense"));
                        exph = exph + x;
                    } while (h.moveToNext());
                    data.add(exph);
                }
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
            int expia = 0;
            Cursor ia = null;
            ia = db.rawQuery("select * from " + TB_name + " where month=9 ", null);
            if (ia != null) {
                if (ia.moveToFirst()) {
                    do {
                        int a1 = ia.getCount();
                        if (a1 < 1) {
                            return null;
                        }
                        int x = ia.getInt(ia.getColumnIndex("expense"));
                        expia = expia + x;
                    } while (ia.moveToNext());
                    data.add(expia);
                }
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
            int expja = 0;
            Cursor ja = null;
            ja = db.rawQuery("select * from " + TB_name + " where month=10 ", null);
            if (ja != null) {
                if (ja.moveToFirst()) {
                    do {
                        int a1 = ja.getCount();
                        if (a1 < 1) {
                            return null;
                        }
                        int x = ja.getInt(ja.getColumnIndex("expense"));
                        expja = expja + x;
                    } while (ja.moveToNext());
                    data.add(expja);
                }
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
            int expka = 0;
            Cursor ka = null;
            ka = db.rawQuery("select * from " + TB_name + " where month=11 ", null);
            if (ka != null) {
                if (ka.moveToFirst()) {
                    do {
                        int a1 = ka.getCount();
                        if (a1 < 1) {
                            return null;
                        }
                        int x = ka.getInt(ka.getColumnIndex("expense"));
                        expka = expka + x;
                    } while (ka.moveToNext());
                    data.add(expka);
                }
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
            int expla = 0;
            Cursor la = null;
            int s1;
            la = db.rawQuery("select * from " + TB_name + " where month=12 ", null);
            if (la != null) {
                if (la.moveToFirst()) {
                    System.out.println("hello......................");
                    do {
                        int a1 = la.getCount();
                        if (a1 < 1) {


                            return null;

                        }
                        int x = la.getInt(la.getColumnIndex("expense"));
                        expla = expla + x;
                    } while (la.moveToNext());
                    data.add(expla);
                }

            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();

            }
        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return data;

    }

    public ArrayList<Integer> totaldaywise() {

        ArrayList<Integer> data = new ArrayList<Integer>();
        db = this.getReadableDatabase();
        try {
            int y = 0;
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);
            y = mMonth + 1;
            int mDate = c.get(Calendar.DATE);
            String val = String.valueOf(mDate).toString();
            Cursor d = null;
            d = db.rawQuery("select expense from " + TB_name, null);
            if (d != null) {
                if (d.moveToFirst()) {
                    do {
                        int cc = d.getCount();
                        if (cc < 1) {
                            return null;
                        }
                        int x = d.getInt(d.getColumnIndex("expense"));
                        data.add(x);

                    }
                    while (d.moveToNext());
                }
                d.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();

            }

        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return data;
    }

    public ArrayList<Integer> timewise() {

        ArrayList<Integer> data = new ArrayList<Integer>();
        db = this.getReadableDatabase();
        try {
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            Date dat = new Date();
            String s1 = df.format(dat);
            int y = 0;
            final Calendar c = Calendar.getInstance();
            String mYear = String.valueOf(c.get(Calendar.YEAR));
            int mMonth = (c.get(Calendar.MONTH));
            String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
            y = mMonth + 1;
            String mon = String.valueOf(y);
            StringBuffer sb = new StringBuffer();
            String s = String.valueOf(sb.append(mDay).append("-").append(mon).append("-").append(mYear));
            int mDate = c.get(Calendar.DATE);

            String val = String.valueOf(mDate).toString();
            Cursor d = null;
            String[] columns = {"id", "expense", "cat", "description", "time", "date", "day", "month", "year"};
            String selection = "date=?";
            String[] selectionArgs = {s};
            Log.v("selection", selection);

            d = db.query(TB_name, columns, selection, selectionArgs, null, null, null);

            if (d != null) {
                if (d.moveToFirst()) {
                    do {
                        int cc = d.getCount();
                        if (cc < 1) {
                            return null;
                        }
                        int x = d.getInt(d.getColumnIndex("time"));
                        data.add(x);

                    }
                    while (d.moveToNext());
                }
                d.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();

            }

        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return data;
    }

    public ArrayList<Integer> daywise() {

        ArrayList<Integer> data = new ArrayList<Integer>();
        db = this.getReadableDatabase();
        try {
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            Date dat = new Date();
            String s1 = df.format(dat);
            int y = 0;
            final Calendar c = Calendar.getInstance();
            String mYear = String.valueOf(c.get(Calendar.YEAR));
            int mMonth = (c.get(Calendar.MONTH));
            String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
            y = mMonth + 1;
            String mon = String.valueOf(y);
            StringBuffer sb = new StringBuffer();
            String s = String.valueOf(sb.append(mDay).append("-").append(mon).append("-").append(mYear));
            int mDate = c.get(Calendar.DATE);

            String val = String.valueOf(mDate).toString();
            Cursor d = null;
            String[] columns = {"id", "expense", "cat", "description", "time", "date", "day", "month", "year"};
            String selection = "date=?";
            String[] selectionArgs = {s};
            Log.v("selection", selection);

            d = db.query(TB_name, columns, selection, selectionArgs, null, null, null);

            if (d != null) {
                if (d.moveToFirst()) {
                    do {
                        int cc = d.getCount();
                        if (cc < 1) {
                            return null;
                        }
                        int x = d.getInt(d.getColumnIndex("expense"));
                        data.add(x);

                    }
                    while (d.moveToNext());
                }
                d.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();

            }

        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return data;
    }

    public ArrayList<Integer> cattotal() {
        ArrayList<Integer> total = new ArrayList<Integer>();
        db = this.getReadableDatabase();
        int exp = 0;
        try {

            Cursor c = null;
            c = db.rawQuery("select * from " + TB_name + " where cat='Drinks' ", null);
            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        int a = c.getCount();
                        if (a < 1) {
                            return null;
                        }
                        int x = c.getInt(c.getColumnIndex("expense"));
                        exp = exp + x;
                    } while (c.moveToNext());
                    total.add(exp);
                }
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
            Cursor c1 = null;
            int exp1 = 0;
            c1 = db.rawQuery("select * from " + TB_name + " where cat='Dress' ", null);
            if (c1 != null) {
                if (c1.moveToFirst()) {
                    do {
                        int b = c1.getCount();
                        if (b < 1) {
                            return null;
                        }
                        int y = c1.getInt(c1.getColumnIndex("expense"));
                        exp1 = exp1 + y;
                    } while (c1.moveToNext());
                    total.add(exp1);
                }
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
            int exp2 = 0;
            Cursor c2 = null;
            c2 = db.rawQuery("select * from " + TB_name + " where cat='Food' ", null);
            if (c2 != null) {
                if (c2.moveToFirst()) {
                    do {
                        int b = c2.getCount();
                        if (b < 1) {
                            return null;
                        }
                        int y = c2.getInt(c2.getColumnIndex("expense"));
                        exp2 = exp2 + y;
                    } while (c2.moveToNext());
                    total.add(exp2);
                }
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
            int exp3 = 0;
            Cursor c3 = null;
            c3 = db.rawQuery("select * from " + TB_name + " where cat='Others' ", null);
            if (c3 != null) {
                if (c3.moveToFirst()) {
                    do {
                        int b = c3.getCount();
                        if (b < 1) {
                            return null;
                        }
                        int y = c3.getInt(c3.getColumnIndex("expense"));
                        exp3 = exp3 + y;
                    } while (c3.moveToNext());
                    total.add(exp3);
                }
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
            int exp4 = 0;
            Cursor c4 = null;
            c4 = db.rawQuery("select * from " + TB_name + " where cat='Personal' ", null);
            if (c4 != null) {
                if (c4.moveToFirst()) {
                    do {
                        int b = c4.getCount();
                        if (b < 1) {
                            return null;
                        }
                        int y = c4.getInt(c4.getColumnIndex("expense"));
                        exp4 = exp4 + y;
                    } while (c4.moveToNext());
                    total.add(exp4);
                }
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
            int exp5 = 0;
            Cursor c5 = null;
            c5 = db.rawQuery("select * from " + TB_name + " where cat='Utilities' ", null);
            if (c5 != null) {
                if (c5.moveToFirst()) {
                    do {
                        int b = c5.getCount();
                        if (b < 1) {
                            return null;
                        }
                        int y = c5.getInt(c5.getColumnIndex("expense"));
                        exp5 = exp5 + y;
                    } while (c5.moveToNext());
                    total.add(exp5);
                }
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }

        return total;
    }
}
