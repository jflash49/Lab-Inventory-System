package com.inventory.lab.compsci.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.zxing.Result;
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
        public void handleResult(Result rawResult) {
            // Do something with the result here
            List<Item> items = SugarRecord.findAll(Item.class);

            Log.v(TAG, rawResult.getText()); // Prints scan results
            Log.v(TAG, rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)

            // If you would like to resume scanning, call this method below:
            mScannerView.resumeCameraPreview(this);
        }
}

