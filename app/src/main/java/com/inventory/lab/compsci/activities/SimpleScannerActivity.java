package com.inventory.lab.compsci.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.Result;
import com.inventory.lab.compsci.R;
import com.inventory.lab.compsci.models.Item;
import com.orm.SugarRecord;

import java.util.List;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by peoplesoft on 2/23/2016.
 */

public class SimpleScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
        private ZXingScannerView mScannerView;
        private final static String TAG ="Logging";

        @Override
        public void onCreate(Bundle state) {
            super.onCreate(state);
            mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
            setContentView(mScannerView);                // Set the scanner view as the content view
        }

        @Override
        public void onResume() {
            super.onResume();
            mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
            mScannerView.startCamera();          // Start camera on resume
        }

        @Override
        public void onPause() {
            super.onPause();
            mScannerView.stopCamera();           // Stop camera on pause
        }

        @Override
        public void handleResult(final Result rawResult) {
            // Do something with the result here
//            List<Item> items = SugarRecord.listAll(Item.class);
//            for (Item scanitem: items){
//                if (scanitem.getSerial().equals(rawResult.getText())){
                    Toast.makeText(getApplicationContext(),"Item Found : "+rawResult.getText(),Toast.LENGTH_SHORT).show();
//          final Context context = this;
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getApplicationContext());

// set title
            alertDialogBuilder.setTitle(R.string.item_scanned);
// set dialog message
            alertDialogBuilder
                    .setMessage("S/N :"+rawResult.getText())
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.ok,new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                           /* Intent i = new Intent(getApplicationContext(), UpdateActivity.class);
                            i.putExtra(rawResult.getText());
                            startActivity(i);*/

                            // if this button is clicked, close
                            // current activity
                            //MainActivity.this.finish();
                        }
                    })
                    .setNegativeButton(android.R.string.cancel,new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                        }
                    });

// create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

// show it
            alertDialog.show();
// }
//            }
            Log.v(TAG, rawResult.getText()); // Prints scan results
            Log.v(TAG, rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)

            // If you would like to resume scanning, call this method below:
            mScannerView.resumeCameraPreview(this);
        }
}

