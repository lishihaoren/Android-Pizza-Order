package com.example.food.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.food.Model.ShoppingList;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {

    private static final String DB_NAME = "foodDB.db";
    private static final int DB_VER = 1;

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    public List<ShoppingList> getCarts(){

        SQLiteDatabase db =getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"ProductName", "ProductId", "Quantity", "Price", "Location"};
        String sqlTable = "ShoppingList";

        qb.setTables(sqlTable);
        Cursor c = qb.query(db, sqlSelect, null, null, null, null, null);

        final List<ShoppingList> result =new ArrayList<>();

        if (c.moveToFirst())
        {
            do{
                result.add(new ShoppingList(c.getString( c.getColumnIndex("ProductId")),
                        c.getString(c.getColumnIndex("ProductName")),
                        c.getString(c.getColumnIndex("Quantity")),
                        c.getString(c.getColumnIndex("Price")),
                        c.getString(c.getColumnIndex("Location"))
                        ));
            }while (c.moveToNext());
        }
        return result;

    }

    public void addToCart(ShoppingList shoppingList){

        SQLiteDatabase db = getReadableDatabase();
        String query =String.format("INSERT INTO ShoppingList(ProductId, ProductName, Quantity, Price, Location)VALUES('%s', '%s','%s','%s','%s');",
                shoppingList.getProductId(),
                shoppingList.getProductName(),
                shoppingList.getQuantity(),
                shoppingList.getPrice(),
                shoppingList.getLocation());

        db.execSQL(query);

    }

    public void cleanCart(){

        SQLiteDatabase db = getReadableDatabase();
        String query =String.format("DELETE FROM ShoppingList");

        db.execSQL(query);

    }


}
